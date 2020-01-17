package com.tlalor.battleship;
/**
The Board class makes a board of cells and holds the layout, fleet, and SIZE constant.
*/
import java.io.*;
import java.util.*;
public class Board {

    private ArrayList<ArrayList<CellStatus>> layout;
    private Fleet fleet;
    final public int SIZE = 10;

/**
Constructor - Initializes layout, initially setting all cells to CellStatus.NOTHING. Then calls loadFromFile() and passes it
filename to add ships to the layout. Initializes Fleet.
@param String filename to load the fleet from a file.
*/
    public Board(String filename) throws IOException
    {
        //Generate the ArrayLists with NOTHING as the CellStatus
        layout = new ArrayList<ArrayList<CellStatus>>();
        for (int i = 0; i < SIZE; i++)
         {
            layout.add(new ArrayList<CellStatus>());
            for (int j = 0; j < SIZE; j++) 
            {
               layout.get(i).add(j,CellStatus.NOTHING);
            }           
         }
         //Initialize the fleet
         fleet = new Fleet();
         this.loadFromFile(filename);
      }
      public Board()
      {
         //Generate the ArrayLists with NOTHING as the CellStatus
         layout = new ArrayList<ArrayList<CellStatus>>();
         for (int i = 0; i < SIZE; i++)
         {
            layout.add(new ArrayList<CellStatus>());
            for (int j = 0; j < SIZE; j++)
            {
               layout.get(i).add(j,CellStatus.NOTHING);
            }
         }
         //Initialize the fleet
         fleet = new Fleet();

      }
 /**
 getLayout
 @return ArrayList<ArrayList<CellStatus>> layout of the current board
 */         
      public ArrayList<ArrayList<CellStatus>> getLayout(){
         return layout;
      }
      
/**
returns the index value of a move
@param String move - the move
@return int - the index value of the column.
*/
      public static int returnRow(String string){
         switch (string.charAt(0)) {
                     case 'A':
                        return 0;
                     
                     case 'B':
                        return 1;
                      
                     case 'C':
                        return 2;
                      
                     case 'D':
                        return 3;
                        
                     case 'E':
                        return 4;
                       
                     case 'F':
                        return 5;
                     
                     case 'G':
                        return 6;
                     
                     case 'H':
                        return 7;
                    
                     case 'I':
                        return 8;
                    
                     case 'J':
                        return 9;
             
                     default:
                        return 0;
        
                     }
            }
/**
returns the index value of a move
@param String move - the move
@return int - the index value of the row.
*/
      public static int returnCol(String string){
         return Integer.parseInt(string.substring(1))-1;
         }
/**
Applies a move to layout. If the targeted cell does not contain a ship, it is set to CellStatus.NOTHING_HIT. If it
contains a ship, the cell is changed from, for instance, CellStatus.SUB to CellStatus.SUB_HIT. It returns the
original CellStatus of the targeted cell.
@param Move move - the move to be applied to the board
*/
      public void applyMoveToLayout(Move move){
         if (moveTaken(move) == false)
         {
            switch (layout.get(move.row()).get(move.col())){
               
//################################################################################################################################################################
               case AIRCRAFT_CARRIER:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_TOP:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_TOP_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_BOTTOM:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_LEFT:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_LEFT_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_RIGHT:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_V:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_V_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
               case AIRCRAFT_CARRIER_H:
                  layout.get(move.row()).set(move.col(),CellStatus.AIRCRAFT_CARRIER_H_HIT);
                  if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || layout.get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT)
                              layout.get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                           }           
                        }
                     }
                  break;
//################################################################################################################################################################
               case DESTROYER:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_TOP:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_TOP_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_BOTTOM:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_BOTTOM_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_LEFT:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_LEFT_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_RIGHT:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_RIGHT_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_V:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_V_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
               case DESTROYER_H:
                  layout.get(move.row()).set(move.col(),CellStatus.DESTROYER_H_HIT);
                  if (fleet.updateFleet(ShipType.ST_DESTROYER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.DESTROYER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_TOP_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_LEFT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_H_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_V_HIT || layout.get(i).get(j) == CellStatus.DESTROYER_HIT)
                              layout.get(i).set(j,CellStatus.DESTROYER_SUNK);
                           }           
                        }
                     }
                  break;
