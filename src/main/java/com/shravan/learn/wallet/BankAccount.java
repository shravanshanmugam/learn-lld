package com.shravan.learn.wallet;

import java.math.BigDecimal;

public class BankAccount extends PaymentMethod {
    private final String accountNumber;
    protected BankAccount(String id, String userId, String accountNumber) {
        super(id, userId);
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean processPayment(BigDecimal amount, Currency currency) {
        // Process bank account payment
        return true;
    }
}
