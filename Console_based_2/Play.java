import java.util.*;
/**
 * Tick-Tack-Toe_console_based_2
 * created by mikasou with Love
 * www.soumikpradhan.wordpress.column
 */
public class Play {
   private Board board;            // the game board
   private GameState currentState; // the current state of the game
   private Seed currentPlayer;     // the current player

   private static Scanner o = new Scanner(System.in);  // input Scanner

   /** Constructor */
   public Play() {
      board = new Board();  // initialize game-board

      // Initialize the game-board and current status
      initGame();
      // Play the game once. Players Cross and Circle move alternately.
      do {
         playerMove(currentPlayer); // update the content and current stats
         board.print();             // print board
         updateGame(currentPlayer); // update currentState
         // Print message if KO
         if (currentState == GameState.Cross_Won) {
            System.out.println("'X' Won!");
         } else if (currentState == GameState.Circle_Won) {
            System.out.println("'O' Won!");
         } else if (currentState == GameState.Draw) {
            System.out.println("It's Draw!");
         }
         // Switch player
         currentPlayer = (currentPlayer == Seed.Cross) ? Seed.Circle : Seed.Cross;
      } while (currentState == GameState.Playing);  // repeat until KO
   }

   /** Initialize the game-board and set the intial stats */
   public void initGame() {
      board.init();  // clear the board
      currentPlayer = Seed.Cross;       // Cross plays first
      currentState = GameState.Playing;
   }

   /* Update the board after the input placeholder by the current player*/
   public void playerMove(Seed placeholder) {
      boolean validInput = false;  // for validating input
      do {
         if (placeholder == Seed.Cross) {
            System.out.print("Player Cross 'X', enter your move in the format (row column) with [1,2,3]: ");
         } else {
            System.out.print("Player Circle 'O', enter your move in the format (row column) with [1,2,3]: ");
         }
         int row = o.nextInt() - 1;
         int col = o.nextInt() - 1;
         if (row >= 0 && row < Board.Rows && col >= 0 && col < Board.Columns
               && board.cells[row][col].content == Seed.Empty) {
            board.cells[row][col].content = placeholder;
            board.currentRow = row;
            board.currentCol = col;
            validInput = true; // input okay, exit loop
         } else {
            System.out.println("The move at (" + (row + 1) + "," + (col + 1)
                  + ") is invalid. Please Try again...");
         }
      } while (!validInput);   // repeat until input is valid
   }

   /** Update the currentState after the move*/
   public void updateGame(Seed placeholder) {
      if (board.hasWon(placeholder)) {  // check for win
         currentState = (placeholder == Seed.Cross) ? GameState.Cross_Won : GameState.Circle_Won;
      } else if (board.isDraw()) {  // check for Draw
         currentState = GameState.Draw;
      }

   }

   /** The main() method */
   public static void main(String[] args) {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("Welcome! to 'Tick-Tack-Toe_console_based_2'");
      System.out.println("created by mikasou with Love");
      System.out.println("www.soumikpradhan.wordpress.com");
      System.out.println();
      System.out.println();
      System.out.println();
      new Play();  //Minified Code :D
      //Adding comments the main() method looks a lot empty, Thanks to OOPs!
   }
}
