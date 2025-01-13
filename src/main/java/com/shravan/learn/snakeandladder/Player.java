package com.shravan.learn.snakeandladder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    @Setter
    private int position = 1;

}
