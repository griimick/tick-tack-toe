/**
 * Board class Array that Holds the Seeds Model
 */
public class Board {
   //Dimensions of the Board Array
   public static final int Rows = 3;
   public static final int Columns = 3;


   Cell[][] cells;
   int currentRow, currentCol;

   /** Constructor */
   public Board() {
      cells = new Cell[Rows][Columns];  // initialize the array
      for (int row = 0; row < Rows; ++row) {
         for (int col = 0; col < Columns; ++col) {
            cells[row][col] = new Cell(row, col);
         }
      }
   }

   /** Initialize the game board */
   public void init() {
      for (int row = 0; row < Rows; ++row) {
         for (int col = 0; col < Columns; ++col) {
            cells[row][col].clear();  // clear the cell content
         }
      }
   }

   /** Return true if it is a Draw */
   public boolean isDraw() {
      for (int row = 0; row < Rows; ++row) {
         for (int col = 0; col < Columns; ++col) {
            if (cells[row][col].content == Seed.Empty) {
               return false; // an Empty cell found,no Draw
            }
         }
      }
      return true; // no Empty cell, it's a draw
   }

   /** Return true if the player with "Seed" has won after current Move*/
   public boolean hasWon(Seed placeholder) {
      return (cells[currentRow][0].content == placeholder         // 3-in-the-row
              && cells[currentRow][1].content == placeholder
              && cells[currentRow][2].content == placeholder
              || cells[0][currentCol].content == placeholder      // 3-in-the-column
              && cells[1][currentCol].content == placeholder
              && cells[2][currentCol].content == placeholder
              || currentRow == currentCol            // 3-in-the-diagonal
              && cells[0][0].content == placeholder
              && cells[1][1].content == placeholder
              && cells[2][2].content == placeholder
              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
              && cells[0][2].content == placeholder
              && cells[1][1].content == placeholder
              && cells[2][0].content == placeholder);
   }

   /** print the board */
   public void print() {
      for (int row = 0; row < Rows; ++row) {
         for (int col = 0; col < Columns; ++col) {
            cells[row][col].print();   // each cell prints itself
            if (col < Columns - 1) System.out.print("|");
         }
         System.out.println();
         if (row < Rows - 1) {
            System.out.println("-----------");
         }
      }
   }
}
