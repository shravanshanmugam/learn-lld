package com.shravan.learn.searchengine.model;

import java.time.LocalDateTime;

public class Document {
    private final int id;
    private final String content;
    private final LocalDateTime createdAt;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
        createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
