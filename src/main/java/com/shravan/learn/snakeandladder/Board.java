package com.shravan.learn.snakeandladder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int next(int position) {
        if (snakes.containsKey(position)) {
            System.out.println("bit by snake");
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            System.out.println("climb ladder");
            return ladders.get(position);
        }
        return position;
    }


}
