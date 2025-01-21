package com.shravan.learn.searchengine.sort;

import com.shravan.learn.searchengine.model.DocumentIndex;

import java.util.List;

public interface SortStrategy {
    void sort(List<DocumentIndex> documents, String[] queryToken);
}