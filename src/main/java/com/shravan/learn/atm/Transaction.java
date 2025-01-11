package com.shravan.learn.atm;

public abstract class Transaction {
    protected final String transactionId;
    protected final Account account;
    protected final int amount;

    public Transaction(String transactionId, Account account, int amount) {
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();
}
