package com.shravan.learn.rating;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Product {
    private final String productId;
    private final String name;
    private final CopyOnWriteArrayList<Rating> ratings;
    private final ConcurrentHashMap<RatingNumber, AtomicInteger> count;
    private final AtomicInteger ratingCount;
    private final AtomicInteger reviewCount;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
        ratings = new CopyOnWriteArrayList<>();
        count = new ConcurrentHashMap<>();
        ratingCount = new AtomicInteger(0);
        reviewCount = new AtomicInteger(0);
    }

    public Rating rate(RatingNumber ratingNumber, String title, String review, User user) {
        Rating rating = new Rating(ratingNumber, title, review, user);
        ratings.add(rating);
        count.computeIfAbsent(ratingNumber,  k -> new AtomicInteger(0)).incrementAndGet();
        ratingCount.incrementAndGet();
        if (review != null && review.length() > 10) {
            reviewCount.incrementAndGet();
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