package com.shravan.learn.vendingmachine.state;

import com.shravan.learn.vendingmachine.Coin;
import com.shravan.learn.vendingmachine.Note;
import com.shravan.learn.vendingmachine.Product;
import com.shravan.learn.vendingmachine.VendingMachine;

public class ReadyState implements State {

    private final VendingMachine machine;

    public ReadyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Make payment");
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addCoin(coin);
        checkPaymentStatus();
    }
    @Override
    public void insertNote(Note note) {
        machine.addNote(note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("Make payment");
    }

    private void checkPaymentStatus() {
        if (machine.getTotalPayment() >= machine.getSelected().getPrice()) {
            machine.setState(machine.getDispense());
        }
    }
}
