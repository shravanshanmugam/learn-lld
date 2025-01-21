package com.shravan.learn.calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double multiply = calculator.calculate(2, 4, '*');
        System.out.println("multiply = " + multiply);
        double divide = calculator.calculate(2, 4, '/');
        System.out.println("divide = " + divide);
        double subtract = calculator.calculate(2, 4, '-');
        System.out.println("subtract = " + subtract);
        double add = calculator.calculate(2, 4, '+');
        System.out.println("add = " + add);
    }
}
