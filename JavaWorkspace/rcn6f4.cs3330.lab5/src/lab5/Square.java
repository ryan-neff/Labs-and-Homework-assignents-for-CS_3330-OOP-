/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

public class Square extends Rectangle{
	
	/**
	 * Constructor for the Square class
	 * calls super constructor to set all attributes
	 * (uses size for both length and width, for it is a square)
	 * @param double to be the length and width
	 * @param String to be the color
	 */
	public Square(double size, String color){
		super(size,size,color); //call super constructor
	}
	
	/**
	  * Formats the data of the ellipse into to a string 
	  * @return the formatted string
	  */
	@Override
	 public String toString(){
		return String.format("%s %s %f %f","Square",this.getColor(),this.calcArea(), this.calcPerimeter());
	 }

}
