package com.shravan.learn.calculator;

public class Calculator {

    public double calculate(double a, double b, char op) {
        return createOperation(op).operate(a, b);
    }

    private static Operation createOperation(char op) {
        switch (op) {
            case '+':
                return new Add();
            case '-':
                return new Subtract();
            case '*':
                return new Multiply();
            case '/':
                return new Divide();
        }
        throw new IllegalArgumentException("invalid operation " + op);
    }
}
