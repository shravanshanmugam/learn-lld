package com.shravan.learn.vendingmachine.state;

import com.shravan.learn.vendingmachine.Coin;
import com.shravan.learn.vendingmachine.Note;
import com.shravan.learn.vendingmachine.Product;
import com.shravan.learn.vendingmachine.VendingMachine;

public class ReturnChangeState implements State {
    private final VendingMachine machine;

    public ReturnChangeState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Collect change");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Collect change");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Collect change");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Collect change");
    }

    @Override
    public void returnChange() {
        int change = machine.getTotalPayment() - machine.getSelected().getPrice();
        if (change > 0) {
            System.out.println("Returned : " + change);
        } else {
            System.out.println("No change to return");
        }
        machine.resetSelected();
        machine.resetPayment();
        machine.setState(machine.getIdle());
    }
}
