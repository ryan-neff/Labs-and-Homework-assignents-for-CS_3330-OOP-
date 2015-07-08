/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */
package hw3;

import java.util.ArrayList;

public class Bag {
	
//declare instance variables	
   private ArrayList<Item> items;
   private int weight;
   
  /**
   * Constructor for the Bag Class
   * calls the bag initializer 
   */
   public Bag(){
	initBag();  
   }
   
   /**
    * Creates a new array list of items
    * initializes a weight as well
    */
   private void initBag(){
	   items = new ArrayList<Item>();
	   weight = 0; //set weight to zero
       Weapon weapon = new Weapon("Crowbar","Standard", 5, 30);
	    this.addItem(weapon);
      }
   
   /**
    * Adds a item to the given bag object as long as the added weight of the item does not exceed
    * the weight capacity of the bag 
    * @param item to be added
    * @return true if bag was added successfully, false if not
    */
   public boolean addItem(Item item){
	   if((this.weight + item.getWeight()) <= 20){ //if the added weight of the item is <= 20 (weight of the bag)..
		   this.weight += item.getWeight();       //..add the weight to the current weight of the bag
		   items.add(item);                       //..add the item to the bag
		   return true;
	   }
	   return false;
   }
   
   /**
    * Finds the given item in the bag, if the item is found
    * it is removed from the bag
    * @param item to drop
    * @return true if successfully removed, false if item was not found in the bag
    */
   public boolean dropItem(Item item){
	   for(Item bagItem : items){     										 //for each item in the bag..
		   if( item != null && bagItem.getName().equalsIgnoreCase(item.getName())){   //..if the item is not null and the name if the item matches the search item..
			   this.weight -= bagItem.getWeight();                         //.. get rid of the items weight from the bag weight..												
			   items.remove(items.indexOf(bagItem));					  //..remove the item
			   return true;
		   }
	   }
             return false;
   }
   
   /**
    * Retrieves the Item array list for the bag object
    * @return  The Item Array
    */
   public ArrayList<Item> getItems(){
	   return this.items;  //return the array list
   }
   /**
    * Retrieves the size for the array list of the bag object
    * @return  the size of the array list
    */ 
   public int getSize(){
	   return items.size();  
   }
   
    /**
     *  Searches for a given item in the items array list and
     *  Returns the given item if found.
     * @param item to search for
     * @return the Item if found, null if not found
     */
   public Item getItem(String name){
	   for(Item item : items){             //for every item in the array list
		   if(item.getName().equalsIgnoreCase(name)){   //..if the item is found in the array list
			   return item;               //..return the item
			  }  
	      }
	  return null;                      //..if not return null
     }
  /**
   * clears the array list and resets the weight 
   */
   public void dropItems(){
	    items.clear();
	   this.weight= 0;
   }
 
   /**
    * Gets the item at a given index and retrieves it 
    * @param ItemIdx   int of the index of the item
    * @return   the item at the index
    */
   public Item getItem(int ItemIdx){
	   return items.get(ItemIdx);
   }
   }
