/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * HW 3
 */
package hw3;

public class Weapon extends Item{
    private int damagePoints;
    /**
     * Constructor for the Weapon class
     * @param name  String to be the name
     * @param level  String to be the level
     * @param weight  int to be the weight
     * @param damagePoints  int to be the damage points
     */
    public Weapon(String name, String level, int weight, int damagePoints){
    	super(name,level,weight);
    	setDamagePoints(damagePoints);
    }
	
    /**
     * retrieves the  points for the object
     * @return int  the points
     */
    public int getPoints() {
		return damagePoints;
	}
     
    /**
	 * set the health points for the object
	 * @param healthPoints   int to be the health points
	 */
	private void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}
	
    
}
