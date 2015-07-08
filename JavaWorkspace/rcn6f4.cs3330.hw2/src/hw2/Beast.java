/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 2
 */

package hw2;


public class Beast {

private String name;
private Health health;


/**
 * Constructor for the Beast class
 * calls private setters
 * 
 * @param name to be set
 * @param health to be set
 */
public Beast(String name, int hp){
    setName(name);
    createHealth(hp);
 }

/**
 * Sets the health object for the beast
 * @param int to be the health amount
 */
 private void createHealth(int hp) {
	this.health = new Health(hp); //instantiates the health object for the beast object 	
  }


 /**
  * Sets the name instance variabe
  * @param String to be the name
  */
 private void setName(String name) {
	this.name = name; //set the name
	
  }

 /**
  * Retrieves the name instance variable
  * @return the name of the object
  */
 public String getName(){
     return this.name;	
  }


 /**
  * Retrieves the health points of the health instance variable
  * @return the health point of the object
  */
 public int getHealth(){
	return this.health.getHealthPoints();
  }

/**
 * Lowers the beasts health points by the value of a given item if the item is not null
 * @param item to injure the beast
 * @return true if item lowered the beasts health, false if item was not valid
 */
 public boolean injured(Item item){
	if(!(item == null)){  //if the item is not null..
		this.health.hit(item.getValue());  //..hit the beast with the item
		return true;
	}else{
       return false;
	}
 }

 /**
  * Checks if the beast is down for the count 
  * @return true if the beast's health points are not zero, false if dead 
  */
 public boolean isLiving(){
	  return this.health.getAlive();
 }
}
