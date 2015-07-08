/**
 * Name: Ryan Neff
 * PawPrint rcn6f4
 * Lab 4
 * Sub Code Heartless
 */
package lab4;

public class Car {
//create instance variables for the instance	
private String make, type, color;

/**
 * Constructor
 * Calls Setters for make, type, and color
 * @param String to become the make
 * @param String to become the type
 * @param String to become the color
 */
public Car(String make, String type, String color){
    //call all setters 
	setMake(make);  
     setType(type);
     setColor(color);
}

/**
 * Sets the make instance variable
 * @param String to become the make
 */
private void setMake(String make){
	 this.make= make; //set the instance to the given string
   }

/**
 * Sets the type instance variable
 * @param String to become the type
 */
private void setType(String type){
	this.type= type; //set the instance to the given string
  }

/**
 * Sets the color instance variable
 * @param String to become the color
 */
private void setColor(String color){
	this.color = color; //set the instance to the given string
  }


/**
 * Gets the make of the given instance
 * @return the make of the instance
 */
public String getMake(){
	 return this.make;
  }

/**
 * Gets the type of the given instance
 * @return the type of the instance
 */
public String getType(){
	return this.type;
 }

/**
 * Gets the color of the given instance
 * @return the color of the instance
 */
public String getColor(){
	return this.color;
 }


}
