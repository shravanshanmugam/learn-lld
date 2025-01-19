package com.shravan.learn.memorydb;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Database {
    private final String databaseName;
    private final Map<String, Table> tables;
    private final LocalDateTime createdAt;

    public Database(String databaseName) {
        this.databaseName = databaseName;
        tables = new HashMap<>();
        createdAt = LocalDateTime.now();
    }

    public void createTable(String tableName, List<Column> schema) {
        if (tables.containsKey(tableName)) {
            System.out.println(tableName + " table already exists");
        } else {
            tables.put(tableName, new Table(tableName, schema));
        }
    }

    public void dropTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            System.out.println(tableName + " table does not exist");
        } else {
            tables.remove(tableName);
        }
    }
}
