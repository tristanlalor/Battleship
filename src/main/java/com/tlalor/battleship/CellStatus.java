package com.tlalor.battleship;
/**
 * Used to represent the status of elements on the board by the Grid class and to communicate with graphic interfaces.
 * At the start of the game, all cells are initialized to either the name of a ship (AIRCRAFT_CARRIER, BATTLESHIP, etc), 
 * NOTHING or DEFAULT. The same constant name with "_HIT" appended indicates that a salvo has landed on that cell. If a ship is
 * sunk, all cells associate with that ship are changed to their original value with "_SUNK" appended. DEFAULT is used only
 * to handle the case of an invalid move (a repeat move).
 *
 * The overridden .toString methods return two character strings. The first character is the character displayed in a
 * text interface for the computer's board, with fog of war intact, and the second character is the character displayed
 * in a text interface for the player's board, without fog of war.
 */
public enum CellStatus {
    AIRCRAFT_CARRIER{
        @Override
        public String toString(){ return "oA"; }
    },
    AIRCRAFT_CARRIER_HIT{
        @Override
        public String toString(){ return "HX"; }
    },
    AIRCRAFT_CARRIER_SUNK{
        @Override
        public String toString(){ return "AX"; }
    },AIRCRAFT_CARRIER_TOP,AIRCRAFT_CARRIER_BOTTOM,AIRCRAFT_CARRIER_LEFT,AIRCRAFT_CARRIER_RIGHT,AIRCRAFT_CARRIER_H,AIRCRAFT_CARRIER_V,
    AIRCRAFT_CARRIER_TOP_HIT,AIRCRAFT_CARRIER_BOTTOM_HIT,AIRCRAFT_CARRIER_LEFT_HIT,AIRCRAFT_CARRIER_RIGHT_HIT,AIRCRAFT_CARRIER_H_HIT,AIRCRAFT_CARRIER_V_HIT,
    BATTLESHIP{
        @Override
        public String toString(){ return "oB"; }
    },
    BATTLESHIP_HIT{
        @Override
        public String toString(){ return "HX"; }
    },
    BATTLESHIP_SUNK{
        @Override
        public String toString(){ return "BX"; }
    },BATTLESHIP_V,BATTLESHIP_H,BATTLESHIP_TOP,BATTLESHIP_BOTTOM,BATTLESHIP_RIGHT,BATTLESHIP_LEFT,
    BATTLESHIP_V_HIT,BATTLESHIP_H_HIT,BATTLESHIP_TOP_HIT,BATTLESHIP_BOTTOM_HIT,BATTLESHIP_RIGHT_HIT,BATTLESHIP_LEFT_HIT,
    CRUISER{
        @Override
        public String toString(){ return "oC"; }
    },CRUISER_V,CRUISER_H,CRUISER_TOP,CRUISER_BOTTOM,CRUISER_RIGHT,CRUISER_LEFT,
    CRUISER_V_HIT,CRUISER_H_HIT,CRUISER_TOP_HIT,CRUISER_BOTTOM_HIT,CRUISER_RIGHT_HIT,CRUISER_LEFT_HIT,
    CRUISER_HIT{
        @Override
        public String toString(){ return "HX"; }
    },
    CRUISER_SUNK{
        @Override
        public String toString(){ return "CX"; }
    },
    DESTROYER{
        @Override
        public String toString(){ return "oD"; }
    },DESTROYER_V,DESTROYER_H,DESTROYER_TOP,DESTROYER_BOTTOM,DESTROYER_RIGHT,DESTROYER_LEFT,
    DESTROYER_V_HIT,DESTROYER_H_HIT,DESTROYER_TOP_HIT,DESTROYER_BOTTOM_HIT,DESTROYER_RIGHT_HIT,DESTROYER_LEFT_HIT,
    DESTROYER_HIT{
        @Override
        public String toString(){ return "HX"; }
    },
    DESTROYER_SUNK{
        @Override
        public String toString(){ return "DX"; }
    },
    SUB{
        @Override
        public String toString(){ return "oS"; }
    },SUB_V,SUB_H,SUB_TOP,SUB_BOTTOM,SUB_RIGHT,SUB_LEFT,
    SUB_V_HIT,SUB_H_HIT,SUB_TOP_HIT,SUB_BOTTOM_HIT,SUB_RIGHT_HIT,SUB_LEFT_HIT,
    SUB_HIT{
        @Override
        public String toString(){ return "HX"; }
    },
    SUB_SUNK{
        @Override
        public String toString(){ return "SX"; }
    },
    NOTHING{
        @Override
        public String toString(){ return "oo"; }
    },
    NOTHING_HIT{
        @Override
        public String toString(){ return "xx"; }
    }
}
