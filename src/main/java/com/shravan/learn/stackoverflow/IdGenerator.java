package com.shravan.learn.stackoverflow;

public class IdGenerator {
    public static int generate() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
