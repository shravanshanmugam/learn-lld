package com.shravan.learn.coffeemachine;

// CoffeeMachine -> Coffees (menu), Ingredients
// Coffee -> name, price, recipe -> Ingredient, quantity (for recipe)
// Ingredient -> name, quantity
public class CoffeeMachineMain {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        // display menu
        coffeeMachine.displayMenu();

        // buy espresso
        coffeeMachine.dispenseCoffee(coffeeMachine.selectCoffee("espresso"), new Payment(30));

        // buy cappuccino
        coffeeMachine.dispenseCoffee(coffeeMachine.selectCoffee("cappuccino"), new Payment(35));

        // buy latte
        coffeeMachine.dispenseCoffee(coffeeMachine.selectCoffee("latte"), new Payment(40));
    }
}
