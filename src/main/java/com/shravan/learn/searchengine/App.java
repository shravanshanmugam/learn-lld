package com.shravan.learn.searchengine;

import com.shravan.learn.searchengine.model.Document;
import com.shravan.learn.searchengine.repository.DocumentRepository;
import com.shravan.learn.searchengine.sort.SortBy;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        DocumentRepository documentRepository = new DocumentRepository();
        Document doc1 = documentRepository.addDocument("document, document! one is here.");
        Document doc2 = documentRepository.addDocument("document two is is here");
        Document doc3 = documentRepository.addDocument("where my is doc");
        List<Document> mostRecent = searchEngine.search("document", SortBy.MOST_RECENT);
        System.out.println("mostRecent = " + mostRecent);
        List<Document> mostFrequent = searchEngine.search("Document", SortBy.MOST_FREQUENT);
        System.out.println("mostFrequent = " + mostFrequent);

        searchEngine.print();

    }
}
