/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

public class Overseer extends Goon{
    
	private String sector;
	
	/**
	 * Constructor for the class
	 * @param name   String to be the name (instantiated by super class) *
	 * @param DOB    String to be the DOB (Instantiated by super class)  *
	 * @param sector String to be the sector                             *
	 */
	public Overseer(String name,String DOB, String sector){
		super(name,DOB); //call superclass constructor
		setSector(sector); //call setter for local attributes
	}
	
	/**
	  * Setter for the sector attribute                 *
	  * @param sector string to be the sector attribute *
	  */
	protected void setSector(String sector){
		this.sector = sector;
	}
	
	/**
	 * Retrieves the sector attribute of the object *
	 * @return String that is the sector            *
	 */
	public String getSetcor(){
	 return this.sector;	
	}
}
