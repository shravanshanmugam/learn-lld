package com.shravan.learn.searchengine.index;

import com.shravan.learn.searchengine.model.Document;
import com.shravan.learn.searchengine.model.DocumentIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {
    private final Map<String, List<DocumentIndex>> indexData;

    private InvertedIndex() {
        indexData = new HashMap<>();
    }

    private static InvertedIndex instance = null;

    public static InvertedIndex getInstance() {
        if (instance == null) {
            instance = new InvertedIndex();
        }
        return instance;
    }

    public void createIndex(Document document) {
        // to lower case and split by space into words
        DocumentIndex documentIndex = new DocumentIndex(document);
        // sanitize - special characters, lower case, stop words - a, an, the
        String[] words = document.getContent().toLowerCase().split(" ");
        for (String word : words) {
            List<DocumentIndex> existingDocs = indexData.getOrDefault(word, new ArrayList<>());
            existingDocs.add(documentIndex);
            indexData.put(word, existingDocs);
        }
    }

    public List<DocumentIndex> search(String word) {
        if (indexData.containsKey(word)) {
            return indexData.get(word);
        }
        return new ArrayList<>();
    }
    public void print() {
        System.out.println(indexData);
    }
}
