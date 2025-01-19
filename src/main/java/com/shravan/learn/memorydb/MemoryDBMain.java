package com.shravan.learn.memorydb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDBMain {
    public static void main(String[] args) {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        Database org = databaseManager.createDatabase("org");
        Column firstName = new Column("firstName", ColumnType.STRING, false);
        Column lastName = new Column("lastName", ColumnType.STRING, true);
        Column phone = new Column("phone", ColumnType.INTEGER, false);
        List<Column> schema = new ArrayList<>();
        schema.add(firstName);
        schema.add(lastName);
        schema.add(phone);
        org.createTable("users", schema);
        Table users = org.getTables().get("users");

        Map<Column, Object> row1 = new HashMap<>();
        row1.put(firstName, "John");
        row1.put(lastName, "Doe");
        row1.put(phone, 987654310);
        users.insertRecord(row1);
        System.out.println("--");
        Map<Column, Object> row2 = new HashMap<>();
        row2.put(firstName, "Alice");
        Column middleName = new Column("middleName", ColumnType.STRING, true);
        row2.put(middleName, "in");
        row2.put(lastName, "Wonderland");
        row2.put(phone, 12334);
        users.insertRecord(row2);
        System.out.println("--");
        Map<Column, Object> row3 = new HashMap<>();
        row3.put(firstName, "Alice");
        row3.put(lastName, "Wonderland");
        row3.put(phone, "12334");
        users.insertRecord(row3);
        System.out.println("--");
        Map<Column, Object> row4 = new HashMap<>();
        row4.put(firstName, "Alice");
        row4.put(lastName, "Wonderland");
        users.insertRecord(row4);
        System.out.println("--");
        Map<Column, Object> row5 = new HashMap<>();
        row5.put(firstName, "Alice");
        row5.put(lastName, "Wonderland");
        row5.put(phone, 123417328);
        users.insertRecord(row5);
        System.out.println("--");
        users.print();
    }
}
