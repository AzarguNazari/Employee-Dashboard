package com.dashboard.useful.controller;

import com.backend.exception.*;
import com.backend.modal.BankAccount;
import com.backend.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@EnableBinding(Source.class)
@RestController
@RequestMapping("/v1/api")
@CrossOrigin
public class BankAccountController implements BankAccountControllerInterface {

    private static final Logger LOG = LoggerFactory.getLogger(BankAccountController.class);

    @Autowired
    BankAccountService bankAccountService;

    @Override
    @GetMapping("/accounts")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        LOG.info("all accounts are requested");
        return new ResponseEntity<>(bankAccountService.findAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping("/accounts")
    @ExceptionHandler({InvalidBalanceException.class, InvalidBalanceException.class, Exception.class})
    public ResponseEntity<?> addNewAccount(@RequestBody BankAccount bankAccount) {
        try {
            bankAccountService.addNewAccount(bankAccount);
            LOG.info("new account {} is added", bankAccount);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AccountExistException ex) {
            LOG.debug("account {} is already existed", bankAccount);
            return new ResponseEntity<>(new ApiError("account with id " + bankAccount.getAccountNumber() + " is already existed", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        } catch (AccountNameException ex) {
            LOG.debug("account name is not correct", bankAccount);
            return new ResponseEntity<>(new ApiError("account name " + bankAccount.getAccountHolder() + " is not valid", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        } catch (InvalidBalanceException ex) {
            LOG.debug("received balance is not correct", bankAccount);
            return new ResponseEntity<>(new ApiError("received balance of " + bankAccount.getBalance() + " is not correct", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        } catch (InvalidIBANException ex) {
            LOG.debug("received IBAN is not correct", bankAccount);
            return new ResponseEntity<>(new ApiError("Please enter a correct IBAN or the IBAN is already used", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            LOG.info("interal server error", ex.getMessage());
            return new ResponseEntity<>(new ApiError("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping("/accounts/{accountNumber}")
    @ExceptionHandler({BankAccountNotFoundException.class})
    public ResponseEntity<?> getBankAccount(@PathVariable Long accountNumber) {
        try {
            BankAccount byAccountNumber = bankAccountService.findByAccountNumber(accountNumber);
            return new ResponseEntity<>(byAccountNumber, HttpStatus.OK);
        } catch (BankAccountNotFoundException ex) {
            LOG.info("Account with id {} is not found", accountNumber);
            return new ResponseEntity<>(new ApiError("Account with id " + accountNumber + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountNumber) {
        try {
            bankAccountService.deleteAccount(accountNumber);
            LOG.info("Account with id {} is deleted", accountNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (BankAccountNotFoundException ex) {
            LOG.info("Account with id {} is not found", accountNumber);
            return new ResponseEntity<>(new ApiError("Account with id " + accountNumber + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PutMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> updateAccount(@PathVariable Long accountNumber, @RequestBody BankAccount newAccountDetails) {
        try {
            bankAccountService.updateAccount(accountNumber, newAccountDetails);
            LOG.info("Account with id {} is updated", accountNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AccountExistException ex) {
            LOG.info("Account with id {} is valid", newAccountDetails.getAccountNumber());
            return new ResponseEntity<>(new ApiError("Account with id " + newAccountDetails.getAccountNumber() + " is not valid", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        } catch (BankAccountNotFoundException ex) {
            LOG.info("Account with id {} is not found", accountNumber);
            return new ResponseEntity<>(new ApiError("Account with id " + accountNumber + " is not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }
}
