package com.shravan.learn.rating;

import lombok.Getter;

import java.util.*;

@Getter
public class Product {
    private final String productId;
    private final String name;
    private List<Rating> ratings;
    private Map<RatingNumber, Integer> count;
    private int ratingCount;
    private int reviewCount;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
        ratings = new ArrayList<>();
        count = new HashMap<>();
        ratingCount = 0;
        reviewCount = 0;
    }

    public synchronized Rating rate(RatingNumber ratingNumber, String title, String review, User user) {
        Rating rating = new Rating(ratingNumber, title, review, user);
        ratings.add(rating);
        Integer c = count.getOrDefault(ratingNumber, 0);
        count.put(ratingNumber, c + 1);
        ratingCount++;
        if (review != null && review.length() > 10) {
            reviewCount++;
        }
        return rating;
    }

    @Override
    public String toString() {
        return "{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", ratings=" + ratings +
                ", count=" + count +
                ", ratingCount=" + ratingCount +
                ", reviewCount=" + reviewCount +
                '}';
    }
}