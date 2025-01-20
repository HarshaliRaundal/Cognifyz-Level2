/*Implement a two-player tic-tac-toe game. Display the game board and prompt each player to enter their moves. Check for a winning condition or a draw after each move, and display the result accordingly.
 Allow the players to play multiple rounds if desired.*/

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean playAgain = true;

        // Initialize and play rounds
        while (playAgain) {
            initializeBoard(board);
            playGame(sc, board);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }

    // Initialize the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current game board
    public static void printBoard(char[][] board) {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    // Play the game round
    public static void playGame(Scanner sc, char[][] board) {
        char currentPlayer = 'X';
        int moves = 0;
        boolean gameWon = false;

        while (moves < 9 && !gameWon) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Validate the move
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            // Make the move
            board[row][col] = currentPlayer;
            moves++;

            // Check for a win
            gameWon = checkWin(board, currentPlayer);

            if (gameWon) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (moves == 9) {
                printBoard(board);
                System.out.println("It's a draw!");
            } else {
                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    // Check if the current player has won
    public static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Main diagonal
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) { // Anti-diagonal
            return true;
        }

        return false;
    }
}






