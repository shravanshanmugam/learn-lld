package com.shravan.learn.snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderMain {
    public static void main(String[] args) {

        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(98, 2);
        snakes.put(78, 27);
        snakes.put(88, 64);
        snakes.put(63, 37);
        snakes.put(64, 22);
        snakes.put(22, 8);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(10, 33);
        ladders.put(21, 45);
        ladders.put(46, 86);
        ladders.put(52, 71);
        ladders.put(59, 67);
        ladders.put(71, 87);
        Board board = new Board(snakes, ladders);

        List<Player> players = new ArrayList<>();
        players.add(new Player("alice"));
        players.add(new Player("bob"));
        players.add(new Player("charlie"));
        Dice dice = new Dice(1);
        Game game = new Game(board, players, dice);
        game.play();
    }
}
