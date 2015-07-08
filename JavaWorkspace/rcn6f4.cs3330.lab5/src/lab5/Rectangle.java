/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

public class Rectangle extends Shape{
   //declare instance variables
	double width,height;
	
	/**
	 * Constructor for the Rectangle class
	 * Calls super constructor to set the color
	 * @param double to become the width
	 * @param double to become the height
	 * @param String to become the color
	 */
   public Rectangle(double width, double height, String color){
	   super(color);   //call super constructor
	   setWidth(width); //call setters for height and width
	   setHeight(height);
   }
    
	/**
	 * Sets the width instance variable for the class object
	 * @param Double to become the width
	 */
	private void setWidth(double width) {
		this.width = width;  //set the instance variable to the parameter
	}

	/**
	 * Sets the Height instance variable for the class object
	 * @param Double to become the height
	 */
	private void setHeight(double height) {
		this.height = height;  //set the instance variable to the parameter
	}
	
	/**
	 * gets the width from the object
	 * @return the value in the width instance variable
	 */
	public double getWidth(){
		return this.width;
	}
	
	/**
	 * gets the height from the object
	 * @return the value in the height instance variable
	 */
	public double getHeight(){
		return this.height;
	}
	
	/**
	 * Calculates the area for a rectangle
	 * uses the height and width instance variables
	 * @return the calculated area
	 */
	public double calcArea(){
		return width*height;
	}
	
	 /**
	  * Calculates the perimeter for an ellipse
	  * Uses the height and width instance variables
	  * @return the calculated perimeter
	  */
	public double calcPerimeter(){
		return (2*width) + (2*height);
	}
	
	/**
	  * Formats the data of the ellipse into to a string 
	  * @return the formatted string
	  */
	@Override
	public String toString(){
		return String.format("%s %s %f %f","Rectangle",this.getColor(),this.calcArea(), this.calcPerimeter());
	}
	
}
