package com.shravan.learn.vendingmachine.state;

import com.shravan.learn.vendingmachine.Coin;
import com.shravan.learn.vendingmachine.Note;
import com.shravan.learn.vendingmachine.Product;

public interface State {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
