package com.tlalor.battleship;
/**
 * The Move class holds a row and column index and takes either ints or a String value to make moves. */

public class Move {

    private int row;
    private int col;


/**
Constructor - Creates a Move object from two integers representing the indices in a two dimensional array */
    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }
/** Constructor - Creates a move object from a String consisting of a letter and a number. Facilitates interaction with user
interface. */
    public Move(String pos){
        
        if (pos.length() == 2)
         {
            this.col = Integer.parseInt(pos.substring(1))-1;
         }
        if (pos.length() == 3)
         {
            this.col = Integer.parseInt(pos.substring(1))-1;
         }
        char x = pos.toUpperCase().charAt(0);
        

        switch (x) {
         case 'A':
            this.row = 0;
            break;
         case 'B':
            this.row = 1;
            break;
         case 'C':
            this.row = 2;
            break;
         case 'D':
            this.row = 3;
            break;
         case 'E':
            this.row = 4;
            break;
         case 'F':
            this.row = 5;
            break;
         case 'G':
            this.row = 6;
            break;
         case 'H':
            this.row = 7;
            break;
         case 'I':
            this.row = 8;
            break;
         case 'J':
            this.row = 9;
            break;
         default:
            this.row = 0;
            break;
      }    
    }
    
   
/** Accessor for row. Using 'row' rather than 'getRow' allows for more compact code when manipulating
ArrayLists.
@return int row index
*/
    public int row(){
        return row;
    }
/** Accessor for col. Using 'col' rather than 'getCol' allows for more compact code when manipulating
arrayLists.
@return int column index
*/
    public int col(){
        return col;
    }

/**Returns a 2 to 3 character string consisting of a letter in the range A-J followed by a number in the range
1-10. Provides for ease of display of move values in an interface.
@return String
*/
    @Override
    public String toString() {
        String rowStr;
        switch (row) {
         case 0:
            rowStr = "A";
            break;
         case 1:
            rowStr = "B";
            break;
         case 2:
            rowStr = "C";
            break;
         case 3:
            rowStr = "D";
            break;
         case 4:
            rowStr = "E";
            break;
         case 5:
            rowStr = "F";
            break;
         case 6:
            rowStr = "G";
            break;
         case 7:
            rowStr = "H";
            break;
         case 8:
            rowStr = "I";
            break;
         case 9:
            rowStr = "J";
            break;
         default:
            rowStr = "A";
            break;
         }
         return rowStr + (col+1);
    }
    @Override
    public boolean equals(Object move){
        Move move2 = (Move)move;
        return this.col() == move2.col() && this.row() == move2.row();
    }
}
