/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Lab 3
 * Submission Code: Nope Grubs
 */
package lab3;

public class Hero {
	//declare instance variables
	private String name, weapon;
	private int attackPoints;
   
	/**
	 * Constructor for the Hero class
	 * Calls all setters for class
	 * @param String to become name
	 * @param String to become weapon
	 * @param int to become the attackPoints
	 */
	public Hero(String name, String weapon, int attackPoints){
		//call all setters for the class
		setName(name);
		 setWeapon(weapon);
		 setAttackPoints(attackPoints);
	}
	
	/**
	 * Sets the name for the instance
	 * @param String to become the name
	 */
	private void setName(String name){
		this.name = name;  //set the string name to the instance variable
	}
	/**
	 * Sets the name for the instance
	 * @param String to become the weapon
	 */
	private void setWeapon(String weapon){
		this.weapon = weapon; // set the string weapon to the instance variable
	}
	
	/**
	 * Sets the attackPoints for the instance
	 * checks to see if points are greater than 0
	 * default is 11 
	 * @param int to become the attack points
	 */
	private void setAttackPoints(int attackPoints){
		if(attackPoints > 0){  //if > 0
		this.attackPoints = attackPoints; //assign int to the instance variable 
		}else{         // otherwise..
			this.attackPoints= 11; //..set points to 11
		}
		
	}
	/**
	 * Retrieves the instance of the name
	 * @return the name instance
	 */
	public String getName(){
		 return this.name;
	}
	/**
	 * Retrieves the instance of weapon
	 * @return the weapon instance
	 */
	public String getWeapon(){
		return this.weapon;
	}
	/**
	 * Retrieves the instance of AttackPoints
	 * @return the attackPoints instance
	 */
	public int getAttackPoints(){
		return this.attackPoints;
	}
    /**
     * sets a new value for attackPoints
     * @param newAttackPoints
     */
   public void updateAttackPoints( int newAttackPoints){
	   setAttackPoints(newAttackPoints); //set the new value
   }
}
