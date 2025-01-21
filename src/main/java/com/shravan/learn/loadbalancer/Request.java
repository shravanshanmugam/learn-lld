package com.shravan.learn.loadbalancer;

import lombok.Getter;

@Getter
public class Request {
    private final String path;
    private final String content;

    public Request(String path, String content) {
        this.path = path;
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "path='" + path + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
