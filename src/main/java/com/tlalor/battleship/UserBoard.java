package com.tlalor.battleship;
/**
 * UserBoard Class. Extends Board. The UserBoard maintains a list of all possible moves. Initially, it will be all locations on the Board. When the computer
takes a turn, it random selects an item from this list and removes it from the list.
 */
import java.io.*;
import java.util.*;

public class UserBoard extends Board {

   Random rand = new Random();;
   int rando = rand.nextInt(2);
   ArrayList<ArrayList<Move>> moves = new ArrayList<ArrayList<Move>>();
   int horizontal = 3;
    Move nextMove = new Move(1,1);
    Move nextMove1 = nextMove;
    Move nextMove2 = nextMove;
    Move nextMove3 = nextMove;
    Move lastHit = new Move(100,100);
    ArrayList<Move> movesMade = new ArrayList<Move>();


/**
Passes the filename on to the Board constructor. Initialize the Random object and the ArrayList of all possible
Moves.
@param String filename
*/
   public UserBoard(String filename) throws IOException{
        super(filename);
        
        for (int i = 0; i < this.SIZE; i++)
            {
               for (int j = 0; j < this.SIZE; j++) 
               {
                   ArrayList<Move> item = new ArrayList<>();
                   Move addMove = new Move(i,j);
                   item.add(addMove);
                   item.add(new Move(999,999));
                   moves.add(item);
               }           
            }
       Collections.shuffle(moves);
   
    }
    public UserBoard(){
        super();

        for (int i = 0; i < this.SIZE; i++)
        {
            for (int j = 0; j < this.SIZE; j++)
            {
                ArrayList<Move> item = new ArrayList<>();
                Move addMove = new Move(i,j);
                item.add(addMove);
                item.add(new Move(999,999));
                moves.add(item);
            }
        }
        Collections.shuffle(moves);

    }
/**
Computer move against UserBoard. Selects and makes a move AGAINST this board. Returns an array of two
Strings. The first is the move the computer made in user readable form. The second is either null, or, if the move
resulted in a ship being sunk, a string along the lines of "You sunk my Battleship!"
@return String [] an array of the computer's move and a description of the outcome of the move
*/   
    public String[] makeComputerMove(){
      //int random_index = rand.nextInt(moves.size());
      Move move = moves.get(0).get(0);

      System.out.println(rando);

        boolean neww = false;
        if (rando == 1)
        {
            while (neww == false){
                if (((move.col()+1+move.row()+1)%2==0) && (moves.get(0).get(1).col() == 999)) {
                    neww = false;
                    moves.remove(0);
                    ArrayList<Move> item = new ArrayList<>();

                    item.add(move);
                    item.add(1, new Move(999, 999));
                    moves.add(item);
                    move = moves.get(0).get(0);
                }
                else
                    neww = true;
            }
        }
        if (rando == 0)
        {
            while (neww == false){
                if (((move.col()+1+move.row()+1)%2==1) && (moves.get(0).get(1).col() == 999)) {
                    neww = false;
                    moves.remove(0);
                    ArrayList<Move> item = new ArrayList<>();

                    item.add(move);
                    item.add(1, new Move(999, 999));
                    moves.add(item);
                    move = moves.get(0).get(0);
                }
                else
                    neww = true;
            }
        }
//      while (neww == false) {
//          if (movesMade.size() > 0) {
//              for (int i = 0; i < movesMade.size(); i++)
//                  if ((((move.col() == movesMade.get(i).col() + 1) && (move.row() == movesMade.get(i).row())) ||
//                          ((move.col() == movesMade.get(i).col() - 1) && (move.row() == movesMade.get(i).row())) ||
//                          ((move.col() == movesMade.get(i).col()) && (move.row() == movesMade.get(i).row() + 1)) ||
//                          ((move.col() == movesMade.get(i).col()) && (move.row() == movesMade.get(i).row() - 1)))
//                          && moves.get(0).get(1).col() == 999) {
//
//                      moves.remove(0);
//                      ArrayList<Move> item = new ArrayList<>();
//
//                      item.add(move);
//                      item.add(1, new Move(999, 999));
//                      moves.add(item);
//
//
//                  } else
//                      neww = true;
//
//              move = moves.get(0).get(0);
//          }
//          else
//              neww = true;
//      }


      //movesMade.add(move);
      ArrayList<ArrayList<CellStatus>> layout = this.getLayout();
      CellStatus before = layout.get(move.row()).get(move.col());
      this.applyMoveToLayout(move);
      layout = this.getLayout();
      CellStatus after = layout.get(move.row()).get(move.col());
      String moveString = move.toString();


      if (before != CellStatus.AIRCRAFT_CARRIER_LEFT_HIT && after == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || before != CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT && after == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || before != CellStatus.AIRCRAFT_CARRIER_TOP_HIT && after == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || before != CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT && after == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || before != CellStatus.AIRCRAFT_CARRIER_H_HIT && after == CellStatus.AIRCRAFT_CARRIER_H_HIT || before != CellStatus.AIRCRAFT_CARRIER_V_HIT && after == CellStatus.AIRCRAFT_CARRIER_V_HIT || before != CellStatus.BATTLESHIP_LEFT_HIT && after == CellStatus.BATTLESHIP_LEFT_HIT || before != CellStatus.BATTLESHIP_RIGHT_HIT && after == CellStatus.BATTLESHIP_RIGHT_HIT || before != CellStatus.BATTLESHIP_TOP_HIT && after == CellStatus.BATTLESHIP_TOP_HIT || before != CellStatus.BATTLESHIP_BOTTOM_HIT && after == CellStatus.BATTLESHIP_BOTTOM_HIT || before != CellStatus.BATTLESHIP_H_HIT && after == CellStatus.BATTLESHIP_H_HIT || before != CellStatus.BATTLESHIP_V_HIT && after == CellStatus.BATTLESHIP_V_HIT || before != CellStatus.CRUISER_LEFT_HIT && after == CellStatus.CRUISER_LEFT_HIT || before != CellStatus.CRUISER_RIGHT_HIT && after == CellStatus.CRUISER_RIGHT_HIT || before != CellStatus.CRUISER_TOP_HIT && after == CellStatus.CRUISER_TOP_HIT || before != CellStatus.CRUISER_BOTTOM_HIT && after == CellStatus.CRUISER_BOTTOM_HIT || before != CellStatus.CRUISER_H_HIT && after == CellStatus.CRUISER_H_HIT || before != CellStatus.CRUISER_V_HIT && after == CellStatus.CRUISER_V_HIT || before != CellStatus.SUB_LEFT_HIT && after == CellStatus.SUB_LEFT_HIT || before != CellStatus.SUB_RIGHT_HIT && after == CellStatus.SUB_RIGHT_HIT || before != CellStatus.SUB_TOP_HIT && after == CellStatus.SUB_TOP_HIT || before != CellStatus.SUB_BOTTOM_HIT && after == CellStatus.SUB_BOTTOM_HIT || before != CellStatus.SUB_H_HIT && after == CellStatus.SUB_H_HIT || before != CellStatus.SUB_V_HIT && after == CellStatus.SUB_V_HIT || before != CellStatus.DESTROYER_LEFT_HIT && after == CellStatus.DESTROYER_LEFT_HIT || before != CellStatus.DESTROYER_RIGHT_HIT && after == CellStatus.DESTROYER_RIGHT_HIT || before != CellStatus.DESTROYER_TOP_HIT && after == CellStatus.DESTROYER_TOP_HIT || before != CellStatus.DESTROYER_BOTTOM_HIT && after == CellStatus.DESTROYER_BOTTOM_HIT || before != CellStatus.DESTROYER_H_HIT && after == CellStatus.DESTROYER_H_HIT || before != CellStatus.DESTROYER_V_HIT && after == CellStatus.DESTROYER_V_HIT) {

          if (lastHit.col() == move.col())
              horizontal = 2;
          //if moveString.charAt(0) == lastHit.toString().charAt(0)
          else if (lastHit.row() == move.row())
              horizontal = 1;
          else
              horizontal = 3;
          lastHit = new Move(move.row(),move.col());
          movesMade.add(moves.get(0).get(0));
          moves.remove(0);

          this.nextMove = new Move(move.row() - 1, move.col());
          this.nextMove1 = new Move(move.row() + 1, move.col());
          this.nextMove2 = new Move(move.row(), move.col() - 1);
          this.nextMove3 = new Move(move.row(), move.col() + 1);
          if (horizontal == 1) {
//              for (int i = 0; i < moves.size(); i++) {
//                  if (nextMove.equals(moves.get(i).get(0))) {
////                      movesMade.add(moves.get(i).get(0));
//                      moves.remove(i);
//                      ArrayList<Move> item = new ArrayList<>();
//                      item.add(nextMove);
//                      item.add(1, new Move(666,666));
//                      moves.add(0, item);
//                  }
//              }
//              for (int i = 0; i < moves.size(); i++) {
//                  if (nextMove1.equals(moves.get(i).get(0))) {
////                      movesMade.add(moves.get(i).get(0));
//                      moves.remove(i);
//                      ArrayList<Move> item = new ArrayList<>();
//                      item.add(nextMove1);
//                      item.add(1, new Move(666,666));
//                      moves.add(0, item);
//                  }
//              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove2.equals(moves.get(i).get(0))) {
                      //movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove2);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }

              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove3.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove3);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }


          } else if (horizontal == 2) {

//              for (int i = 0; i < moves.size(); i++) {
//                  if (nextMove2.equals(moves.get(i).get(0))) {
////                      movesMade.add(moves.get(i).get(0));
//                      moves.remove(i);
//                      ArrayList<Move> item = new ArrayList<>();
//                      item.add(nextMove2);
//                      item.add(1, new Move(666, 666));
//                      moves.add(0, item);
//                  }
//              }
//              for (int i = 0; i < moves.size(); i++) {
//                  if (nextMove3.equals(moves.get(i).get(0))) {
////                      movesMade.add(moves.get(i).get(0));
//                      moves.remove(i);
//                      ArrayList<Move> item = new ArrayList<>();
//                      item.add(nextMove3);
//                      item.add(1, new Move(666, 666));
//                      moves.add(0, item);
//                  }
//              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove1.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove1);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
          } else if (horizontal == 3){
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove1.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove1);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove2.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove2);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
              for (int i = 0; i < moves.size(); i++) {
                  if (nextMove3.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                      moves.remove(i);
                      ArrayList<Move> item = new ArrayList<>();
                      item.add(nextMove3);
                      item.add(1, new Move(666,666));
                      moves.add(0, item);
                  }
              }
          }
      }
      else {
//      if (movesMade.size() > 0)
//          for (int i = 0; i < movesMade.size(); i++)
//              if (moves.get(0).get(0).col() == movesMade.get(i).col()+1 && moves.get(0).get(0).row() == movesMade.get(i).row() ||
//                      moves.get(0).get(0).col() == movesMade.get(i).col()-1 && moves.get(0).get(0).row() == movesMade.get(i).row() ||
//                      moves.get(0).get(0).col() == movesMade.get(i).col() && moves.get(0).get(0).row() == movesMade.get(i).row()+1 ||
//                      moves.get(0).get(0).col() == movesMade.get(i).col() && moves.get(0).get(0).row() == movesMade.get(i).row()-1) {
//                  moves.remove(0);
//                  moves.add(move);
//                  move = moves.get(0).get(0);
//              }
          movesMade.add(move);
          moves.remove(0);
      }
