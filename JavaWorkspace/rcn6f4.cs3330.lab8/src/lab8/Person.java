/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Sub code: Matt#Cool
 * Date 11/5/2014
 */
package lab8;

public class Person {
   private String name;
   private int age;
   private double bankAccountBalance;
   /**
    *  Constructor for the Person class
    * @param age int to be the age
    * @param acctBalance double to be the acct balance
    * @param name String to be the name
    */
  public Person(int age, double acctBalance, String name){
	  //call the setters 
	  setAge(age);  
	   setBankAccountBalance(acctBalance);
	   setName(name);
   }
/**
 * Sets the name instance variable for the object
 * @param name String to be the name
 */
private void setName(String name) {
	this.name = name;
	
}

/**
* Sets the bankAccountBalance instance variable for the object
* @param acctBalance double to be the bankAccountBalance
*/
private void setBankAccountBalance(double acctBalance) {
	this.bankAccountBalance = acctBalance;
}

/**
* Sets the age instance variable for the object
* @param age  int to be the age
*/
private void setAge(int age) {
	this.age= age;
}

/**
 * Retrieves the name for the object
 * @return String that is the name 
 */
public String getName(){
	return this.name;
}

/**
 * Retrieves the age for the object
 * @return int that is the age 
 */
public int getAge(){
	return this.age;
}

/**
 * Retrieves the bank account balance for the object
 * @return double that is the bank account balance
 */
public double getBankAccountBalance(){
	return this.bankAccountBalance;
}

/**
 * Formats a string with all of the objects instance variables
 * @return String   formatted string
 */
@Override
public String toString(){
	return String.format("%s %s\n%s %.2f \n%s %d \n", "Name:", this.getName(), "Bank Balance:", this.getBankAccountBalance(), "Age:", this.getAge());
}
}
