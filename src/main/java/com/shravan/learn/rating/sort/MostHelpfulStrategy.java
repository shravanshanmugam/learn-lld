package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;

import java.util.List;

public class MostHelpfulStrategy implements SortingStrategy {
    @Override
    public void sort(List<Rating> ratings) {
        // consider - length (>200 characters), specificity, location (local guide), keywords, photos, recency
        // ranking = weighted sum of input
        // don't consider - likes on review, response from business owner,
        // review sentiment i.e. positive and negative are treated equally
    }
}