//            Move nextMove = new Move(move.row()-1,move.col());
//            Move nextMove1 = new Move(move.row()+1,move.col());
//            Move nextMove2 = new Move(move.row(),move.col()-1);
//            Move nextMove3 = new Move(move.row(),move.col()+1);




//      if (before != CellStatus.AIRCRAFT_CARRIER_LEFT_HIT && after == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || before != CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT && after == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || before != CellStatus.AIRCRAFT_CARRIER_TOP_HIT && after == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || before != CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT && after == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || before != CellStatus.AIRCRAFT_CARRIER_H_HIT && after == CellStatus.AIRCRAFT_CARRIER_H_HIT || before != CellStatus.AIRCRAFT_CARRIER_V_HIT && after == CellStatus.AIRCRAFT_CARRIER_V_HIT || before != CellStatus.BATTLESHIP_LEFT_HIT && after == CellStatus.BATTLESHIP_LEFT_HIT || before != CellStatus.BATTLESHIP_RIGHT_HIT && after == CellStatus.BATTLESHIP_RIGHT_HIT || before != CellStatus.BATTLESHIP_TOP_HIT && after == CellStatus.BATTLESHIP_TOP_HIT || before != CellStatus.BATTLESHIP_BOTTOM_HIT && after == CellStatus.BATTLESHIP_BOTTOM_HIT || before != CellStatus.BATTLESHIP_H_HIT && after == CellStatus.BATTLESHIP_H_HIT || before != CellStatus.BATTLESHIP_V_HIT && after == CellStatus.BATTLESHIP_V_HIT || before != CellStatus.CRUISER_LEFT_HIT && after == CellStatus.CRUISER_LEFT_HIT || before != CellStatus.CRUISER_RIGHT_HIT && after == CellStatus.CRUISER_RIGHT_HIT || before != CellStatus.CRUISER_TOP_HIT && after == CellStatus.CRUISER_TOP_HIT || before != CellStatus.CRUISER_BOTTOM_HIT && after == CellStatus.CRUISER_BOTTOM_HIT || before != CellStatus.CRUISER_H_HIT && after == CellStatus.CRUISER_H_HIT || before != CellStatus.CRUISER_V_HIT && after == CellStatus.CRUISER_V_HIT || before != CellStatus.SUB_LEFT_HIT && after == CellStatus.SUB_LEFT_HIT || before != CellStatus.SUB_RIGHT_HIT && after == CellStatus.SUB_RIGHT_HIT || before != CellStatus.SUB_TOP_HIT && after == CellStatus.SUB_TOP_HIT || before != CellStatus.SUB_BOTTOM_HIT && after == CellStatus.SUB_BOTTOM_HIT || before != CellStatus.SUB_H_HIT && after == CellStatus.SUB_H_HIT || before != CellStatus.SUB_V_HIT && after == CellStatus.SUB_V_HIT || before != CellStatus.DESTROYER_LEFT_HIT && after == CellStatus.DESTROYER_LEFT_HIT || before != CellStatus.DESTROYER_RIGHT_HIT && after == CellStatus.DESTROYER_RIGHT_HIT || before != CellStatus.DESTROYER_TOP_HIT && after == CellStatus.DESTROYER_TOP_HIT || before != CellStatus.DESTROYER_BOTTOM_HIT && after == CellStatus.DESTROYER_BOTTOM_HIT || before != CellStatus.DESTROYER_H_HIT && after == CellStatus.DESTROYER_H_HIT || before != CellStatus.DESTROYER_V_HIT && after == CellStatus.DESTROYER_V_HIT)
//      {
//          String[] x = {moveString, "Hit"};
//          return x;
//      }
      if (before != CellStatus.AIRCRAFT_CARRIER_SUNK && after == CellStatus.AIRCRAFT_CARRIER_SUNK){
         String[] x = {moveString, "You sank my Aircraft Carrier!"};
         if (scanForHits().size() == 0)
         Collections.shuffle(moves);
          horizontal = 3;
          Move nextMove = moves.get(moves.size()-1).get(0);
          Move nextMove1 = nextMove;
          Move nextMove2 = nextMove;
          Move nextMove3 = nextMove;
          lastHit = new Move(100,100);
          horizontal3();



            //call horizontal = 3
          //if # hits == 2
            //test if the hits are adjacent
            //if adjacent, determine horizontal
                //if horizontal, call horizontal 2
                //if vertical, call horizontal 1
            //if not adjacent, call horizontal 3 on both moves
          //if # hits > 2
            //determine adjacencies
            //for any adjacent pairs, determine horizontal
            //call horizontal 1&2 on any pairs, call horizontal 3 on any single
         return x;
         }
      else if (before != CellStatus.BATTLESHIP_SUNK && after == CellStatus.BATTLESHIP_SUNK){
         String[] x = {moveString, "You sank my Battleship!"};
          if (scanForHits().size() == 0)
          Collections.shuffle(moves);
          horizontal = 3;
          Move nextMove = moves.get(moves.size()-1).get(0);
          Move nextMove1 = nextMove;
          Move nextMove2 = nextMove;
          Move nextMove3 = nextMove;
          lastHit = new Move(100,100);
          horizontal3();
         return x;
         }
      else if (before != CellStatus.CRUISER_SUNK && after == CellStatus.CRUISER_SUNK){
         String[] x = {moveString, "You sank my Cruiser!"};
          if (scanForHits().size() == 0)
          Collections.shuffle(moves);
          Move nextMove = moves.get(moves.size()-1).get(0);
          Move nextMove1 = nextMove;
          Move nextMove2 = nextMove;
          Move nextMove3 = nextMove;
          lastHit = new Move(100,100);
          horizontal3();
          horizontal = 3;
         return x;
         }
      else if (before != CellStatus.SUB_SUNK && after == CellStatus.SUB_SUNK){
         String[] x = {moveString, "You sank my Sub!"};
          if (scanForHits().size() == 0)
          Collections.shuffle(moves);
          Move nextMove = moves.get(moves.size()-1).get(0);
          Move nextMove1 = nextMove;
          Move nextMove2 = nextMove;
          Move nextMove3 = nextMove;
          lastHit = new Move(100,100);
          horizontal3();
          horizontal = 3;
         return x;
         }
      else if (before != CellStatus.DESTROYER_SUNK && after == CellStatus.DESTROYER_SUNK){
         String[] x = {moveString, "You sank my Destroyer!"};
          if (scanForHits().size() == 0)
          Collections.shuffle(moves);
          Move nextMove = moves.get(moves.size()-1).get(0);
          Move nextMove1 = nextMove;
          Move nextMove2 = nextMove;
          Move nextMove3 = nextMove;
          lastHit = new Move(100,100);
          horizontal3();
          horizontal = 3;
         return x;
         }
      else if (before == CellStatus.NOTHING && after == CellStatus.NOTHING_HIT){
         String[] x = {moveString, null};
         return x;
         }
      else {
         String[] x = {moveString, null};
         return x;
         }
      

      
    }
