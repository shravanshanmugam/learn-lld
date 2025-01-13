package com.shravan.learn.splitwise.split;

import com.shravan.learn.splitwise.User;

public class PercentSplit extends Split {
    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
