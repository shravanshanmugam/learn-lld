package com.shravan.learn.memorydb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DatabaseManager {
    private Map<String, Database> databases;

    private DatabaseManager() {
        databases = new HashMap<>();
    }

    private static volatile DatabaseManager INSTANCE;

    public static DatabaseManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager();
        }
        return INSTANCE;
    }

    public Database createDatabase(String databaseName) {
        if (databases.containsKey(databaseName)) {
            System.out.println(databaseName + " database already present");
            return null;
        } else {
            Database database = new Database(databaseName);
            databases.put(databaseName, database);
            return database;
        }
    }

    public void dropDatabase(String databaseName) {
        if (!databases.containsKey(databaseName)) {
            System.out.println(databaseName + " database does not exist");
        } else {
            databases.remove(databaseName);
        }
    }
}
