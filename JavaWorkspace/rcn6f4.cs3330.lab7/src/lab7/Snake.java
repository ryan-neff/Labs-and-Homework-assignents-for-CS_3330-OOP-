/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */
package lab7;

public class Snake extends Animal implements NonFlying {
/**
 * Constructor for the Snake class
 * @param type
 */
	public Snake(String type){
    	  super(false, false,"Snake");
      }
	
	/**
	 * Checks if the animal passed in is actually an animal
	 * return true if false
	 * @param food  Animal to be the checked animal
	 * @return true if not an animal/ false if an animal
	 */
      public boolean eat(Animal food){
    	  if(food instanceof Animal){ //check if animal is indeed an animal
    		  return false;
    	  }
    	  return false;
      }
      
      /**
       * Outputs a string saying the snake is slithering
       */
      public void movement(){
    	  System.out.println("The snake slithers on the ground");
      }
}
