package com.tlalor.battleship;
/**
 * The abstract base class for the ships on the board. Classes inheriting this class call the abstract constructor with
 * a size for the ship.
 */
public class Fleet {

    private Ship battleShip;
    private Ship aircraftCarrier;
    private Ship cruiser;
    private Ship sub;
    private Ship destroyer;
    
    

/** Constructor - Initializes Ship fields.*/
    public Fleet(){
      this.battleShip = new Battleship();
      this.aircraftCarrier = new AircraftCarrier();
      this.cruiser = new Cruiser();
      this.sub = new Sub();
      this.destroyer = new Destroyer();
    }

/** updates the fleet
@return boolean true if the ship has sunk
@param ShipType from the enumerated ShipType class
*/
    public boolean updateFleet(ShipType type){
        switch (type) {
         case ST_AIRCRAFT_CARRIER:
            return this.aircraftCarrier.hit();
         case ST_BATTLESHIP:
            return this.battleShip.hit();
         case ST_CRUISER:
            return this.cruiser.hit();
         case ST_DESTROYER:
            return this.destroyer.hit();
         case ST_SUB:
            return this.sub.hit();
         default:
            return false;
         }
      }
/** An overload for the updateFleet method that accepts a ship object rather than a ShipType.
@param Ship object
@return boolean true if the ship has sunk
*/     
      public boolean updateFleet(Ship ship){
         return ship.hit();
         }
      
        
    

/** 
Answers the essential existential question, "Is the game over? Is all lost? Was there any point to any of it?"
Returns true if all ships have been sunk, returns false if not.
@return boolean true if the game is over.
*/
    public boolean gameOver() {
        return (battleShip.getSunk() &&
         aircraftCarrier.getSunk() &&
         cruiser.getSunk() &&
         sub.getSunk() &&
         destroyer.getSunk());
    }
}
