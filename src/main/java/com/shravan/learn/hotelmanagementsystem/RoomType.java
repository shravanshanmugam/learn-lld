package com.shravan.learn.hotelmanagementsystem;

public enum RoomType {
    SINGLE(100), DOUBLE(200), DELUXE(250), SUITE(400);

    private final int price;
    RoomType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
