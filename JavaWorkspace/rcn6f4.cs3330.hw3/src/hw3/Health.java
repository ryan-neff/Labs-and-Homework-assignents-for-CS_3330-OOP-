/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */
package hw3;

public class Health {
	private int healthPoints;
	private boolean alive;
	
	/**
	 * Default Constructor for the Health class
	 * calls the setters for the health and alive attributes
	 */
	public Health(){
	   setHealth(100);
	   setAlive(true);
	}
	
	/**
	 * Second Constructor for the Health Class
	 * Sets health to a specific value
	 * @param input to set the health other than the default
	 */
	public Health(int hp){
		setHealth(hp);
		setAlive(true);
	}
	
	/**
	 * Sets the alive attribute for the object
	 * @param boolean to be the value of alive
	 */
	private void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Sets the health attribute
	 * As long as the value is greater than 0 the value is set to the parameter, otherwise the player is no longer alive
	 * @param health points
	 */
	private void setHealth(int hp) {
		if(hp >= 1){                //as long as the hp is > 0
			this.healthPoints = hp;	//set to the parameter
		}
		else{
	       setAlive(false);  //otherwise the player is no longer alive
		}
		
	}
	
	/**
	 * Retrieves the health points from the object
	 * @return the health points of the object
	 */
	public int getHealthPoints(){
		return this.healthPoints;
	}
	
	/**
	 * Returns the alive value of the object
	 * @return the alive attribute
	 */
	public boolean getAlive(){
		return this.alive;
	}
	
	/**
	 * Decreases the health points by a number of hit Points
	 * @param hitPoints to decrease the health by
	 */
	public void hit(int hitPoints){
		setHealth(this.healthPoints - hitPoints);  //set the health to itself minus the value of hitPoints
    }
	/**
	 * Adds a value increasing the health points
	 * @param healPoints  int to be added to the objects hp
	 */
	public void heal(int healPoints){
		this.healthPoints+= healPoints;  // add to the hp
	}
}
