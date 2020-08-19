package com.dashboard.useful.repository;

import com.backend.modal.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    Optional<BankAccount> findByAccountNumber(Long accountNumber);

    Optional<BankAccount> findByIban(String IBAN);

    List<BankAccount> findAll();
}