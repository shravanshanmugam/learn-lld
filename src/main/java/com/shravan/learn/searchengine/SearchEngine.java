package com.shravan.learn.searchengine;

import com.shravan.learn.searchengine.index.InvertedIndex;
import com.shravan.learn.searchengine.model.Document;
import com.shravan.learn.searchengine.model.DocumentIndex;
import com.shravan.learn.searchengine.sort.SortBy;
import com.shravan.learn.searchengine.sort.SortStrategy;
import com.shravan.learn.searchengine.sort.SortStrategyFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchEngine {
    private final InvertedIndex index;
    private final SortStrategyFactory sortStrategyFactory;

    public SearchEngine() {
        sortStrategyFactory = SortStrategyFactory.getInstance();
        index = InvertedIndex.getInstance();
    }

    List<Document> search(String query, SortBy sortBy) {
        if (query == null || query.length() == 0) throw new IllegalArgumentException("invalid query");
        // pre-process -> token
        String[] queryToken = query.trim().toLowerCase().split(" ");
        // for each token find list of documents containing the token
        Set<DocumentIndex> documents = new HashSet<>(index.search(queryToken[0]));
        if (documents.size()==0) return new ArrayList<>();
        for (int i = 1; i < queryToken.length; i++) {
            String qt = queryToken[i];
            Set<DocumentIndex> result = new HashSet<>(index.search(qt));
             if (result.size() == 0) return new ArrayList<>();
            // intersect of all the documents
            documents.retainAll(result);
        }
        // rank output -> how many tokens are matching

        // apply sorting strategy
        SortStrategy sortStrategy = sortStrategyFactory.createSortStrategy(sortBy);
        List<DocumentIndex> unsortedDocs = new ArrayList<>(documents);
        sortStrategy.sort(unsortedDocs, queryToken);
        return unsortedDocs.stream().map(DocumentIndex::getDocument).collect(Collectors.toList());
    }

    public  void print() {
        index.print();
    }

}

