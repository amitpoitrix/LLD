package TicTacToe;

import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board();
        currentPlayer = player1;
    }

    public void play() {
        board.printBoard();

        while(!board.isFull() && !board.hasWinner()) {
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row number: ");
            int col = getValidInput("Enter col number: ");

            try {
                board.makeMove(row, col, currentPlayer.getPlayerPlayingPiece());
                board.printBoard();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if(board.hasWinner()) {
            switchPlayer();
            System.out.println(currentPlayer.getName() + " has Won !!!");
        } else {
            System.out.println("It's a Draw !!!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2: player1;
    }

    private int getValidInput(String message) {
        System.out.println(message);

        Scanner sc = new Scanner(System.in);
        int input;

        while(true) {
            if(sc.hasNextInt()) {
                input = sc.nextInt();
                if(input >= 0 && input <= 2)
                    return input;
            } else {
                sc.next();
            }
            System.out.println("Invalid Input, Please enter value between 0 and 2");
        }
    }
}
