package com.shravan.learn.searchengine.sort;

import com.shravan.learn.searchengine.model.DocumentIndex;

import java.util.Comparator;
import java.util.List;

public class MostFrequentStrategy implements SortStrategy {

    @Override
    public void sort(List<DocumentIndex> documents, String[] queryToken) {
        // number of times it occurs
        documents.sort(new Comparator<DocumentIndex>() {
            @Override
            public int compare(DocumentIndex o1, DocumentIndex o2) {
                int freq1 = 0, freq2 = 0;
                for (String qt : queryToken) {
                    freq1 += o1.getWordFreq().get(qt);
                    freq2 += o2.getWordFreq().get(qt);
                }
                return freq1 < freq2 ? 1 : (freq1 == freq2 ? 0 : -1);
            }
        });
    }
}
