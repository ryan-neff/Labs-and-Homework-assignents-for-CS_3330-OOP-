/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Sub code: Matt#Cool
 * Date 11/5/2014
 */
package lab8;

/**
 * Exception for the Account Balance
 * @author ryanneff
 *
 */
@SuppressWarnings("serial")
public class InvalidBalanceException extends Exception{
    public InvalidBalanceException(){}    
	
    public InvalidBalanceException(String msg){
    	super(msg);
    }
}
