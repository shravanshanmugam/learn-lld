package com.shravan.learn.memorydb;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Table {
    private final String tableName;
    private Integer autoIncrementId;
    private final Map<String, Column> schema;
    private final Map<Integer, Row> rows;
    private final LocalDateTime createdAt;
    private final Map<String, Index> indexes;

    public Table(String tableName, List<Column> schema) {
        this.tableName = tableName;
        this.schema = new HashMap<>();
        autoIncrementId = 1;
        rows = new HashMap<>();
        createdAt = LocalDateTime.now();
        indexes = new HashMap<>();
        populateSchema(schema);
    }

    private void populateSchema(List<Column> schema) {
        for (Column column : schema) {
            this.schema.put(column.getColumnName(), column);
        }
    }

    public void createIndex(String indexName, String columnName) {
        if (indexes.containsKey(indexName)) {
            System.out.println(indexName + " index already exists");
        } else {
            Index index = new Index(indexName, columnName, rows);
            indexes.put(indexName, index);
        }
    }

    public Row insertRecord(Map<String, Object> values) {
        if (!validate(values)) return null;
        Integer rowId = getAutoIncrementId();
        Row row = new Row(rowId, values);
        rows.put(rowId, row);
        System.out.println("inserted " + rowId);
        if (!indexes.isEmpty()) {
            for (Index index : indexes.values()) {
                index.insertRecord(row);
            }
        }
        return row;
    }
    public Row updateRecord(Integer rowId, Map<String, Object> values) {
        if (!rows.containsKey(rowId)) {
            System.out.println(rowId + " row does not exist");
            return null;
        } else {
            if (!validate(values)) return null;
            Row row = new Row(rowId, values);
            return rows.put(rowId, row);
        }
    }
    public void deleteRecord(Integer rowId) {
        if (!rows.containsKey(rowId)) {
            System.out.println(rowId + " row does not exist");
        } else {
            rows.remove(rowId);
        }
    }
    public Row getRecord(Integer rowId) {
        if (!rows.containsKey(rowId)) {
            System.out.println(rowId + " row does not exist");
            return null;
        } else {
            return rows.get(rowId);
        }
    }

    public void print() {
        System.out.println(tableName);
        for (Integer rowId : rows.keySet()) {
            Row row = rows.get(rowId);
            System.out.println(rowId + "=" + row);
        }
    }

    private synchronized Integer getAutoIncrementId() {
        return this.autoIncrementId++;
    }

    private boolean validate(Map<String, Object> values) {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String columnName = entry.getKey();
            // check column exists
            if (!schema.containsKey(columnName)) {
                System.out.println(tableName + " does not contain column " + columnName);
                return false;
            }
            Column column = schema.get(columnName);
            // check data type
            Object o = entry.getValue();
            ColumnType columnType = column.getColumnType();
            ColumnType actualType = getColumnType(o);
            if (!columnType.equals(actualType)) {
                System.out.println(o + " is not of type " + columnType);
                return false;
            }

        }
        for (Map.Entry<String, Column> entry : schema.entrySet()) {
            Column column = entry.getValue();
            // check nullable
            boolean nullable = column.isNullable();
            if (!nullable && values.get(column.getColumnName()) == null) {
                System.out.println(column.getColumnName() + " is not nullable");
                return false;
            }
        }
        return true;
    }

    private ColumnType getColumnType(Object o) {
        if (o instanceof String) {
            return ColumnType.STRING;
        } else if (o instanceof Integer) {
            return ColumnType.INTEGER;
        }
        return null;
    }
}
