package TicTacToe;

import TicTacToe.Piece.PlayingPiece;

public class Board {
    PlayingPiece[][] grid;
    int movesCount;

    public Board() {
        grid = new PlayingPiece[3][3];
        movesCount = 0;
    }

    public void makeMove(int row, int col, PlayingPiece playingPiece) {
        if(row < 0 || row >= 3 || col < 0 || col >= 3 || grid[row][col] != null) {
            throw new IllegalArgumentException("Invalid Move");
        }

        grid[row][col] = playingPiece;
        movesCount++;
    }

    public boolean isFull() {
        return movesCount == 9;
    }

    public boolean hasWinner() {
        // row wise
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] != null && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }
        }

        // col wise
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] != null && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                return true;
            }
        }

        // check diagonals
        if(grid[0][0] != null && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }

        return grid[2][0] != null && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2];
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] != null)
                    System.out.print(grid[i][j].pieceType.name() + "  ");
                else
                    System.out.print("   ");

                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
