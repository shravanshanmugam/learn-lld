package com.shravan.learn.wallet;

import java.math.BigDecimal;

public abstract class PaymentMethod {
    protected final String id;
    protected final String userId;

    protected PaymentMethod(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public abstract boolean processPayment(BigDecimal amount, Currency currency);
}
