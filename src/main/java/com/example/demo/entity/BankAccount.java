package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class BankAccount {

    @Id
    private Long bankId;
    private String accountNumber;
    private String accountHolderName;
    private String ifscNumber;
    private String bankName;
    private String bankBranch;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscNumber() {
        return ifscNumber;
    }

    public void setIfscNumber(String ifscNumber) {
        this.ifscNumber = ifscNumber;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolderName() {return accountHolderName;}

    public void setAccountHolderName(String accountHolderName) {this.accountHolderName = accountHolderName;}
}
