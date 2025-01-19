package com.shravan.learn.memorydb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Column {
    private final String columnName;
    private final ColumnType columnType;
    private final boolean nullable;

    @Override
    public String toString() {
        return "{" +
                "columnName='" + columnName + '\'' +
                ", columnType=" + columnType +
                ", nullable=" + nullable +
                '}';
    }
}
