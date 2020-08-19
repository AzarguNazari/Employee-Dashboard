package com.dashboard.useful.service;

import com.backend.modal.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountService {
    void addNewAccount(BankAccount BankAccount);

    void deleteAccount(Long accountNumber);

    void updateAccount(Long accountNumber, BankAccount BankAccount);

    BankAccount findByAccountNumber(Long accountNumber);

    List<BankAccount> findAll();
}
