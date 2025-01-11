package com.shravan.learn.stackoverflow;

import java.util.Date;

public class Comment {
    private final int id;
    private final String content;
    private final User author;
    private final Date createdAt;

    public Comment(User author, String content) {
        this.id = IdGenerator.generate();
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
