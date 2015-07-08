/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

public class Shape {
	private String color;
	
	/**
	 * Constructor for the Shape class
	 * calls setter for color
	 * @param String to be set for color instance variable
	 */
	public Shape(String color){
		setColor(color);  //call setter
	}
	
	/**
	 * Sets the color instance variable for the class object
	 * @param String to become the color
	 */
	private void setColor(String color){
		this.color = color;  //set the instance variable to the parameter
	}
	
	/**
	 * gets the color from the object
	 * @return the value in the color instance variable
	 */
	public String getColor(){
		 return this.color;
	}

}
