package com.shravan.learn.splitwise.split;

import com.shravan.learn.splitwise.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
