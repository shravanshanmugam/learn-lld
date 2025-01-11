package com.shravan.learn.coffeemachine;

import java.util.Map;

public class Coffee {
    private final String name;
    private final int price;
    private final Map<Ingredient, Integer> recipe;

    public Coffee(String name, int price, Map<Ingredient, Integer> recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}
