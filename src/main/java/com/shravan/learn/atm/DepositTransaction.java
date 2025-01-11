package com.shravan.learn.atm;

public class DepositTransaction extends Transaction {
    public DepositTransaction(String transactionId, Account account, int amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
