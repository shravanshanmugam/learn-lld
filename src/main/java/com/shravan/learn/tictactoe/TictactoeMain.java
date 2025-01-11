package com.shravan.learn.tictactoe;

// Game -> Player1, Player 2, Board -> n * n matrix
// Player -> name, symbol
public class TictactoeMain {
    public static void main(String[] args) {
        Game game = new Game(3);
        game.addPlayer1("shravan");
        game.addPlayer2("ajay");
        game.play();
    }
}
