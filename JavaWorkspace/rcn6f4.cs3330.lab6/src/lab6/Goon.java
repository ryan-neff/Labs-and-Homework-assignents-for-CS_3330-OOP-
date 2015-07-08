/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

public class Goon {
 private String name;
 private String DOB;
 
 /**
  * Constructor for the class									*
  * @param name  String to become the name for the object       *
  * @param DOB   String to be the date of birth for the object  *
  */
 public Goon(String name, String DOB){
	 //call the setters
	 setName(name);
	 setDOB(DOB);
 }

 /**
  * Setter for the DOB attribute              *
  * @param DOB String to be the DOB attribute *
  */
protected void setDOB(String DOB) {
	this.DOB = DOB;
	
}

/**
 * Setter for the name attribute               *
 * @param name String to be the name attribute *
 */
protected void setName(String name) {
	this.name = name;
	
}

/**
 * Retrieves the name attribute of the object *
 * @return String that is the name            *
 */
public String getName(){
	return this.name;
}

/**
 * Retrieves the DOB attribute of the object *
 * @return String that is the DOB            *
 */
public String getDOB(){
	return this.DOB;
}
}
