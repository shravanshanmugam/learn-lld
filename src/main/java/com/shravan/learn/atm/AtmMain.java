package com.shravan.learn.atm;

public class AtmMain {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        bankingService.createAccount("1234567890", 1000);
        bankingService.createAccount("9876543210", 500);

        CashDispenser cashDispenser = new CashDispenser(10000);

        AtmSystem atmSystem = new AtmSystem(bankingService, cashDispenser);

        Card card = new Card("1234567890", "1234");
        atmSystem.authenticateUser(card);

        int balance1 = atmSystem.balanceInquiry("1234567890");
        System.out.println("balance1 = " + balance1);

        atmSystem.withdraw("1234567890", 500);
        atmSystem.deposit("9876543210", 200);

        int balance2 = atmSystem.balanceInquiry("1234567890");
        System.out.println("balance2 = " + balance2);

        int balance3 = atmSystem.balanceInquiry("9876543210");
        System.out.println("balance3 = " + balance3);
    }
}
