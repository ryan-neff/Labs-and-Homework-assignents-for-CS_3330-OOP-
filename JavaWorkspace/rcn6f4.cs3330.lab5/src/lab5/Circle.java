/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

public class Circle extends Ellipse{
 
	/**
	 * Constructor for the Circle class
	 * calls super constructor to set all attributes
	 * (uses radius for both major and minor axis, for it is a circle)
	 * @param double to be the radius
	 * @param String to be the color
	 */
	public Circle(double radius, String color){
         super(radius,radius,color); //call super constructor to set  all attributes		
	}
	
	/**
	  * Formats the data of the ellipse into to a string 
	  * @return the formatted string
	  */
	@Override
	public String toString(){
		
		return String.format("%s %s %f %f", "Circle",this.getColor(),this.calcArea(), this.calcPerimeter());
	}
}
