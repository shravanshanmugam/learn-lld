package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;

import java.util.List;

public class MostRecentStrategy implements SortingStrategy {
    @Override
    public void sort(List<Rating> ratings) {
        ratings.sort(((o1, o2) -> o2.getRatedAt().compareTo(o1.getRatedAt())));
    }
}