//################################################################################################################################################################
               case BATTLESHIP:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_TOP:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_TOP_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_BOTTOM:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_BOTTOM_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_LEFT:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_LEFT_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_RIGHT:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_RIGHT_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_V:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_V_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
               case BATTLESHIP_H:
                  layout.get(move.row()).set(move.col(),CellStatus.BATTLESHIP_H_HIT);
                  if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.BATTLESHIP_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_TOP_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_LEFT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_RIGHT_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_H_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_V_HIT || layout.get(i).get(j) == CellStatus.BATTLESHIP_HIT)
                              layout.get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                           }           
                        }
                     }
                  break;
//################################################################################################################################################################
               case SUB:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_TOP:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_TOP_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_BOTTOM:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_BOTTOM_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_LEFT:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_LEFT_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_RIGHT:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_RIGHT_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_V:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_V_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
               case SUB_H:
                  layout.get(move.row()).set(move.col(),CellStatus.SUB_H_HIT);
                  if (fleet.updateFleet(ShipType.ST_SUB))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.SUB_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.SUB_TOP_HIT || layout.get(i).get(j) == CellStatus.SUB_LEFT_HIT || layout.get(i).get(j) == CellStatus.SUB_RIGHT_HIT || layout.get(i).get(j) == CellStatus.SUB_H_HIT || layout.get(i).get(j) == CellStatus.SUB_V_HIT || layout.get(i).get(j) == CellStatus.SUB_HIT)
                              layout.get(i).set(j,CellStatus.SUB_SUNK);
                           }           
                        }
                     }
                  break;
//################################################################################################################################################################
               case CRUISER:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_TOP:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_TOP_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_BOTTOM:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_BOTTOM_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_LEFT:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_LEFT_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_RIGHT:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_RIGHT_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_V:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_V_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
               case CRUISER_H:
                  layout.get(move.row()).set(move.col(),CellStatus.CRUISER_H_HIT);
                  if (fleet.updateFleet(ShipType.ST_CRUISER))
                     {
                        for (int i = 0; i < SIZE; i++)
                        {
                           for (int j = 0; j < SIZE; j++) 
                           {
                              if (layout.get(i).get(j) == CellStatus.CRUISER_BOTTOM_HIT || layout.get(i).get(j) == CellStatus.CRUISER_TOP_HIT || layout.get(i).get(j) == CellStatus.CRUISER_LEFT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_RIGHT_HIT || layout.get(i).get(j) == CellStatus.CRUISER_H_HIT || layout.get(i).get(j) == CellStatus.CRUISER_V_HIT || layout.get(i).get(j) == CellStatus.CRUISER_HIT)
                              layout.get(i).set(j,CellStatus.CRUISER_SUNK);
                           }           
                        }
                     }
                  break;
//################################################################################################################################################################
               case NOTHING:
                  layout.get(move.row()).set(move.col(),CellStatus.NOTHING_HIT);
                  break;
               default:
                  break;
            }       
         }
      }
      
