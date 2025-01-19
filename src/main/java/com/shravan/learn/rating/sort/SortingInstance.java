package com.shravan.learn.rating.sort;

import com.shravan.learn.rating.Rating;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingInstance {
    @Getter
    private static final SortingInstance instance = new SortingInstance();
    private final Map<SortBy, SortingStrategy> sortingStrategy;
    private SortingInstance() {
        sortingStrategy = new HashMap<>();
        sortingStrategy.put(SortBy.MOST_HELPFUL, new MostHelpfulStrategy());
        sortingStrategy.put(SortBy.MOST_RECENT, new MostRecentStrategy());
        sortingStrategy.put(SortBy.POSITIVE_FIRST, new PositiveFirst());
        sortingStrategy.put(SortBy.NEGATIVE_FIRST, new NegativeFirst());
    }

    public void sort(SortBy sortBy, List<Rating> ratings) {
        sortingStrategy.get(sortBy).sort(ratings);
    }

    public List<SortBy> getSortBy() {
        return new ArrayList<>(sortingStrategy.keySet());
    }

}
