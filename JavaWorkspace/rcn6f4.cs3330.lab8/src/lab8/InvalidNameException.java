/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Sub code: Matt#Cool
 * Date 11/5/2014
 */
package lab8;

/**
 * Exception for the Name
 * @author ryanneff
 *
 */
@SuppressWarnings("serial")
public class InvalidNameException extends Exception {
  public InvalidNameException(){}
  
  public InvalidNameException(String msg){
	  super(msg);
  }
}
