package com.shravan.learn.splitwise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class User {
    private final String id;
    private final String name;
    private Map<String, Double> balances = new HashMap<>();
    @Setter
    private double netAmount;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", netAmount=" + netAmount +
                '}';
    }

    public String balances() {
        return "{" +
                "name='" + name + '\'' +
                ", balances=" + balances +
                ", netAmount=" + netAmount +
                '}';
    }
}
