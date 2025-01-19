package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;

import java.util.List;

public interface SortingStrategy {

    void sort(List<Rating> ratings);
}
