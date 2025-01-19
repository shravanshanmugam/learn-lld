package com.shravan.learn.rating;

import com.shravan.learn.rating.sort.SortBy;
import com.shravan.learn.rating.sort.SortingInstance;

import java.util.*;

public class RatingSystem {
    private final Map<String, Product> products;
    private final Map<Integer, RatingNumber> ratingNumbers;
    private final SortingInstance sortingInstance;
    public RatingSystem() {
        products = new HashMap<>();
        ratingNumbers = new HashMap<>();
        ratingNumbers.put(1, new RatingNumber(1));
        ratingNumbers.put(2, new RatingNumber(2));
        ratingNumbers.put(3, new RatingNumber(3));
        ratingNumbers.put(4, new RatingNumber(4));
        ratingNumbers.put(5, new RatingNumber(5));
        sortingInstance = SortingInstance.getInstance();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Rating rate(String productId, int rateNumber, String title, String review, User user) {
        RatingNumber ratingNumber = ratingNumbers.get(rateNumber);
        Product product = products.get(productId);
        Optional<Rating> first = product.getRatings()
                .stream()
                .filter(rating -> rating.getUser().equals(user))
                .findFirst();
        if (first.isPresent()) {
            System.out.println("Already reviewed by " + user);
            return null;
        }
        return product.rate(ratingNumber, title, review, user);
    }



    public List<Rating> getRatings(String productId, SortBy sortBy) {
        Product product = products.get(productId);
        List<Rating> ratings = new ArrayList<>(product.getRatings());
        sortingInstance.sort(sortBy, ratings);
        return ratings;
    }
}
