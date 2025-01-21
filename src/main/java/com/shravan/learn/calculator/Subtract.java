package com.shravan.learn.calculator;

public class Subtract implements Operation {
    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}
