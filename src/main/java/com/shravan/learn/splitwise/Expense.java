package com.shravan.learn.splitwise;

import com.shravan.learn.splitwise.split.Split;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Expense {
    private final String id;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;

    public Expense(String id, double amount, User paidBy) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        splits = new ArrayList<>();
    }

    public void addSplit(Split split) {
        splits.add(split);
    }
}
