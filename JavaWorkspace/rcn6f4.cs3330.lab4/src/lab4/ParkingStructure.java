/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Lab 4
 * Sub Code: Heartless
 */
package lab4;

import java.util.ArrayList;

public class ParkingStructure {
    //create a List of Levels to be used
	private ArrayList<Level> levels = null;
 
	
 /**
  * Constructor
  * Sets the calls the setter for the levels 
  * @param number to be used for the levels
  */
  public ParkingStructure(int numberOfLevels){
	   setLevels(numberOfLevels);
  }
 
  /**
   * Sets the levels for the instance
   * Checks if number is >0, if not, then 2 levels are added
   * @param number of levels to be used as the levels
   */
  private void setLevels(int numberOfLevels){
	this.levels = new ArrayList<Level>(); //instantiate the ArrayList
	 if(numberOfLevels <= 0 ){          //if the number is <=0
		this.levels.add(new Level(10)); //manually add 2 levels if that is the case
		this.levels.add(new Level(10));
	 }
	 else{                                        //if not ..
		 for(int i = 0; i < numberOfLevels; i++ ){ //..add levels to the ArrayList to the given number
			  this.levels.add(new Level(10));
		 }
		  
	 }
    }
  
  /**
   * Checks if the level is filled with cars
   * @return false if it is NOT full, true if it IS full
   */
  public boolean isFull(){
	 for(Level level : levels){  //for each level in the ArrayList..
        if(!level.isFull()){   
        	 return false;   //..return false immediately if a level is not full
        }
      }
	         return true;  //return true if all levels are filled
    }
  
  /**
   * Inserts in a given level granted it is not full 
   * @param an instance of Car to be inserted into a level 
   * @return the index + 1 to be the floor in which the car resides
   */
  public int addCar(Car incommingCar){
	   for(Level level : levels){    //for each level in the ArrayList..
		   if(!level.isFull()){       //..if there is an open space in the level..
			    level.addCar(incommingCar);  //..insert the car in that level
		        return levels.indexOf(level)+1; //..and return the index + 1
		   }
	   }
	    return 0; //return 0 if all is full
    }
	
}
