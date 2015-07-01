/**
 * This class is the model of each cell in the Board Array
 */
public class Cell {

   Seed content; // placeholder

   int row, col; // row and column of the cell

   //Constructor
   public Cell(int row, int col) {
      this.row = row;
      this.col = col;
      clear();  // clear content
   }

   /** Change the placeholder of the cell to Empty */
   public void clear() {
      content = Seed.Empty;
   }

   /** Print itself */
   public void print() {
      switch (content) {
         case Cross:  System.out.print(" X "); break;
         case Circle: System.out.print(" O "); break;
         case Empty:  System.out.print("   "); break;
      }
   }
}
