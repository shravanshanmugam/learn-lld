package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;

import java.util.Comparator;
import java.util.List;

public class NegativeFirst implements SortingStrategy {
    @Override
    public void sort(List<Rating> ratings) {
        ratings.sort(Comparator.comparingInt(o -> o.getRatingNumber().getNumber()));
    }
}
