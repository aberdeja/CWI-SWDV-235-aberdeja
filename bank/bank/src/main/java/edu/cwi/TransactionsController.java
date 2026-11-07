package edu.cwi;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String username;
    private double balance;
    private List<String> transactions;

    public UserAccount(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public static List<UserAccount> sampleAccounts() {
        List<UserAccount> accounts = new ArrayList<>();
        UserAccount account1 = new UserAccount("John Public", 500.00);
        account1.addTransaction("Transaction 1");
        account1.addTransaction("Transaction 2");

        UserAccount account2 = new UserAccount("Jane Doe", 750.00);
        account2.addTransaction("Transaction A");
        account2.addTransaction("Transaction B");

        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }
}