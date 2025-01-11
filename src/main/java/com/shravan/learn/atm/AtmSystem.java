package com.shravan.learn.atm;

import java.util.concurrent.atomic.AtomicInteger;

public class AtmSystem {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    public static final AtomicInteger counter = new AtomicInteger(0);

    public AtmSystem(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateUser(Card card) {
        //
    }

    public int balanceInquiry(String accountNumber) {
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdraw(String accountNumber, int amount) {
        Account account = bankingService.getAccount(accountNumber);
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance");
            return;
        }
        Transaction transaction = new WithdrawalTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash(amount);
    }

    public void deposit(String accountNumber, int amount) {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
    }

    private String generateTransactionId() {
        int i = counter.incrementAndGet();
        return "TXN" + i;
    }
}
