/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Sub code: Matt#Cool
 * Date 11/5/2014
 */
package lab8;
/**
 * Exception for the Age
 * @author ryanneff
 *
 */
@SuppressWarnings("serial")
public class InvalidAgeException extends Exception {
  public InvalidAgeException(){}
  
  public InvalidAgeException(String msg){
	  super(msg);
  }
}
