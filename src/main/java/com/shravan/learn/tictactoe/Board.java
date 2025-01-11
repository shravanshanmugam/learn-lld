package com.shravan.learn.tictactoe;

import java.util.Arrays;

public class Board {

    private char[][] matrix;
    private final int n;

    public Board(int n) {
        this.n = n;
        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '-';
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public boolean mark(char symbol, int x, int y) {
        if (!validate(symbol, x, y)) {
            return false;
        }
        matrix[x][y] = symbol;
        return true;
    }

    private boolean validate(char symbol, int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1) return false;
        if (matrix[x][y] != '-') return false;
        return true;
    }
}
