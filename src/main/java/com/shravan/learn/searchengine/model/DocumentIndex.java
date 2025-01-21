package com.shravan.learn.searchengine.model;

import java.util.HashMap;
import java.util.Map;

public class DocumentIndex {
    private Document document;
    private Map<String, Integer> wordFreq;

    public DocumentIndex(Document document) {
        this.document = document;
        wordFreq = new HashMap<>();
        computeWordFreq();
    }

    public void computeWordFreq() {
        String[] words = document.getContent().toLowerCase().split(" ");
        for (String word : words) {
            Integer curr = wordFreq.getOrDefault(word, 0);
            wordFreq.put(word, curr + 1);
        }

    }

    public Document getDocument() {
        return document;
    }

    public Map<String, Integer> getWordFreq() {
        return wordFreq;
    }

    @Override
    public String toString() {
        return "{" +
                "document=" + document +
                ", wordFreq=" + wordFreq +
                '}';
    }
}
