/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Homework 1
 */
package hw1;

public class Item {
	//declare instance variables
	private String name;
	private int value;
	private int weight;

	/**
	 * Constructor for the Item class
	 * sets name,value, and weight for a given item
	 * @param String to become name
	 * @param int to become value
	 * @param int to become weight
	 */
	public Item(String name, int value, int weight){
		//call all setters
		setName(name); 
		setValue(value);
		setWeight(weight);
	}
	/**
	 * sets the name for the given item
	 * @param string to become name for the instance
	 */
	private void setName(String name){
		this.name = name; //set string to name instance variable
	}
	/**
	 * sets the value for the given item
	 * @param int to become value for the given instance
	 */
	private void setValue(int value){
		 this.value= value; //sets the int to the value instance variable 
	}
	/**
	 * Sets the weight for the item
	 * @param int to become weigh for the instance
	 */
	private void setWeight(int weight){
		this.weight = weight; //sets the int to the weight instance variable
     }
	/**
	 * retrieves the name for the instance
	 * @return the name of the given item
	 */
	public String getName(){
		 return this.name;	 
	}
	/**
	 * retrieves the value of the instance 
	 * @return the value of the given item
	 */
	public int getValue(){
		return this.value;
	}
	/**
	 * retrieves the weight of the instance
	 * @return the weight of the given item
	 */
	public int getWeight(){
		return this.weight;
	}
	
}
