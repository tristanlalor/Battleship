package com.tlalor.battleship;
/**
The Game class holds data for two gameboards, and loads fleet positions for the computer and user from text files.
*/
import java.io.*;
import java.util.*;
public class Game {

    private ComputerBoard computer;
    private UserBoard player;

/**
Constructor - Initializes the computer and user board.
*/
    public Game() throws java.io.IOException
   {
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   }
   public Game(int x) throws java.io.IOException
   {
       computer = new ComputerBoard();
       player = new UserBoard();
   }
   public void addShipToUserLayout(int start_row, int end_row,int start_col, int end_col, boolean horizontal, ShipType shipType)
   {
       player.addShipToUserLayout(start_row,end_row,start_col,end_col,horizontal,shipType);
   }
   
   
/**
makeComputerMove calls makeComputerMove() on the player's board.
@return String[] an array of the computer's move and a description of the outcome of the move
*/  
   public String[] makeComputerMove()
   {
      return player.makeComputerMove();
   }

/**
Accepts the player's move and applies it to the computer's board. Takes a move and makes it AGAINST this board. Takes in move to be applied. Returns either null, or, if the
move sank a ship, a String along the lines of "You sank My Battleship!"
@param String move - the move made by the player
@return 
*/
   public String makePlayerMove(String string)
   {
      Move pMove = new Move(string);
      return computer.makePlayerMove(pMove);
   }
   public String makePlayerMove(int x, int y)
   {
      Move pMove = new Move(x,y);
      return computer.makePlayerMove(pMove);
   }
/**
A boolean returning function that returns true if the computer has been defeated.
@return boolean true if the game is over.
*/
   public boolean computerDefeated()
   {
      return computer.gameOver();
   }
/**
A boolean returning function that returns true if the computer has been defeated.
@return boolean true if the game is over.
*/
   public boolean userDefeated()
   {
      return player.gameOver();
   }
/**
Returns a String representation of both the userBoard and computerBoard, displaying the first character of the String returned by the
toString method overridden in CellStatus
@return String str
*/  
   @Override
    public String toString()
    {
      return "\nCOMPUTER\n"+computer.toString()+"\nUSER\n"+player.toString();
    }
    
    public CellStatus getComputerStatus(int row, int col)
    {
      return computer.getStatus(row,col);
   
    }
      public CellStatus getUserStatus(int row, int col)
    {
      return player.getStatus(row,col);
   
    }

 }