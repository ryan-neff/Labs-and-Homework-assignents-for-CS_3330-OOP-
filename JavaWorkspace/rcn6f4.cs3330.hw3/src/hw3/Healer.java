/**
 * Name Ryan Neff
 * Pawprint rcn6f4
 * HW 3
 */
package hw3;

public class Healer extends Item{
   private int healthPoints;
    /**
     * Constructor for the healer class
     * @param name  String to be the name
     * @param level  String to be the level
     * @param weight  int to be the weight
     * @param points  int to be the points
     */
     public Healer(String name, String level, int weight, int points){
    	 super(name,level,weight);  //call the super constructor
    	 setHealthPoints(points);  //set the healthPoints
     }
    
     /**
      * retrieves the health points for the object
      * @return int  the heal points
      */
	public int getPoints() {
		return healthPoints;
	}

	/**
	 * set the health points for the object
	 * @param healthPoints   int to be the health points
	 */
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
}
