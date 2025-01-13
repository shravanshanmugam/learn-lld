package com.shravan.learn.snakeandladder;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;

    public void play() {
        Queue<Player> q = new LinkedList<>();
        q.addAll(players);
        while (q.size() > 1) {
            Player current = q.poll();
            int roll = current.roll(dice);
            System.out.println(current.getName() + " at " + current.getPosition() + " rolls " + roll);
            int newPosition = current.getPosition() + roll;
            if (newPosition > 100) {
                System.out.println(current.getName() + " out of board");
                q.add(current);
                continue;
            }
            if (newPosition == 100) {
                current.setPosition(newPosition);
                System.out.println(current.getName() + " has won!");
            } else {
                int updatedPosition = board.next(newPosition);
                current.setPosition(updatedPosition);
                System.out.println(current.getName() + " at " + current.getPosition());
                q.add(current);
            }
        }
    }

}
