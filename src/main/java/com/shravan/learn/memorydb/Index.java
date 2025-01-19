package com.shravan.learn.memorydb;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Index {
    private final String indexName;
    private final String columnName;
    private final Map<String, List<Row>> indexValues;

    public Index(String indexName, String columnName, Map<Integer, Row> rows) {
        this.indexName = indexName;
        this.columnName = columnName;
        indexValues = new HashMap<>();
        populateIndex(rows);
    }

    private void populateIndex(Map<Integer, Row> rows) {
        for (Map.Entry<Integer, Row> entry : rows.entrySet()) {
            Row row = entry.getValue();
            insertRecord(row);
        }
    }

    public void insertRecord(Row row) {
        String value = (String) row.getValues().get(columnName);
        List<Row> existingRows = indexValues.getOrDefault(value, new ArrayList<>());
        existingRows.add(row);
        indexValues.put(value, existingRows);
    }

    public void print() {
        for (Map.Entry<String, List<Row>> entry : indexValues.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
