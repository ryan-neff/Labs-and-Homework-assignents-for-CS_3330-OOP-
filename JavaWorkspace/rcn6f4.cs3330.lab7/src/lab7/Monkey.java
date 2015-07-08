/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */

package lab7;

public class Monkey extends Animal implements NonFlying{
   /**
    * Constructor for he Monkey class
    * @param type  String to be the type
    */
	public Monkey(String type){
    	 super(true,false,"Monkey"); // call the super class
     }
	
	/**
	 * Checks if the animal passed in is a Snake
	 * return true if true
	 * @param food  Animal to be the checked animal
	 * @return true if Snake/ false if not
	 */
   public boolean eat(Animal food){
	    if(food instanceof Snake){ //Check if the animal is a snake
	    	return true;
	    }
	    return false;
   }
   
  /**
   * Prints a string saying the monkey is running
   */
   public void movement(){
	   System.out.println("The monkey is running on the ground");
   }
   
}
