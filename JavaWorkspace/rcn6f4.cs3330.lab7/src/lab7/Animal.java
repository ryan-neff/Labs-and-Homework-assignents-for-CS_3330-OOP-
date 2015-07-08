/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Date: 10/29/2014
 * Lab 7
 * Sub Code: RoyalsMustWin
 */
package lab7;

public abstract class Animal {
 protected boolean legs;
 protected boolean wings;
 protected String type;
 
 /**
  * Construtor for the Animal class
  * @param legs  boolean to check for legs
  * @param wings  boolean to check for wings
  * @param type  String to be the type
  */
 public Animal(boolean legs, boolean wings, String type){
	 //call setters
	 setLegs(legs); 
	 setWings(wings);
	 setType(type);
 }

/** 
 * Sets the Type for the Animal Class
 * @param type  String to be the type
 */
private void setType(String type) {
 this.type = type;	
}

/** 
 * Sets the wings attribute for the Animal Class
 * @param wings  boolean to be the wings
 */
private void setWings(boolean wings) {
  this.wings = wings;	
}

/** 
 * Sets the legs attribute for the Animal Class
 * @param legs  boolean to be the legs
 */
private void setLegs(boolean legs) {
	 this.legs = legs;
}

/**
 * Retrieves the type for the class
 * @return  String that is the type attribute
 */
public String getType(){
	return this.type;
}

/**
 * Retrieves the legs attribute for the class
 * @return  boolean that is the legs attribute
 */
public boolean getLegs(){
	return this.legs;
}

/**
 * Retrieves the wings attribute for the class
 * @return  boolean that is the wings attribute
 */
public boolean getWings(){
	return this.wings;
}

/**
 * Formats a string depending on the animals type, legs, and wings
 * @return String   formatted string 
 */
@Override
 public String toString(){
	
	return String.format("The %s %s", this.getType(),(this.getWings() && this.getLegs())? "has wings and has legs " : (this.getLegs() && !(this.getWings()))? "does not have wings, but has legs" :"does not have legs or wings");
}
 
 public abstract boolean eat(Animal food);
}
