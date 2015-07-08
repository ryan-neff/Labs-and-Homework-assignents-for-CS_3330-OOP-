/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */
package lab7;

public class Bat extends Animal implements Flying{
   /**
    * Constructor for the Bat Class
    * calls the super constructor
    * @param type String to be the type
    */
	public Bat(String type){
    	  super(true, true, type); //call the super	  
     }
     
	/**
	 * Checks if the animal passed in is either a Snake or Bat
	 * return true if true
	 * @param food  Animal to be the checked animal
	 * @return true if Bat or Snake/ false if not
	 */
     public boolean eat(Animal food){
    	   if( food instanceof Snake || food instanceof Bat){ //check if the animal is instance of Snake or Bat
    		   return true; 								
    	   }
    	   return false;
     }
     
     /**
      * Prints a string that the bat has taken off
      */
     public void takeOff(){
       System.out.println("The bat has taken off!");	 
     }
     /**
      * Prints a string that the bat has landed
      */
     public void land(){
    	 System.out.println("The bat has landed on the ground");
     }
}
