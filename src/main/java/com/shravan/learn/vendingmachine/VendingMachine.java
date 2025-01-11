package com.shravan.learn.vendingmachine;

import com.shravan.learn.vendingmachine.state.*;

public class VendingMachine {
    private Inventory inventory;
    private final State idle;
    private final State ready;
    private final State dispense;
    private final State returnChange;
    private State current;
    private Product selected;
    private int totalPayment;
    private VendingMachine() {
        inventory = new Inventory();
        idle = new IdleState(this);
        ready = new ReadyState(this);
        dispense = new DispenseState(this);
        returnChange = new ReturnChangeState(this);
        current = idle;
        selected = null;
        totalPayment = 0;
    }
    private static VendingMachine instance = new VendingMachine();

    public static VendingMachine getInstance() {
        return instance;
    }

    public void selectProduct(Product product) {
        current.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        current.insertCoin(coin);
    }

    public void insertNote(Note note) {
        current.insertNote(note);
    }

    public void dispenseProduct() {
        current.dispenseProduct();
    }

    public void returnChange() {
        current.returnChange();
    }

    public void setState(State state) {
        current = state;
    }

    public Product getSelected() {
        return selected;
    }

    public void setSelected(Product selected) {
        this.selected = selected;
    }

    public void resetSelected() {
        selected = null;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        totalPayment += note.getValue();
    }

    public void resetPayment() {
        totalPayment = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public State getIdle() {
        return idle;
    }

    public State getReady() {
        return ready;
    }

    public State getDispense() {
        return dispense;
    }

    public State getReturnChange() {
        return returnChange;
    }
}
