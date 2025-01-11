package com.shravan.learn.coffeemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    public static final CoffeeMachine instance = new CoffeeMachine();
    private List<Coffee> menu;
    private final Map<String, Ingredient> ingredients;

    private CoffeeMachine() {
        menu = new ArrayList<>();
        ingredients = new HashMap<>();

        initializeIngredients();
        initializeMenu();
    }

    public static CoffeeMachine getInstance() {
        return instance;
    }

    private void initializeIngredients() {
        ingredients.put("water", new Ingredient("water", 10));
        ingredients.put("coffee", new Ingredient("milk", 10));
        ingredients.put("milk", new Ingredient("coffee", 10));
    }

    private void initializeMenu() {
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("coffee"), 1);
        espressoRecipe.put(ingredients.get("water"), 1);
        Coffee espresso = new Coffee("espresso", 25, espressoRecipe);
        menu.add(espresso);

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("coffee"), 1);
        cappuccinoRecipe.put(ingredients.get("water"), 1);
        cappuccinoRecipe.put(ingredients.get("milk"), 1);
        Coffee cappuccino = new Coffee("cappuccino", 35, cappuccinoRecipe);
        menu.add(cappuccino);

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredients.get("coffee"), 1);
        latteRecipe.put(ingredients.get("water"), 1);
        latteRecipe.put(ingredients.get("milk"), 2);
        Coffee latte = new Coffee("latte", 40, latteRecipe);
        menu.add(latte);
    }

    public void displayMenu() {
        for (Coffee coffee : menu) {
            System.out.println(coffee.getName() + " Rs." + coffee.getPrice());
        }
    }

    public Coffee selectCoffee(String name) {
        for (Coffee coffee : menu) {
            if (coffee.getName().equals(name)) {
                return coffee;
            }
        }
        return null;
    }

    public void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getName());
                int change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("collect change Rs." + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getName());
            }
        } else {
            System.out.println("Insufficient payment for " + coffee.getName());
        }
    }

    public boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer quantity = entry.getValue();
            if (ingredient.getQuantity() < quantity) return false;
        }
        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer quantity = entry.getValue();
            ingredient.updateQuantity(-quantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory : " + ingredient.getName());
            }
        }
    }
}
