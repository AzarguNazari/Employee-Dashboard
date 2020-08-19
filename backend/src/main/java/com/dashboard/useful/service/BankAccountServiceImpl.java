package com.dashboard.useful.service;

import com.backend.common.Util;
import com.backend.exception.*;
import com.backend.modal.BankAccount;
import com.backend.repository.BankAccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void addNewAccount(BankAccount bankAccount) {

        Optional<BankAccount> findByAccount = bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber());
        Optional<BankAccount> byIban = bankAccountRepository.findByIban(bankAccount.getIban());

        if (findByAccount.isPresent()) throw new AccountExistException();
        if (byIban.isPresent() || !Util.isIBANvalid(bankAccount.getIban())) throw new InvalidIBANException();
        if (bankAccount.getAccountHolder().trim().length() == 0) throw new AccountNameException();
        if (bankAccount.getAccountNumber() < 0) throw new InvalidBalanceException();

        bankAccountRepository.save(bankAccount);
        LOG.info("New account with info {} is added", bankAccount);
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        Optional<BankAccount> byId = bankAccountRepository.findByAccountNumber(accountNumber);
        if (byId.isPresent()) {
            bankAccountRepository.deleteById(accountNumber);
            LOG.info("Account with id {} is deleted", accountNumber);
        } else throw new BankAccountNotFoundException();
    }

    @Override
    public void updateAccount(Long accountNumber, BankAccount bankAccount) {

        if (bankAccount.getAccountNumber() != accountNumber) throw new AccountExistException();

        BankAccount foundAccount = bankAccountRepository.findByAccountNumber(accountNumber).orElse(null);
        if (foundAccount != null) {
            foundAccount.setBalance(bankAccount.getBalance());
            foundAccount.setIban(bankAccount.getIban());
            foundAccount.setAccountHolder(bankAccount.getAccountHolder());
            foundAccount.setAccountNumber(accountNumber);
            bankAccountRepository.deleteById(accountNumber);
            bankAccountRepository.save(bankAccount);
            LOG.info("Account with id {} is updated", bankAccount);

            try {
                this.rabbitTemplate.convertAndSend("queue.bankAccounts", new ObjectMapper().writeValueAsString(bankAccount));
            } catch (Exception ex) {
                LOG.debug("Data {} cannot be sent to queue", bankAccount);
                ex.printStackTrace();
            }
        } else throw new BankAccountNotFoundException();
    }

    @Override
    public BankAccount findByAccountNumber(Long id) {
        Optional<BankAccount> byAccountNumber = bankAccountRepository.findByAccountNumber(id);
        if (byAccountNumber.isPresent()) return byAccountNumber.get();
        else throw new BankAccountNotFoundException();
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }
}