/**
Determines whether or not the move has already been made on the board.
Takes a move and determines if the spot is available
@param Move move
@return boolean true if the move has already been made.
*/
      public boolean moveTaken(Move move){
            switch (layout.get(move.row()).get(move.col())){
               case AIRCRAFT_CARRIER:
                  return false;
               case AIRCRAFT_CARRIER_LEFT:
                  return false;
               case AIRCRAFT_CARRIER_RIGHT:
                  return false;
               case AIRCRAFT_CARRIER_TOP:
                  return false;
               case AIRCRAFT_CARRIER_BOTTOM:
                  return false;
               case AIRCRAFT_CARRIER_V:
                  return false;
               case AIRCRAFT_CARRIER_H:
                  return false;
               case DESTROYER:
                  return false;
               case DESTROYER_LEFT:
                  return false;
               case DESTROYER_RIGHT:
                  return false;
               case DESTROYER_TOP:
                  return false;
               case DESTROYER_BOTTOM:
                  return false;
               case DESTROYER_V:
                  return false;
               case DESTROYER_H:
                  return false;
               case BATTLESHIP:
                  return false;
               case BATTLESHIP_LEFT:
                  return false;
               case BATTLESHIP_RIGHT:
                  return false;
               case BATTLESHIP_TOP:
                  return false;
               case BATTLESHIP_BOTTOM:
                  return false;
               case BATTLESHIP_V:
                  return false;
               case BATTLESHIP_H:
                  return false;
               case SUB:
                  return false;
               case SUB_LEFT:
                  return false;
               case SUB_RIGHT:
                  return false;
               case SUB_TOP:
                  return false;
               case SUB_BOTTOM:
                  return false;
               case SUB_V:
                  return false;
               case SUB_H:
                  return false;
               case CRUISER:
                  return false;
               case CRUISER_LEFT:
                  return false;
               case CRUISER_RIGHT:
                  return false;
               case CRUISER_TOP:
                  return false;
               case CRUISER_BOTTOM:
                  return false;
               case CRUISER_V:
                  return false;
               case CRUISER_H:
                  return false;
               case NOTHING:
                  return false;
               default:
                  return true;
            }       
         
      }
   public boolean shipNotHere(int row, int col){
      switch (layout.get(row).get(col)){
         case AIRCRAFT_CARRIER:
            return false;
         case AIRCRAFT_CARRIER_LEFT:
            return false;
         case AIRCRAFT_CARRIER_RIGHT:
            return false;
         case AIRCRAFT_CARRIER_TOP:
            return false;
         case AIRCRAFT_CARRIER_BOTTOM:
            return false;
         case AIRCRAFT_CARRIER_V:
            return false;
         case AIRCRAFT_CARRIER_H:
            return false;
         case DESTROYER:
            return false;
         case DESTROYER_LEFT:
            return false;
         case DESTROYER_RIGHT:
            return false;
         case DESTROYER_TOP:
            return false;
         case DESTROYER_BOTTOM:
            return false;
         case DESTROYER_V:
            return false;
         case DESTROYER_H:
            return false;
         case BATTLESHIP:
            return false;
         case BATTLESHIP_LEFT:
            return false;
         case BATTLESHIP_RIGHT:
            return false;
         case BATTLESHIP_TOP:
            return false;
         case BATTLESHIP_BOTTOM:
            return false;
         case BATTLESHIP_V:
            return false;
         case BATTLESHIP_H:
            return false;
         case SUB:
            return false;
         case SUB_LEFT:
            return false;
         case SUB_RIGHT:
            return false;
         case SUB_TOP:
            return false;
         case SUB_BOTTOM:
            return false;
         case SUB_V:
            return false;
         case SUB_H:
            return false;
         case CRUISER:
            return false;
         case CRUISER_LEFT:
            return false;
         case CRUISER_RIGHT:
            return false;
         case CRUISER_TOP:
            return false;
         case CRUISER_BOTTOM:
            return false;
         case CRUISER_V:
            return false;
         case CRUISER_H:
            return false;
         case NOTHING:
            return true;
         default:
            return true;
      }

   }

