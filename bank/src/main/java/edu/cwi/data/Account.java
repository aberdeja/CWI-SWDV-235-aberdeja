package edu.cwi.data;

import java.math.BigDecimal;

public class Account {
    private int account;
    public Account(int account, int id, int userId, Double balance, AccountType accountType) {
        this.account = account;
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account() {
        this.accountType = AccountType.CHECKING;
    }

    private int id;
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private int userId;
    private double balance;
    private AccountType accountType;
    public int getAccountId() {
        return account;
    }
    public void setAccountId(int account) {
        this.account = account;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    
}