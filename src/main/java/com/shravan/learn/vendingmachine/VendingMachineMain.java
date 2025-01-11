package com.shravan.learn.vendingmachine;

// select product -> insert coins + insert notes -> dispense product -> return change
// VendingMachine -> Inventory + states + current state + selected product + payment -> Product -> name, price
public class VendingMachineMain {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        Inventory inventory = vendingMachine.getInventory();
        Product coke = new Product("coke", 20);
        Product pepsi = new Product("pepsi", 20);
        Product water = new Product("water", 10);

        inventory.add(coke, 5);
        inventory.add(pepsi, 3);
        inventory.add(water, 2);

        // select product
        vendingMachine.selectProduct(coke);

        // insert coins
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertNote(Note.TEN);

        // dispense product
        vendingMachine.dispenseProduct();

        // return change
        vendingMachine.returnChange();

        // select product
        vendingMachine.selectProduct(water);

        // insufficient payment
        vendingMachine.insertCoin(Coin.FIVE);

        // try dispense product
        vendingMachine.dispenseProduct();

        // insert more coins
        vendingMachine.insertNote(Note.TWENTY);

        // dispense product
        vendingMachine.dispenseProduct();

        // return change
        vendingMachine.returnChange();
    }
}
