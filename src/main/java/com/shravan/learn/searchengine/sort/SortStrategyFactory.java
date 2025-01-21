package com.shravan.learn.searchengine.sort;

public class SortStrategyFactory {

    private static volatile SortStrategyFactory INSTANCE;

    private SortStrategyFactory() {
        //
    }

    public static SortStrategyFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SortStrategyFactory();
        }
        return INSTANCE;
    }
    public static SortStrategy createSortStrategy(SortBy sortBy) {
        if (sortBy.equals(SortBy.MOST_RECENT)) {
            return new MostRecentStrategy();
        } else if (sortBy.equals(SortBy.MOST_FREQUENT)) {
            return new MostFrequentStrategy();
        }
        // default
        return new MostRecentStrategy();
    }
}
