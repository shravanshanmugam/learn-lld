package com.shravan.learn.splitwise.split;

import com.shravan.learn.splitwise.User;
import lombok.Getter;
import lombok.Setter;

public abstract class Split {
    @Getter
    protected User user;
    @Setter
    protected double amount;

    public Split(User user) {
        this.user = user;
    }

    public abstract double getAmount();

    public abstract int getPriority();
}
