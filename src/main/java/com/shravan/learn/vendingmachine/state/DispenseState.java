package com.shravan.learn.vendingmachine.state;

import com.shravan.learn.vendingmachine.*;

public class DispenseState implements State {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Collect product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Collect product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Collect product");
    }

    @Override
    public void dispenseProduct() {
        machine.setState(machine.getReady());

        Product selected = machine.getSelected();
        Inventory inventory = machine.getInventory();
        inventory.update(selected, inventory.getQuantity(selected) - 1);
        System.out.println("Dispense : " + selected.getName());
        machine.setState(machine.getReturnChange());
    }

    @Override
    public void returnChange() {
        System.out.println("Collect product");
    }
}
