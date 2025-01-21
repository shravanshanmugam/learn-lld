package com.shravan.learn.searchengine.sort;

import com.shravan.learn.searchengine.model.DocumentIndex;

import java.util.List;

public class MostRecentStrategy implements SortStrategy {
    public void sort(List<DocumentIndex> documents, String[] queryToken) {
        // decreasing order of created timestamp
        documents.sort(((o1, o2) -> o2.getDocument().getCreatedAt().compareTo(o1.getDocument().getCreatedAt())));
    }
}
