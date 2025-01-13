package com.shravan.learn.snakeandladder;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Dice {
    private final int id;
    private final static Random random = new Random();

    public int roll() {
        return 1 + random.nextInt(6);
    }
}
