package com.shravan.learn.memorydb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class Row {
    private final Integer rowId;
    @Setter
    private Map<String, Object> values;
    private final LocalDateTime createdAt;
    @Setter
    private LocalDateTime updatedAt;

    public Row(Integer rowId, Map<String, Object> values) {
        this.rowId = rowId;
        this.values = values;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "rowId=" + rowId +
                ", values=" + values +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
