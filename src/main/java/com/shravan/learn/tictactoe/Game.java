package com.shravan.learn.tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private final int n;
    private Player p1;
    private Player p2;
    private Board board;
    private int[][] countRow;
    private int[][] countColumn;
    private int[] countLeftDiagonal;
    private int[] countRightDiagonal;
    private int total;
    private int squared;

    public Game(int n) {
        this.n = n;
        this.squared = n * n;
        board = new Board(n);
        countRow = new int[n][2];
        countColumn = new int[n][2];
        countLeftDiagonal = new int[2];
        countRightDiagonal = new int[2];
        total = 0;
    }

    public void addPlayer1(String name) {
        p1 = new Player(name, 'x');
    }

    public void addPlayer2(String name) {
        p2 = new Player(name, 'o');
    }

    public void play() {
        if (p1 == null || p2 == null) {
            System.out.println("add players");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        Queue<Player> q = new LinkedList<>();
        q.add(p1);
        q.add(p2);
        board.print();
        while (!q.isEmpty()) {
            Player p = q.poll();
            int x;
            int y;
            do {
                System.out.println(p.getName() + " enter x : ");
                x = scanner.nextInt();
                System.out.println(p.getName() + " enter y : ");
                y = scanner.nextInt();
            } while (!board.mark(p.getSymbol(), x, y));
            board.print();
            if (updateCount(p, x, y)) {
                System.out.println(p.getName() + " has won");
                break;
            }
            if (over()) {
                System.out.println("game over. no winner");
                break;
            }
            q.offer(p);
        }
    }

    private boolean over() {
        return total == squared;
    }

    private boolean updateCount(Player p, int x, int y) {
        int value = getValue(p.getSymbol());
        countRow[x][value]++;
        if (countRow[x][value] == n) return true;
        countColumn[y][value]++;
        if (countColumn[y][value] == n) return true;
        if (x == y) {
            countLeftDiagonal[value]++;
        }
        if (countLeftDiagonal[value] == n) return true;
        if (x + y == n - 1) {
            countRightDiagonal[value]++;
        }
        if (countRightDiagonal[value] == n) return true;
        total++;
        return false;
    }

    private int getValue(char symbol) {
        return symbol == 'x' ? 0 : 1;
    }
}