/**
Returns a String representation of the ComputerBoard, displaying the second character of the String returned by
the toString method overridden in CellStatus
@return String
*/
    @Override
    public String toString(){
      String str = "  1  2  3  4  5  6  7  8  9  10\nA ";
      for (int i = 0; i < 10; i++)
         {
            for (int j = 0; j < 10; j++) 
            {
               str += this.getLayout().get(i).get(j).toString();
               str += " ";
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
 public ArrayList<Move> scanForHits(){
        ArrayList<Move> returnList = new ArrayList<Move>();
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                CellStatus thisStatus = this.getLayout().get(i).get(j);
                if (thisStatus == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT ||
                        thisStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT ||
                        thisStatus == CellStatus.AIRCRAFT_CARRIER_TOP_HIT ||
                        thisStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT ||
                        thisStatus == CellStatus.AIRCRAFT_CARRIER_H_HIT ||
                        thisStatus == CellStatus.AIRCRAFT_CARRIER_V_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_LEFT_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_RIGHT_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_TOP_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_BOTTOM_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_H_HIT ||
                        thisStatus == CellStatus.BATTLESHIP_V_HIT ||
                        thisStatus == CellStatus.CRUISER_LEFT_HIT ||
                        thisStatus == CellStatus.CRUISER_RIGHT_HIT ||
                        thisStatus == CellStatus.CRUISER_TOP_HIT ||
                        thisStatus == CellStatus.CRUISER_BOTTOM_HIT ||
                        thisStatus == CellStatus.CRUISER_H_HIT ||
                        thisStatus == CellStatus.CRUISER_V_HIT ||
                        thisStatus == CellStatus.SUB_LEFT_HIT ||
                        thisStatus == CellStatus.SUB_RIGHT_HIT ||
                        thisStatus == CellStatus.SUB_TOP_HIT ||
                        thisStatus == CellStatus.SUB_BOTTOM_HIT ||
                        thisStatus == CellStatus.SUB_H_HIT ||
                        thisStatus == CellStatus.SUB_V_HIT ||
                        thisStatus == CellStatus.DESTROYER_LEFT_HIT ||
                        thisStatus == CellStatus.DESTROYER_RIGHT_HIT ||
                        thisStatus == CellStatus.DESTROYER_TOP_HIT ||
                        thisStatus == CellStatus.DESTROYER_BOTTOM_HIT ||
                        thisStatus == CellStatus.DESTROYER_H_HIT ||
                        thisStatus == CellStatus.DESTROYER_V_HIT) {
                    returnList.add(new Move(i, j));
                }

            }
        }
        return returnList;
    }
public void horizontal3(){
    ArrayList<Move> hits = this.scanForHits();
    if (hits.size()==1) {
        Move move = hits.get(0);
        this.nextMove = new Move(move.row() - 1, move.col());
        this.nextMove1 = new Move(move.row() + 1, move.col());
        this.nextMove2 = new Move(move.row(), move.col() - 1);
        this.nextMove3 = new Move(move.row(), move.col() + 1);
        for (int i = 0; i < moves.size(); i++) {
            if (nextMove.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                moves.remove(i);
                ArrayList<Move> item = new ArrayList<>();
                item.add(nextMove);
                item.add(1, new Move(666, 666));
                moves.add(0, item);
            }
        }
        for (int i = 0; i < moves.size(); i++) {
            if (nextMove1.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                moves.remove(i);
                ArrayList<Move> item = new ArrayList<>();
                item.add(nextMove1);
                item.add(1, new Move(666, 666));
                moves.add(0, item);
            }
        }
        for (int i = 0; i < moves.size(); i++) {
            if (nextMove2.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                moves.remove(i);
                ArrayList<Move> item = new ArrayList<>();
                item.add(nextMove2);
                item.add(1, new Move(666, 666));
                moves.add(0, item);
            }
        }
        for (int i = 0; i < moves.size(); i++) {
            if (nextMove3.equals(moves.get(i).get(0))) {
//                      movesMade.add(moves.get(i).get(0));
                moves.remove(i);
                ArrayList<Move> item = new ArrayList<>();
                item.add(nextMove3);
                item.add(1, new Move(666, 666));
                moves.add(0, item);
            }
        }
    }
    else if (hits.size()==2){
        //see if they are directional x (
    }
}

}
