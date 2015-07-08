/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Lab 4
 * Sub Code: Heartless
 */
package lab4;

import java.util.ArrayList;

public class Level {
	
	//Create instances of an ArrayList to store the cars and a number of parking spots
	private ArrayList<Car> carsStored = null;
    private int numberOfParkingSpots;
    
    /**
     * Constructor
     * calls the setter to set the number of parking spots
     * @param number to be the parking spots
     */
    public Level(int numberOfParkingSpots){
    	 setParkingSpots(numberOfParkingSpots);
    }
    
    /**
     * Instantiates a new ArrayList for the Cars
     * Sets the number of parking spots
     * @param number to be the number of parking spots
     */
    private void setParkingSpots(int numberOfParkingSpots){
    	this.carsStored = new ArrayList<Car>();   //instantiate the ArrayList
    	this.numberOfParkingSpots = numberOfParkingSpots;  //set the number of parking spots
    }
    
    /**
     * checks to see if the number of cars stored is greater than the parking spots
     * @return return true if it is greater of equal and false if less than
     */
    public boolean isFull(){
      if(carsStored.size() >= this.numberOfParkingSpots){  //if the number of cars in the ArrayList is > the number of parking spots
    	   return true; //return true
      }else{
    	   return false;
      }
    }
    
    /**
     *  Adds a car to the Car ArrayList
     * @param Car object to be added
     */
    public void addCar(Car incommingCar){
    	 carsStored.add(incommingCar);  //add the car to the list
    }
}
