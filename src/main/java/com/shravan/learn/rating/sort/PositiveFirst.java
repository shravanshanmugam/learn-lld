package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;

import java.util.List;

public class PositiveFirst implements SortingStrategy {
    @Override
    public void sort(List<Rating> ratings) {
        ratings.sort((o1, o2) -> Integer.compare(o2.getRatingNumber().getNumber(), o1.getRatingNumber().getNumber()));
    }
}
