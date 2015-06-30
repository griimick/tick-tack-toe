import java.util.*;
/*
 *TickTackToe
 *www.soumikpradhan.wordpress.com
 *created by mikasou
 *for educational purpose
 *Console version
 */
public class Play{

	//Placeholder final declaration
	public final static int Empty = 0;
	public final static int Cross = 1;
	public final static int Circle = 2;

	//States of Game
	public final static int Playing = 0;
	public final static int CrossWon = 1;
	public final static int CircleWon = 2;
	public final static int Draw = 3;

	//the game array (board)
	public final static int Rows = 3;
	public final static int Columns = 3;
	public static int[][] board = new int[Rows][Columns];

	//LiveGameStats aka CurrentValues
	public static int currentState;
	public static int currentPlayer;
   public static int currntRow, currentCol;

	//input scanner object
	public static Scanner o = new Scanner(System.in);

	//Main method
	public static void main(String args[]){
		startGame();
		while(currentState == Playing){

			//update the game, players, and print the current board array
			playerMove(currentPlayer);	//input move from the current player
			updateGame(currentPlayer, currntRow, currentCol); //update, check the game status
			printBoard();								//print the current status of the board

			//print if the game ends
			if (currentState == CrossWon){
            System.out.println("'X' won!");
      }else if (currentState == CircleWon){
        System.out.println("'O' won!");
      }else if (currentState == Draw){
        System.out.println("It's a Draw!");
      }

			//Change the players at turn ends
			if(currentPlayer==Cross)
				currentPlayer = Circle;
			else
				currentPlayer = Cross;


		}
	}

	//method to inisialise the game and set the default game stats
	public static void startGame(){
		//fill the board with placeholder "Empty"
		for(int row = 0; row < Rows; row++){
			for(int column = 0; column < Columns; column++){
				board[row][column] = Empty;
			}
		}
		//Cross plays first and game state is "Playing"
		currentState = Playing;
		currentPlayer = Cross;
	}

	//Validates the Current input and sets the CurrentValues
	public static void playerMove(int placeholder) {
    boolean isValid = false;  //Input Validation
    do{
      if (placeholder == Cross) {
        System.out.print("Player Cross 'X', Enter your move in the format (row column) with [1,2,3]: ");
        } else {
          System.out.print("Player Cricle 'O', Enter your move in the format (row column) with [1,2,3]: ");
        }
        int row = o.nextInt() - 1;
        int col = o.nextInt() - 1;
        if (row >= 0 && row < Rows && col >= 0 && col < Columns && board[row][col] == Empty) {
          currntRow = row;
          currentCol = col;
          board[currntRow][currentCol] = placeholder;  //Update Game Board
          isValid = true; //Input is Valid
       } else {
          System.out.println("The move at (" + (row + 1) + "," + (col + 1)
                + ") is invalid. Please Try again!");
       }
    } while (!isValid);  //Repeat until input is valid
  }

	//Updates and Checks the Game Status on current input
	public static void updateGame(int placeholder, int currentRow, int currentCol) {
    if (hasWon(placeholder, currentRow, currentCol)) {  // check if current player winning in the current move
       currentState = (placeholder == Cross) ? CrossWon: CircleWon;
    } else if (isDraw()) {  // check for draw
       currentState = Draw;
    }
  }

	//checks if Won
	public static boolean hasWon(int placeholder, int currentRow, int currentCol){
		//All the conditions for winning the game
		return (board[currentRow][0] == placeholder         // 3 in a row
            && board[currentRow][1] == placeholder
            && board[currentRow][2] == placeholder
            || board[0][currentCol] == placeholder      // 3 in a column
            && board[1][currentCol] == placeholder
            && board[2][currentCol] == placeholder
            || currentRow == currentCol            			// 3 in a diagonal
            && board[0][0] == placeholder
            && board[1][1] == placeholder
            && board[2][2] == placeholder
            || currentRow + currentCol == 2  						// 3 in other diagonal
            && board[0][2] == placeholder
            && board[1][1] == placeholder
            && board[2][0] == placeholder);

	}

	//checks if draw
	public static boolean isDraw() {
		for (int row = 0; row < Rows; ++row) {
			for (int col = 0; col < Columns; ++col) {
				if (board[row][col] == Empty) {
						return false; //still moves left, "no DRAW"
				}
			}
		}
		return true;//no move left, DRAW
	}

	//print the current board
	public static void printBoard() {
		System.out.println();
    	
    	for (int row = 0; row < Rows; ++row) {
    	  	for (int col = 0; col < Columns; ++col) {
   	    		printCell(board[row][col]); //a separate function to print the placeholder accordingly
   	    		if (col != Columns - 1) {
            		System.out.print("|");   // prints vertical line
        		}
      		}
      		System.out.println();
     		if (row != Rows - 1) {
        		System.out.println("-----------"); // prints horizontal line
      		}
    	}
    	
    	System.out.println();
  	}


	public static void printCell(int placeholder) {
  		switch (placeholder) {
    		case Empty:
					System.out.print("   ");
					break;
    		case Circle:
					System.out.print(" O ");
					break;
    		case Cross:
					System.out.print(" X ");
					break;
		}
    }

}
