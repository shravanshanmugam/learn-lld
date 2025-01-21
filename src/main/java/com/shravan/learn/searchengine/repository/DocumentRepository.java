package com.shravan.learn.searchengine.repository;

import com.shravan.learn.searchengine.index.InvertedIndex;
import com.shravan.learn.searchengine.model.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DocumentRepository {
    public static final int MIN_CONTENT_LENGTH = 10;
    private final Map<Integer, Document> documents;
    private final AtomicInteger documentCounter;
    private final InvertedIndex index;

    public DocumentRepository() {
        documents = new HashMap<>();
        documentCounter = new AtomicInteger(0);
        index = InvertedIndex.getInstance();
    }

    public Document addDocument(String content) {
        if (content == null || content.length() < MIN_CONTENT_LENGTH) throw new IllegalArgumentException("invalid content");
        Document document = new Document(documentCounter.incrementAndGet(), content);
        documents.put(document.getId(), document);
        updateInvertedIndex(document);
        // updateTrie
        return document;
    }

    private void updateInvertedIndex(Document document) {
        index.createIndex(document);
    }
}
