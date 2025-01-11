package com.shravan.learn.stackoverflow;

public class Tag {
    private final int id;
    private final String name;

    public Tag(String name) {
        this.id = IdGenerator.generate();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
