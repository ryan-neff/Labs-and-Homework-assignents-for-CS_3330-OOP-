/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */

package hw3;


public class Beast extends GameCreature{
  private String type;
/**
 * Constructor for the Beast class
 * calls private setters
 * 
 * @param name to be set
 * @param health to be set
 */
public Beast(String type, String name, int hp, Bag emptyBag){
    super(name,hp,emptyBag);
	setType(type);
 }


 private void setType(String type) {
	// TODO Auto-generated method stub
	this.type = type;
}
 
 public String getType(){
	 return this.type;
 }


/**
  * Checks if the beast is down for the count 
  * @return true if the beast's health points are not zero, false if dead 
  */
 public boolean isLiving(){
	  return this.health.getAlive();
 }


 /**
  * Adds an item to the bag attribute 
  * @param item to add to the bag
  * @return true if the item was added, false if unsuccessful
  */
 public boolean pickup(Item item){
		return this.bag.addItem(item); //the result of addItem
		
	}
	
 /**
  * Drops a given item in the bag attribute
  * @param item to be removed
  * @return true if removed, false if unsuccessful
  */
	public boolean drop(Item item){
		return this.bag.dropItem(item); //return the resul of dropItem
		
	}
	
	/**
	 * Attacks a given Beast with a given Item
	 * @param beast to be injured
	 * @param item to injure the beast
	 * @return true if attack was successful, false if not
	 */
	public boolean attack(GameCreature creature, Item item){
		return creature.injured(item);		//return result of injured
	}
   /**
    * Implement the interface method to heal the beast
    * Adds items of a healer item to creatures health points
    * @return true if item is not null
    */
	@Override
	public boolean heal(Item item) {
		// TODO Auto-generated method stub
		if(!(item.equals(null)) && item instanceof Healer){
		this.health.heal(((Healer)item).getPoints()); 
	   return true;
		}
		return false;
	}
     /**
      * calls the drop items on the objects bag
      */
	@Override
	public void dropAll() {
		// TODO Auto-generated method stub
		this.bag.dropItems();
	}
}
