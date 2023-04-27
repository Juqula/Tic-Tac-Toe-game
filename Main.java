package Sibonelo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';

        while (true) {
            // Print the current state of the board
            System.out.println("  1 2 3");
            System.out.println(" -------");
            for (int i = 0; i < 3; i++) {
                System.out.print((i + 1) + "|");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + "|");
                }
                System.out.println();
                System.out.println(" -------");
            }

            // Ask the player to make a move
            System.out.println(currentPlayer + "'s turn. Enter row and column (e.g. 1 2):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Update the board
            board[row][col] = currentPlayer;

            // Check if the game is over
            if (isGameOver(board)) {
                System.out.println(currentPlayer + " wins!");
                break;
            } else if (isBoardFull(board)) {
                System.out.println("It's a tie!");
                break;
            }

            // Switch to the other player
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }
    }

    private static boolean isGameOver(char[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
