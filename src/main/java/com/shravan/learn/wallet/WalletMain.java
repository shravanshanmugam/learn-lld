package com.shravan.learn.wallet;

import java.math.BigDecimal;

// WalletSystem -> Users, Accounts, PaymentMethods,
//                 createUser, getUser, createAccount, getAccount, addPaymentMethod, getPaymentMethod
// User -> name, email, password, Accounts
// Account -> User, accountNumber, Currency, balance, Transactions, deposit, withdraw, addTransaction
// Transaction -> source Account, destination Account, currency, amount, timestamp
// PaymentMethod (abstract) -> CreditCard, BankAccount
public class WalletMain {
    public static void main(String[] args) {

    }

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
