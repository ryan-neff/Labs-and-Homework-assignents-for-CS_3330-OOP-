/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */
package lab7;


public class Hawk extends Animal implements Flying{
   /**
    * Constructor for the Hawk class 
    * @param type
    */
	public Hawk(String type){
	   super(true,true,"Hawk");  //call the super constructor
   }
	
	/**
	 * Checks if the animal passed in is either a Snake or Bat
	 * return true if true
	 * @param food  Animal to be the checked animal
	 * @return true if Bat or Snake/ false if not
	 */
   public boolean eat(Animal food){
	   if(food instanceof Snake || food instanceof Bat ){ //check if the animal is instance of Snake or Bat
		   return true;
	   }
	   return false;
   }
   
   /**
    * Prints a string that the hawk has taken off
    */
   public void takeOff(){
	   System.out.println("The hawk has taken off!");
   }
   
   /**
    * Prints a string that the hawk has landed
    */
   public void land(){
	   System.out.println("The hawk has landed on the ground");
   }
   
}
