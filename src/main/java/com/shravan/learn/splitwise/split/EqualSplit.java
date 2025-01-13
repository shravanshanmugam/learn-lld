package com.shravan.learn.splitwise.split;

import com.shravan.learn.splitwise.User;

public class EqualSplit extends Split {
    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
