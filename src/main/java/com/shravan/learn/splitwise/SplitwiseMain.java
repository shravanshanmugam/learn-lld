package com.shravan.learn.splitwise;


import com.shravan.learn.splitwise.split.EqualSplit;
import com.shravan.learn.splitwise.split.ExactSplit;
import com.shravan.learn.splitwise.split.PercentSplit;

// SplitwiseSystem -> map Users, map Groups
// addExpense(groupId, Expense)

// User -> name, map balances (userId -> balance)
// Group -> name, createdBy User, Users, Expenses,
// Expense -> amount, description, paidBy User, list Splits
// Split -> User, amount
// SplitType -> EQUAL, PERCENTAGE, EXACT
// Transaction -> sender User, receiver User, amount
public class SplitwiseMain {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = SplitwiseService.getInstance();

        User alice = new User("1", "Alice");
        User bob = new User("2", "Bob");
        User charlie = new User("3", "Charlie");
        User dean = new User("4", "Dean");

        splitwiseService.addUser(alice);
        splitwiseService.addUser(bob);
        splitwiseService.addUser(charlie);
        splitwiseService.addUser(dean);

        Expense expense1 = createExpense1(alice, bob, charlie, dean);
        splitwiseService.addExpense(expense1);

        splitwiseService.simplify();
        splitwiseService.listTransactions();

        Expense expense2 = createExpense2(alice, bob, charlie, dean);
        splitwiseService.addExpense(expense2);

        splitwiseService.simplify();
        splitwiseService.listTransactions();
    }

    private static Expense createExpense1(User alice, User bob, User charlie, User dean) {
        Expense expense = new Expense("1", 300, alice);
        EqualSplit split1 = new EqualSplit(alice);
        EqualSplit split2 = new EqualSplit(bob);
        PercentSplit percentSplit = new PercentSplit(charlie, 20.0);
        ExactSplit exactSplit = new ExactSplit(dean, 100);

        expense.addSplit(split1);
        expense.addSplit(split2);
        expense.addSplit(percentSplit);
        expense.addSplit(exactSplit);
        return expense;
    }

    private static Expense createExpense2(User alice, User bob, User charlie, User dean) {
        Expense expense = new Expense("2", 600, dean);
        EqualSplit split1 = new EqualSplit(alice);
        EqualSplit split2 = new EqualSplit(bob);
        EqualSplit split3 = new EqualSplit(dean);

        expense.addSplit(split1);
        expense.addSplit(split2);
        expense.addSplit(split3);
        return expense;
    }
}
