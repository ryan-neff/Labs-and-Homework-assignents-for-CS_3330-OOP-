/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */
package hw3;

public class CreatureResponse {
//create instance variables
private String response;
private boolean validAction;

/**
 * Constructor for the class
 * @param String response to be set
 * @param A boolean to be set for validAction
 */
public CreatureResponse(String response, boolean validAction){
      //call setters
	  setResponse(response);
      setValidAction(validAction);
      
    }

/**
 * Sets the valid action attribute for the object
 * @param boolean to be the validAction
 */
private void setValidAction(boolean validAction) {
	this.validAction = validAction;
}

/**
 * Sets the response attribute for the object
 * @param String to be the response
 */
private void setResponse(String response) {
	this.response = response;
}

/**
 * Retrieves the valid action attribute from the object
 * @return the valid action attribute
 */
public boolean getValidAction(){
	return this.validAction;
 }

/**
 * Retrieves the response attribute from the object
 * @return the response attribute
 */
public String getResponse(){
	return this.response;
  }
}