/**
Loads the fleet into the layout of the board from a file.
Accepts a string filename as an input.
@param String filename the name of the file containing fleet data
*/
      public void loadFromFile(String filename) throws IOException
      {
            String[] tempArray;
            String delimiter = " ";
            Scanner infile = new Scanner(getClass().getClassLoader().getResourceAsStream(filename));
            while (infile.hasNext())
               {            
                  String line = infile.nextLine();
                  tempArray = line.split(delimiter);

                  int start_col_index = returnCol(tempArray[1]);
                  int start_row_index = returnRow(tempArray[1]);
                  int end_col_index = returnCol(tempArray[2]);
                  int end_row_index = returnRow(tempArray[2]);
                  boolean vertical = start_col_index == end_col_index;
                  
                  
                  switch (line.charAt(0)) {
                     case 'C':
                        if (vertical && start_row_index < end_row_index)
                        {
                           int iteration_index = start_row_index;
                           do
                           {
                              if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_TOP);
                              else if (iteration_index > start_row_index && iteration_index < end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_V);
                              else if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_row_index);
                        }
                        else if (vertical && start_row_index > end_row_index)
                        {
                           int iteration_index = end_row_index;
                           do
                           {
                              if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_TOP);
                              else if (iteration_index > end_row_index && iteration_index < start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_V);
                              else if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_row_index);
                        }
                        else if (!vertical && start_col_index < end_col_index)
                        {
                           int iteration_index = start_col_index;
                           do
                           {
                              if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_LEFT);
                              else if (iteration_index > start_col_index && iteration_index < end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_H);
                              else if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_col_index);
                        }
                        else if (!vertical && start_col_index > end_col_index)
                        {
                           int iteration_index = end_col_index;
                           do
                           {
                              if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_LEFT);
                              else if (iteration_index < start_col_index && iteration_index > end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_H);
                              else if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_col_index);
                        }
                         
                        break;
                     case 'A':
                        if (vertical && start_row_index < end_row_index)
                        {
                           int iteration_index = start_row_index;
                           do
                           {
                              if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_TOP);
                              else if (iteration_index > start_row_index && iteration_index < end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_V);
                              else if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_row_index);
                        }
                        else if (vertical && start_row_index > end_row_index)
                        {
                           int iteration_index = end_row_index;
                           do
                           {
                              if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_TOP);
                              else if (iteration_index > end_row_index && iteration_index < start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_V);
                              else if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_row_index);
                        }
                        else if (!vertical && start_col_index < end_col_index)
                        {
                           int iteration_index = start_col_index;
                           do
                           {
                              if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_LEFT);
                              else if (iteration_index > start_col_index && iteration_index < end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_H);
                              else if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_col_index);
                        }
                        else if (!vertical && start_col_index > end_col_index)
                        {
                           int iteration_index = end_col_index;
                           do
                           {
                              if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_LEFT);
                              else if (iteration_index < start_col_index && iteration_index > end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_H);
                              else if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_col_index);
                        }
                         
                        break;
                     case 'B':
                        if (vertical && start_row_index < end_row_index)
                        {
                           int iteration_index = start_row_index;
                           do
                           {
                              if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_TOP);
                              else if (iteration_index > start_row_index && iteration_index < end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_V);
                              else if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_row_index);
                        }
                        else if (vertical && start_row_index > end_row_index)
                        {
                           int iteration_index = end_row_index;
                           do
                           {
                              if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_TOP);
                              else if (iteration_index > end_row_index && iteration_index < start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_V);
                              else if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_row_index);
                        }
                        else if (!vertical && start_col_index < end_col_index)
                        {
                           int iteration_index = start_col_index;
                           do
                           {
                              if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_LEFT);
                              else if (iteration_index > start_col_index && iteration_index < end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_H);
                              else if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_col_index);
                        }
                        else if (!vertical && start_col_index > end_col_index)
                        {
                           int iteration_index = end_col_index;
                           do
                           {
                              if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_LEFT);
                              else if (iteration_index < start_col_index && iteration_index > end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_H);
                              else if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_col_index);
                        }
                         
                        break;
                     case 'S':
                        if (vertical && start_row_index < end_row_index)
                        {
                           int iteration_index = start_row_index;
                           do
                           {
                              if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_TOP);
                              else if (iteration_index > start_row_index && iteration_index < end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_V);
                              else if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_row_index);
                        }
                        else if (vertical && start_row_index > end_row_index)
                        {
                           int iteration_index = end_row_index;
                           do
                           {
                              if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_TOP);
                              else if (iteration_index > end_row_index && iteration_index < start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_V);
                              else if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.SUB_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_row_index);
                        }
                        else if (!vertical && start_col_index < end_col_index)
                        {
                           int iteration_index = start_col_index;
                           do
                           {
                              if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_LEFT);
                              else if (iteration_index > start_col_index && iteration_index < end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_H);
                              else if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_col_index);
                        }
                        else if (!vertical && start_col_index > end_col_index)
                        {
                           int iteration_index = end_col_index;
                           do
                           {
                              if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_LEFT);
                              else if (iteration_index < start_col_index && iteration_index > end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_H);
                              else if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.SUB_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_col_index);
                        }
                         
                        break;
                     case 'D':
                        if (vertical && start_row_index < end_row_index)
                        {
                           int iteration_index = start_row_index;
                           do
                           {
                              if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_TOP);
                              else if (iteration_index > start_row_index && iteration_index < end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_V);
                              else if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_row_index);
                        }
                        else if (vertical && start_row_index > end_row_index)
                        {
                           int iteration_index = end_row_index;
                           do
                           {
                              if (iteration_index == end_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_TOP);
                              else if (iteration_index > end_row_index && iteration_index < start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_V);
                              else if (iteration_index == start_row_index)
                                 layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_BOTTOM);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_row_index);
                        }
                        else if (!vertical && start_col_index < end_col_index)
                        {
                           int iteration_index = start_col_index;
                           do
                           {
                              if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_LEFT);
                              else if (iteration_index > start_col_index && iteration_index < end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_H);
                              else if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= end_col_index);
                        }
                        else if (!vertical && start_col_index > end_col_index)
                        {
                           int iteration_index = end_col_index;
                           do
                           {
                              if (iteration_index == end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_LEFT);
                              else if (iteration_index < start_col_index && iteration_index > end_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_H);
                              else if (iteration_index == start_col_index)
                                 layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_RIGHT);
                              else
                                 break;
                              iteration_index++;
                              
                                 
                           } while (iteration_index <= start_col_index);
                        }
                         
                        break;
                     default: 
                        break;   
                  }
               }

      }
