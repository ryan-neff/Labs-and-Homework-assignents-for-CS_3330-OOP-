/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

public class Ellipse extends Shape{
	private double minorAxis,majorAxis;
	
	/**
	 * Constructor for the Ellipse class 
	 * calls super constructor to set the color
	 * sets the Minor and Major axes
	 * @param double value to be the minor axis
	 * @param double value to be the major axis
	 * @param String to be the color
	 */
	public Ellipse(double minorAxis, double majorAxis, String color){
		super(color);  //call super constructor
		setMinorAxis(minorAxis);  //call setters
		setMajorAxis(majorAxis);
	}
	
	/**
	 * Sets the Major Axis instance variable for the class object
	 * @param Double to become the major axis
	 */
	private void setMajorAxis(double majorAxis) {
		this.majorAxis = majorAxis;  //set the instance variable to the parameter
	}
	
	/**
	 * Sets the minor axis instance variable for the class object
	 * @param Double to become the minor axis
	 */
	private void setMinorAxis(double minorAxis) {
	    this.minorAxis = minorAxis;	 //set the instance variable to the parameter
	}
	
	/**
	 * gets the major axis from the object
	 * @return the value in the major axis instance variable
	 */
	public double getMajorAxis(){
		return this.majorAxis;
	}
	
	/**
	 * gets the minor axis from the object
	 * @return the value in the minor axis instance variable
	 */
	public double getMinorAxis(){
		return this.minorAxis;
	}
	
	/**
	 * Calculates the area for an ellipse
	 * Uses the majorAxis and minorAxis instance variables
	 * @return the calculated area
	 */
	 public double calcArea(){
		 return (Math.PI * this.majorAxis * this.minorAxis);
	 }
	 
	 /**
	  * Calculates the perimeter for an ellipse
	  * Uses the majorAxis and minorAxis instance variables
	  * @return the calculated perimeter
	  */
	 public double calcPerimeter(){
		 return (2*Math.PI) * (Math.sqrt(((minorAxis*minorAxis)+(majorAxis*majorAxis))/2));
	 }
	 
	 /**
	  * Formats the data of the ellipse into to a string 
	  * @return the formatted string
	  */
	 @Override
	 public String toString(){
		return String.format("%s %s %f %f","Elliple",this.getColor(),this.calcArea(), this.calcPerimeter());
	 }

}
