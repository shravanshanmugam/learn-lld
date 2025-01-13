package com.shravan.learn.wallet;

import java.math.BigDecimal;

// WalletSystem -> map Users, map Accounts, map PaymentMethods,
// createUser, getUser, createAccount, getAccount, addPaymentMethod, getPaymentMethod
// transferFunds(source Account, destination Account, amount, Currency)
// -> convert amount to source Account Currency and withdraw,
// -> convert amount to destination Account Currency and deposit
// -> add Transaction to both source and destination Account

// User -> name, email, password, Accounts,
// Account -> User, accountNumber, Currency, balance, Transactions, deposit, withdraw, addTransaction
// Transaction -> source Account, destination Account, Currency, amount, timestamp
// PaymentMethod (abstract) -> CreditCard, BankAccount
public class WalletMain {
    public static void main(String[] args) {

    }

    // A: INR 86 (USD 1), B: JPY 158 (USD 1)
    // A transfer USD 1 to B
    // convert USD 1 to INR and withdraw from A
    // A: INR 0 (USD 0)
    // convert USD 1 to JPY and deposit to B
    // B: JPY 316 (USD 2)
    public void transferFunds(String sourceAccount, String destinationAccount, BigDecimal amount, Currency currency) {
        // if sourceAccount currency != currency -> convert amount to sourceAccount currency
        // sourceAccount.withdraw(amount)

        // if destinationAccount currency != currency -> convert amount to destinationAccount currency
        // destinationAccount.deposit(amount)

        // createTransaction
        // sourceAccount.addTransaction(transaction)
        // destinationAccount.addTransaction(transaction)
    }
}
