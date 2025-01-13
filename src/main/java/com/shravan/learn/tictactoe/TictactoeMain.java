package com.shravan.learn.tictactoe;

// Game -> Player1, Player 2, Board, n
// countRow[n][2], countColumn[n][2], countLeftDiagonal[2], countRightDiagonal[2]
// total (number of moves), squared (n * n)
// updateCount(Player, x, y), over()

// Board -> n, n * n matrix
// initialize() with '-'
// validate(x, y) within boundary and empty cell i.e. '-'
// mark(symbol, x, y)

// Player -> name, char symbol
public class TictactoeMain {
    public static void main(String[] args) {
        Game game = new Game(3);
        game.addPlayer1("shravan");
        game.addPlayer2("ajay");
        game.play();
    }
}
