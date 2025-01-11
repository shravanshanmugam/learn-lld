package com.shravan.learn.atm;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    private final Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountNumber, int initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
