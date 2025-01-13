package com.shravan.learn.splitwise;

import com.shravan.learn.splitwise.split.ExactSplit;
import com.shravan.learn.splitwise.split.PercentSplit;
import com.shravan.learn.splitwise.split.Split;
import lombok.Getter;

import java.util.*;

public class SplitwiseService {
    private final Map<String, User> users;

    @Getter
    private static final SplitwiseService instance = new SplitwiseService();

    private SplitwiseService() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addExpense(Expense expense) {
        expense.getSplits().sort(Comparator.comparingInt(Split::getPriority));
        splitExpense(expense);
        updateBalances(expense);
    }

    private void splitExpense(Expense expense) {
        double amount = expense.getAmount();
        List<Split> splits = expense.getSplits();

        double remaining = amount;
        List<Split> exactSplits = new ArrayList<>();
        for (Split split : splits) {
            if (split instanceof PercentSplit) {
                PercentSplit percentSplit = (PercentSplit) split;
                double percentSplitAmount = amount * percentSplit.getPercent() / 100.0;
                split.setAmount(percentSplitAmount);
                remaining -= percentSplitAmount;
            } else if (split instanceof ExactSplit) {
                remaining -= split.getAmount();
            } else {
                exactSplits.add(split);
            }
        }
        if (remaining < 0) throw new IllegalStateException("invalid split");
        double equal = remaining / exactSplits.size();
        for (Split exactSplit : exactSplits) {
            exactSplit.setAmount(equal);
        }
    }

    private void updateBalances(Expense expense) {
        for (Split split : expense.getSplits()) {
            User paidBy = expense.getPaidBy();
            User user = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(user)) {
                updateBalance(paidBy, user, amount);
                updateBalance(user, paidBy, -amount);
            }
        }
    }

    private void updateBalance(User user1, User user2, double amount) {
        String balanceKey = getBalanceKey(user1, user2);
        double updatedAmount = user1.getBalances().getOrDefault(balanceKey, 0.0) + amount;
        user1.getBalances().put(balanceKey, updatedAmount);
    }

    private String getBalanceKey(User user1, User user2) {
        return user1.getId() + ":" + user2.getId();
    }

    public void printBalances() {
        System.out.println("*****Balances*****");
        for (User user : users.values()) {
            System.out.println(user.balances());
        }
        System.out.println("=====");
    }

    public void simplify() {
        for (User user : users.values()) {
            Map<String, Double> balances = user.getBalances();
            double netAmount = 0;
            for (Double value : balances.values()) {
                netAmount += value;
            }
            user.setNetAmount(netAmount);
        }
        printBalances();
    }

    public void listTransactions() {
        System.out.println("*****Transactions*****");
        TreeSet<User> sorted = new TreeSet<>(Comparator.comparingDouble((User::getNetAmount)));
        sorted.addAll(users.values());
        User empty = new User("0", "empty");
        empty.setNetAmount(0d);
        while (!sorted.isEmpty()) {
            User lower = sorted.lower(empty);
            double l = lower.getNetAmount();
            User higher = sorted.higher(empty);
            double h = higher.getNetAmount();
            if (h + l == 0) {
                System.out.println(lower.getName() + "->" + higher.getName() + " = " + higher.getNetAmount());
                sorted.remove(lower);
                sorted.remove(higher);
            } else if (h + l > 0) {
                System.out.println(lower.getName() + "->" + higher.getName() + " = " + lower.getNetAmount());
                sorted.remove(lower);
                higher.setNetAmount(h+l);
            } else if (h + l < 0) {
                System.out.println(lower.getName() + "->" + higher.getName() + " = " + higher.getNetAmount());
                sorted.remove(higher);
                lower.setNetAmount(h + l);
            }
        }
        System.out.println("=====");
    }
}
