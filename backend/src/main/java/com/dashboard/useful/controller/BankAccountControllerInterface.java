package com.dashboard.useful.controller;

import com.backend.modal.BankAccount;
import org.springframework.http.ResponseEntity;

public interface BankAccountControllerInterface {
    ResponseEntity<?> getAllBankAccounts();

    ResponseEntity<?> addNewAccount(BankAccount bankAccount);

    ResponseEntity<?> getBankAccount(Long accountNumber);

    ResponseEntity<?> deleteAccount(Long accountNumber);

    ResponseEntity<?> updateAccount(Long accountNumber, BankAccount bankAccount);
}
