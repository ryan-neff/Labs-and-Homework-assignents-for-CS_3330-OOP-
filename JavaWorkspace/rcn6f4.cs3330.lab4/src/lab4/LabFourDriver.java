/**
 * Name Ryan Neff
 * Pawprint rcn6f4
 * Lab 4
 * Sub Code Heartless
 */

package lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LabFourDriver {
    
	//Create all instance variables
	private static Scanner userInput;
    private static Random randomGenerator;
    private static ArrayList<String> carMakes = null;
    private static ArrayList<String> carTypes = null;
    private static ArrayList<String> carColors = null;
	
    
    public static void main(String[] args) {
		initAttributes();
		
		System.out.print("Enter number of parking structure levels: ");
		String input = userInput.nextLine();
		System.out.println(" ");
		
		ParkingStructure parkingStructure = new ParkingStructure(Integer.parseInt(input));
		
		while (!parkingStructure.isFull()) {
			Car incomingCar = createCar();
			System.out.println(incomingCar.getMake()
					+ " " + incomingCar.getType() + " " + incomingCar.getColor());
			int storageLevel = parkingStructure.addCar(incomingCar);
			System.out.println("Car Stored at level " + storageLevel);
			System.out.println(" ");
		}

		
	}
    
    /**
     * Sets values for all of the 
     * instance variable of the driver
     */
    private static void initAttributes(){
           randomGenerator = new Random(1337);  //set the random with a seed of 1337
           
           
    	   userInput = new Scanner(System.in); //instantiate a new scanner
    	 
    	  carMakes = new ArrayList<String>();  //Create and manually add values to get a list of car makes
    	      carMakes.add("Ford");
    	      carMakes.add("Toyota");
    	      carMakes.add("Dodge");
    	      carMakes.add("Honda");
    	      
    	  carTypes = new ArrayList<String>(); //Create and manually add values to get a list of car types
    	      carTypes.add("Sedan");
    	      carTypes.add("Truck");
    	      carTypes.add("Van");
    	      carTypes.add("Hatchback");
    	  
    	   carColors = new ArrayList<String>(); //Create and manually add values to get a list of car colors
    	       carColors.add("Blue");
    	       carColors.add("Green");
    	       carColors.add("Red");
    	       carColors.add("Purple");
    	       carColors.add("Orange");
    	       carColors.add("Yellow");
    }
    
    /**
     * Creates a psuedo-random instance of a Car object getting a random make, type, and color
     * @return the new instance of Car
     */
    private static Car createCar(){
    
      String make = carMakes.get(randomGenerator.nextInt(carMakes.size()));  //get random make
      String type = carTypes.get(randomGenerator.nextInt(carTypes.size()));  //get random type
      String color = carColors.get(randomGenerator.nextInt(carColors.size()));  //get random color
    
      return new Car(make,type,color);  //return the new Car
    }
    
    
}
