package com.shravan.learn.calculator;

public class Add implements Operation {
    @Override
    public double operate(double a, double b) {
        return a + b;
    }
}
