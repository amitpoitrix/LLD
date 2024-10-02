package TicTacToe;

import TicTacToe.Piece.PlayingPiece;

public class Player {
    String name;
    PlayingPiece playingPiece;

    public Player(String name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPlayerPlayingPiece() {
        return playingPiece;
    }
}
