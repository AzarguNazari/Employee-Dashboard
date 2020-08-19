package com.dashboard.useful.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    private Long accountNumber;
    @Column
    private String accountHolder;
    @Column
    private double balance;
    @Column
    private String iban;
}