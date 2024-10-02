package TicTacToe;

import TicTacToe.Piece.PieceType;
import TicTacToe.Piece.PlayingPiece;
import TicTacToe.Piece.PlayingPieceO;
import TicTacToe.Piece.PlayingPieceX;

public class TicTacToeDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Game");

        PlayingPiece cross = new PlayingPieceX();
        Player player1 = new Player("vivek", cross);

        PlayingPiece nought = new PlayingPieceO();
        Player player2 = new Player("chanchal", nought);

        Game game = new Game(player1, player2);
        game.play();
    }
}
