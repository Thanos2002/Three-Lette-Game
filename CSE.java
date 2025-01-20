import java.util.Scanner;
import java.util.InputMismatchException;

class CSE {

    static char[][] board = new char[3][3];
    static char[] letters = new char[]{'C', 'S', 'E'};

    // Initialize the board
    static void initBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the board
    static void printBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(board[i][j]);
                if (j < 3 - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 3 - 1) {
                System.out.println("-----");
            }
        }
    }

    // Check if the board is full
    static boolean isFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if the current player wins
    static int evaluate(char[][] board) {
        // Check rows and columns for 'CSE' or 'ESC'
        for (int i = 0; i < 3; ++i) {
            if (board[i][0] == 'C' && board[i][1] == 'S' && board[i][2] == 'E') {
                return 10;
            }
            if (board[i][0] == 'E' && board[i][1] == 'S' && board[i][2] == 'C') {
                return 10;
            }
        
            if (board[0][i] == 'C' && board[1][i] == 'S' && board[2][i] == 'E') {
                return 10;
            }
            if (board[0][i] == 'E' && board[1][i] == 'S' && board[2][i] == 'C') {
                return 10;
            }
        }

        // Check diagonals for 'CSE' or 'ESC'
        if ((board[0][0] == 'C' && board[1][1] == 'S' && board[2][2] == 'E') || 
            (board[0][0] == 'E' && board[1][1] == 'S' && board[2][2] == 'C')) {
            return 10;
        }
        if ((board[0][2] == 'C' && board[1][1] == 'S' && board[2][0] == 'E') || 
            (board[0][2] == 'E' && board[1][1] == 'S' && board[2][0] == 'C')) {
            return 10;
        }

        // Check if the board is full (draw)
        if (isFull()) {
            return 0;
        }
        // No winner yet
        return -1;
    }
    static void findBestMove() {
        int bestVal = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        char bestLetter = ' ';

        // evaluate minimax function for all empty cells
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == ' ') {                          // Check if cell is empty
                    for (char let : letters) {  // Try placing each letter and evaluate the move
                        board[i][j] = let;
                        int moveVal = minimax(board, let, 1, false);
                        board[i][j] = ' ';    // Undo the move
                        if (moveVal > bestVal) {
                            bestRow = i;
                            bestCol = j;
                            bestVal = moveVal;
                            bestLetter = let;
                        }
                    }
                }
            }
        }
        System.out.println("Computer chooses: \n [" + bestRow + ", " + bestCol + "] " + bestLetter);
        board[bestRow][bestCol] = bestLetter;
    }

    static int minimax(char[][] board, char letter, int depth, boolean isMax) {
        int score = evaluate(board);
        boolean checkMinOrMax = (depth % 2) == 1;
        if (score == 10 || score == 0) {
            if(checkMinOrMax){
                return score;
            }
            else{
                return -score;
            }
       }
        // If this move is for MAX player
        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] == ' ') {
                        for (char let : letters) {
                            board[i][j] = let;
                            best = Math.max(best, minimax(board,let, depth + 1, !isMax));
                            board[i][j] = ' ';
                        }
                    }
                }
            }return best;
        } else { // If this move is for MIN player
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (board[i][j] == ' ') {
                        for (char let : letters) {
                            board[i][j] = let;
                            best = Math.min(best, minimax(board, let, depth + 1, !isMax));
                            board[i][j] = ' ';
                        }
                    }
                }
            }return best;
        }
    }
}
