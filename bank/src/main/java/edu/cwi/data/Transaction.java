package edu.cwi.data;

import java.util.Date;

public class Transaction {
    private int id;
    private int accountId;
    private double amount;
    private TransactionType transactionType;
    public Date createdAt;
    private String description;
   

    public Transaction(String description) {
        this.description = description;
    }

    public Transaction(int id, int accountId, double amount, TransactionType transactionType, Date createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.createdAt = createdAt;

    }

    public Transaction() {
        this.setCreatedAt(new Date());
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
