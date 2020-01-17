package com.tlalor.battleship;
/**
 * ComputerBoard Class. Extends Board.
 */
import java.io.*;
import java.util.*;
public class ComputerBoard extends Board {

/**
Constructor - calls the super's constructor with the given filename.
@param String filename
*/
    public ComputerBoard(String filename) throws IOException{
        super(filename);
    }
    public ComputerBoard(){
        super();
        Random rand = new Random();;
        ArrayList<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < this.SIZE; i++)
        {
            for (int j = 0; j < this.SIZE; j++)
            {
                moves.add(new Move(i,j));
            }
        }

        ShipType ship = null;
        int length = 0;
        char charShip;

        for (int count = 1; count < 6;) {
            int random_index = rand.nextInt(moves.size());
            Move move = moves.get(random_index);
            int random_boolean = rand.nextInt(2);
            boolean horizontal = true;
            if (random_boolean == 1) {
                horizontal = false;
            }
            switch (count) {
                case 1: {
                    ship = ShipType.ST_AIRCRAFT_CARRIER;
                    break;
                }
                case 2: {
                    ship = ShipType.ST_BATTLESHIP;
                    break;
                }
                case 3: {
                    ship = ShipType.ST_CRUISER;
                    break;
                }
                case 4: {
                    ship = ShipType.ST_SUB;
                    break;
                }
                case 5: {
                    ship = ShipType.ST_DESTROYER;
                    break;
                }
                default:
                    break;
            }

            switch (ship) {
                case ST_AIRCRAFT_CARRIER: {
                    length = 5;
                    break;
                }
                case ST_BATTLESHIP: {
                    length = 4;
                    break;
                }
                case ST_CRUISER: {
                    length = 3;
                    break;
                }
                case ST_DESTROYER: {
                    length = 2;
                    break;
                }
                case ST_SUB: {
                    length = 3;
                    break;
                }
                default:
                    break;
            }


            int row = move.row();
            int col = move.col();
            boolean continueS = true;
            if (horizontal == true) {
                try {
                    for (int iteration = col; iteration < (col + length); iteration++) {
                        if (this.getStatus(row, iteration) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {
                    super.addShipToUserLayout(row, row, col, (col + length - 1), horizontal, ship);
                    count++;
                }
            }
            if (horizontal == false) {
                try {
                    for (int iteration = row; iteration < (row + length); iteration++) {
                        if (this.getStatus(iteration, col) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {
                    super.addShipToUserLayout(row, (row + length - 1), col, col, horizontal, ship);
                    count++;
                }
            }
            //this.updateComputerBoard();


        }
    }
    
/**
Accepts the player's move and applies it to the computer's board. Takes a move and makes it AGAINST this board. Takes in move to be applied. Returns either null, or, if the
move sank a ship, a String along the lines of "You sank My Battleship!"
@param Move move - the move made by the player
@return 
*/
    public String makePlayerMove(Move move){
      ArrayList<ArrayList<CellStatus>> layout = this.getLayout();
      CellStatus before = layout.get(move.row()).get(move.col());
      this.applyMoveToLayout(move);
      layout = this.getLayout();
      CellStatus after = layout.get(move.row()).get(move.col());



      
      if (before != CellStatus.AIRCRAFT_CARRIER_SUNK && after == CellStatus.AIRCRAFT_CARRIER_SUNK)
         return "You sank my Aircraft Carrier!";
      else if (before != CellStatus.BATTLESHIP_SUNK && after == CellStatus.BATTLESHIP_SUNK)
         return "You sank my Battleship!";
      else if (before != CellStatus.CRUISER_SUNK && after == CellStatus.CRUISER_SUNK)
         return "You sank my Cruiser!";
      else if (before != CellStatus.SUB_SUNK && after == CellStatus.SUB_SUNK)
         return "You sank my Sub!";
      else if (before != CellStatus.DESTROYER_SUNK && after == CellStatus.DESTROYER_SUNK)
         return "You sank my Destroyer!";
      else if (before == CellStatus.NOTHING && after == CellStatus.NOTHING_HIT)
         return null;
      else
         return null;

    }
/**
Returns a String representation of the ComputerBoard, displaying the first character of the String returned by the
toString method overridden in CellStatus
@return String str
*/
    @Override
    public String toString(){
      String str = "  1  2  3  4  5  6  7  8  9  10\nA ";
      for (int i = 0; i < 10; i++)
         {
            for (int j = 0; j < 10; j++) 
            {
               if (this.getLayout().get(i).get(j) == CellStatus.AIRCRAFT_CARRIER || this.getLayout().get(i).get(j) == CellStatus.BATTLESHIP || this.getLayout().get(i).get(j) == CellStatus.CRUISER || this.getLayout().get(i).get(j) == CellStatus.SUB || this.getLayout().get(i).get(j) == CellStatus.DESTROYER)
                  str += "oo ";
               else
               {
                  str += this.getLayout().get(i).get(j).toString();
                  str += " ";
               }
            } 
            switch (i){
               case 0:
                  str += "\nB ";   
                  break;
               case 1:
                  str += "\nC ";
                  break;  
              case 2:
                  str += "\nD ";   
                  break;
              case 3:
                  str += "\nE ";
                  break;  
               case 4:
                  str += "\nF ";   
                  break;
               case 5:
                  str += "\nG ";
                  break;  
               case 6:
                  str += "\nH ";   
                  break;
               case 7:
                  str += "\nI ";
                  break;  
               case 8:
                  str += "\nJ ";   
                  break;
               default:
                  str += "\n";
                  break;
            }       
         }
      return str;
                     }
    
}
