package com.shravan.learn.vendingmachine.state;

import com.shravan.learn.vendingmachine.Coin;
import com.shravan.learn.vendingmachine.Note;
import com.shravan.learn.vendingmachine.Product;
import com.shravan.learn.vendingmachine.VendingMachine;

public class IdleState implements State {

    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        if (machine.getInventory().isAvailable(product)) {
            machine.setSelected(product);
            machine.setState(machine.getReady());
            System.out.println("Product selected : " + product.getName());
        } else {
            System.out.println("Product not available : " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("select product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("select product");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("select product");
    }

    @Override
    public void returnChange() {
        System.out.println("select product");
    }
}