/**
game over yes or no
@return boolean true if the game is over.
*/
      public boolean gameOver(){
         return fleet.gameOver();
      }

/**
This method gets the fleet from the board.
@return Fleet fleet- returns the fleet from the board.
*/
      public Fleet getFleet(){
         return this.fleet;
      }
      
      public CellStatus getStatus(int row, int col)
       {
       return layout.get(row).get(col);
      
       }
   public void addShipToUserLayout(int start_row, int end_row,int start_col, int end_col, boolean horizontal, ShipType ship)
   {



         char charShip = 'A';
         //set the length for the appropriate type
         switch (ship){
            case ST_AIRCRAFT_CARRIER:
                    {
                       charShip = 'A';
                       break;
                    }
            case ST_BATTLESHIP:
                    {
                       charShip = 'B';
                       break;
                    }
            case ST_CRUISER:
            {
               charShip = 'C';
               break;
            }
            case ST_DESTROYER:
            {
               charShip = 'D';
               break;
            }
            case ST_SUB:
            {
               charShip = 'S';
               break;
            }
            default:
               break;
         }

         //Get user's starting cell

         //get vertical or horizontal

         int start_col_index = start_col;
         int start_row_index = start_row;
         int end_col_index = end_col;
         int end_row_index = end_row;


         boolean vertical = !horizontal;


         switch (charShip) {
            case 'C':
               if (vertical && start_row_index < end_row_index)
               {
                  int iteration_index = start_row_index;
                  do
                  {
                     if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_TOP);
                     else if (iteration_index > start_row_index && iteration_index < end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_V);
                     else if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_row_index);
               }
               else if (vertical && start_row_index > end_row_index)
               {
                  int iteration_index = end_row_index;
                  do
                  {
                     if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_TOP);
                     else if (iteration_index > end_row_index && iteration_index < start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_V);
                     else if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.CRUISER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_row_index);
               }
               else if (!vertical && start_col_index < end_col_index)
               {
                  int iteration_index = start_col_index;
                  do
                  {
                     if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_LEFT);
                     else if (iteration_index > start_col_index && iteration_index < end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_H);
                     else if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_col_index);
               }
               else if (!vertical && start_col_index > end_col_index)
               {
                  int iteration_index = end_col_index;
                  do
                  {
                     if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_LEFT);
                     else if (iteration_index < start_col_index && iteration_index > end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_H);
                     else if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.CRUISER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_col_index);
               }

               break;
            case 'A':
               if (vertical && start_row_index < end_row_index)
               {
                  int iteration_index = start_row_index;
                  do
                  {
                     if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_TOP);
                     else if (iteration_index > start_row_index && iteration_index < end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_V);
                     else if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_row_index);
               }
               else if (vertical && start_row_index > end_row_index)
               {
                  int iteration_index = end_row_index;
                  do
                  {
                     if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_TOP);
                     else if (iteration_index > end_row_index && iteration_index < start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_V);
                     else if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.AIRCRAFT_CARRIER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_row_index);
               }
               else if (!vertical && start_col_index < end_col_index)
               {
                  int iteration_index = start_col_index;
                  do
                  {
                     if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_LEFT);
                     else if (iteration_index > start_col_index && iteration_index < end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_H);
                     else if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_col_index);
               }
               else if (!vertical && start_col_index > end_col_index)
               {
                  int iteration_index = end_col_index;
                  do
                  {
                     if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_LEFT);
                     else if (iteration_index < start_col_index && iteration_index > end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_H);
                     else if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.AIRCRAFT_CARRIER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_col_index);
               }

               break;
            case 'B':
               if (vertical && start_row_index < end_row_index)
               {
                  int iteration_index = start_row_index;
                  do
                  {
                     if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_TOP);
                     else if (iteration_index > start_row_index && iteration_index < end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_V);
                     else if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_row_index);
               }
               else if (vertical && start_row_index > end_row_index)
               {
                  int iteration_index = end_row_index;
                  do
                  {
                     if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_TOP);
                     else if (iteration_index > end_row_index && iteration_index < start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_V);
                     else if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.BATTLESHIP_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_row_index);
               }
               else if (!vertical && start_col_index < end_col_index)
               {
                  int iteration_index = start_col_index;
                  do
                  {
                     if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_LEFT);
                     else if (iteration_index > start_col_index && iteration_index < end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_H);
                     else if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_col_index);
               }
               else if (!vertical && start_col_index > end_col_index)
               {
                  int iteration_index = end_col_index;
                  do
                  {
                     if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_LEFT);
                     else if (iteration_index < start_col_index && iteration_index > end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_H);
                     else if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.BATTLESHIP_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_col_index);
               }

               break;
            case 'S':
               if (vertical && start_row_index < end_row_index)
               {
                  int iteration_index = start_row_index;
                  do
                  {
                     if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_TOP);
                     else if (iteration_index > start_row_index && iteration_index < end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_V);
                     else if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_row_index);
               }
               else if (vertical && start_row_index > end_row_index)
               {
                  int iteration_index = end_row_index;
                  do
                  {
                     if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_TOP);
                     else if (iteration_index > end_row_index && iteration_index < start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_V);
                     else if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.SUB_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_row_index);
               }
               else if (!vertical && start_col_index < end_col_index)
               {
                  int iteration_index = start_col_index;
                  do
                  {
                     if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_LEFT);
                     else if (iteration_index > start_col_index && iteration_index < end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_H);
                     else if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_col_index);
               }
               else if (!vertical && start_col_index > end_col_index)
               {
                  int iteration_index = end_col_index;
                  do
                  {
                     if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_LEFT);
                     else if (iteration_index < start_col_index && iteration_index > end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_H);
                     else if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.SUB_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_col_index);
               }

               break;
            case 'D':
               if (vertical && start_row_index < end_row_index)
               {
                  int iteration_index = start_row_index;
                  do
                  {
                     if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_TOP);
                     else if (iteration_index > start_row_index && iteration_index < end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_V);
                     else if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_row_index);
               }
               else if (vertical && start_row_index > end_row_index)
               {
                  int iteration_index = end_row_index;
                  do
                  {
                     if (iteration_index == end_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_TOP);
                     else if (iteration_index > end_row_index && iteration_index < start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_V);
                     else if (iteration_index == start_row_index)
                        layout.get(iteration_index).set(start_col_index,CellStatus.DESTROYER_BOTTOM);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_row_index);
               }
               else if (!vertical && start_col_index < end_col_index)
               {
                  int iteration_index = start_col_index;
                  do
                  {
                     if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_LEFT);
                     else if (iteration_index > start_col_index && iteration_index < end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_H);
                     else if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= end_col_index);
               }
               else if (!vertical && start_col_index > end_col_index)
               {
                  int iteration_index = end_col_index;
                  do
                  {
                     if (iteration_index == end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_LEFT);
                     else if (iteration_index < start_col_index && iteration_index > end_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_H);
                     else if (iteration_index == start_col_index)
                        layout.get(start_row_index).set(iteration_index,CellStatus.DESTROYER_RIGHT);
                     else
                        break;
                     iteration_index++;


                  } while (iteration_index <= start_col_index);
               }

               break;
            default:
               break;
         }
      }

   }
