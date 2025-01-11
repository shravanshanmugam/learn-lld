package com.shravan.learn.atm;

public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void debit(int amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
