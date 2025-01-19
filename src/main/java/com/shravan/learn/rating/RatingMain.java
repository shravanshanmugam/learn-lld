package com.shravan.learn.rating;

import com.shravan.learn.rating.sort.SortBy;

import java.util.List;

public class RatingMain {
    public static void main(String[] args) throws InterruptedException {
        RatingSystem ratingSystem = new RatingSystem();
        Product product = new Product("p0001", "TV");
        ratingSystem.addProduct(product);
        User user1 = new User(1);
        User user2 = new User(2);
        ratingSystem.rate("p0001", 5, "great product 1", "this is a really great product man loved it", user1);
        ratingSystem.rate("p0001", 3, "great product 2", "ok", user1);
        ratingSystem.rate("p0001", 2, "great product 3", "alright", user2);

        List<Rating> ratings = ratingSystem.getRatings("p0001", SortBy.NEGATIVE_FIRST);
        System.out.println("ratings = " + ratings);

        System.out.println("product = " + product);
    }
}
