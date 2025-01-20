import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class main {


        public static void main(String[] args) {
                CSE game = new CSE();
                Scanner scanner = new Scanner(System.in);
                Random rand = new Random();
                game.initBoard();
                game.board[rand.nextInt(2)][rand.nextInt(2)] = 'S';
                game.printBoard();

                while (true) {
                    // Player's turn
                    int playerRow;
                    int playerCol;
                    char playerLetter;
                    while(true){
                        try {
                            System.out.println("Enter the row (0-2):");
                            playerRow = scanner.nextInt();
                            if (playerRow>2 || playerRow<0 ) {
                                throw new InputMismatchException();
                            }
                            break;  // Break out of the loop if the input is valid
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer 0-2.");
                            // Consume the invalid input to avoid an infinite loop
                            scanner.nextLine();
                        }
                    }
                    while(true){
                        try {
                            System.out.println("Enter the column (0-2):");
                            playerCol = scanner.nextInt();
                            if (playerCol>2 || playerCol<0 ) {
                                throw new InputMismatchException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer 0-2.");
                            scanner.nextLine();
                        }
                    }
                    while(true){
                        try {
                            System.out.println("\nEnter your move ('C', 'S', or 'E'):");
                            playerLetter = scanner.next().toUpperCase().charAt(0);
                            // Check if the input is a valid letter
                            if (playerLetter != 'C' && playerLetter != 'S' && playerLetter != 'E') {
                                throw new InputMismatchException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid letter ('C', 'S', or 'E').");
                            scanner.nextLine();
                        }
                    }
            
                    if (game.board[playerRow][playerCol] == ' ') {
                        game.board[playerRow][playerCol] = playerLetter;
                    } else {
                        System.out.println("Invalid move. Try again.");
                        continue;
                    }

                    game.printBoard();

                    // Check for player win or draw
                    int result = game.evaluate(game.board);
                    if (result == 10) {
                        System.out.println("Player wins!");
                        break;
                    } else if (result == 0) {
                        System.out.println("It's a draw!");
                        break;
                    }

                    // Computer's turn
                    System.out.println("Computer's turn:");
                    game.findBestMove();

                    game.printBoard();

                    // Check for computer win or draw
                    result = game.evaluate(game.board);
                    if (result == 10) {
                        System.out.println("Computer wins!");
                        break;
                    } else if (result == 0) {
                        System.out.println("It's a draw!");
                        break;
                    }
                }

                scanner.close();
            }
        }