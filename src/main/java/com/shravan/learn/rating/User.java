package com.shravan.learn.rating;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    private final int id;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}
