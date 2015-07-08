/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */
package lab7;

import java.util.ArrayList;

public class LabSevenDriver {
 
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Hawk("Hawk"));
		animals.add(new Bat("Bat"));
		animals.add(new Snake("Snake"));
		animals.add(new Monkey("Monkey"));
		
		findWhoCanEatWho(animals);
		findWhoCanFly(animals);
		findWhoCantFly(animals);

	}

	/**
	 * Searches the Animal ArrayList and finds those who can't fly
	 * Outputs to the users those that do along with their movement
	 * @param animals Array list of Animals
	 */
	private static void findWhoCantFly(ArrayList<Animal> animals) {
        System.out.println("\nAnimals that can't fly: \n");
		for(Animal animal : animals){           //For every animal in the list
        	if(!(animal instanceof Flying)){        //If they can not fly
        	   System.out.println(animal.toString()+" ");   //output the animal
        	   ((NonFlying) animal).movement();      //Call the movement method by down casting
        	}
        }
		
	}

	/**
	 * Searches the Animal ArrayList and finds those who can fly
	 * Outputs to the users those that do along with their movement
	 * @param animals Array list of Animals
	 */
	private static void findWhoCanFly(ArrayList<Animal> animals) {
		System.out.println("\nAnimals that can fly: \n"); 
		for(Animal animal : animals){                  //For every animal in the list
	        	if(animal instanceof Flying){         //If they can fly
	        	   System.out.println(animal.toString());   //output the animal
	        	   ((Flying)animal).takeOff();      //Call the takeOff and landing methods by down casting
	        	   ((Flying)animal).land();
	        	}
	        } 
		
	}
    
	/**
	 * takes every item in the the Array list and find what it can eat
	 * Prints out every animal it can eat
	 * @param animals Array list of Animal objects
	 */
	private static void findWhoCanEatWho(ArrayList<Animal> animals) {
	     System.out.println("\nEdible Animals: \n");  //lol "Editable Animals" 
		for(Animal animal :animals){                                        //for every animal object
	    	 
			/*
			 * Check if an animal can eat another by calling the objects eat method on 
			 * an instance of every type of animal. If the method returns true, call the animal's toString method
			 * with "and ate (animal)" appended
			 */
			if(animal.eat(new Hawk("Hawk"))){                    
	    		 System.out.printf("%sand ate a hawk \n",animal.toString());
	    	 } if(animal.eat(new Monkey("Monkey"))){
	    		 System.out.printf("%sand ate a monkey \n",animal.toString());
	    	 } if(animal.eat(new Bat("Bat"))){
	    		 System.out.printf("%sand ate a bat \n",animal.toString());
	    	 } if(animal.eat(new Snake("Snake"))){
	    		 System.out.printf("%sand ate a snake \n",animal.toString());
	    	 }
	    }
		
	}
}
