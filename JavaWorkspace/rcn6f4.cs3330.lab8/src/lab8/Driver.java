/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Sub code: Matt#Cool
 * Date 11/5/2014
 */
package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	/**
	 * Gets input (name, account balance, and age) from user
	 * Error handles all input 
	 * Outputs all user accounts
	 * @param args
	 */
  public static void main(String args []){
	  int age;
	  double balance;
	  String name;
	  String userInput = "";
	  ArrayList<Person> people = new ArrayList<Person>();  //create array list for account holders
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter person info or q to quit.");
	  System.out.println("Please enter the name of this person:");  //ask user for name and scan the input
	   userInput = sc.nextLine();   
	  while(!(userInput.equals("q"))){   //while the input is not q
		  try{
			 isName(userInput);  //check if the input is valid
		      name = userInput;    //if so make it the name
	         
		      System.out.println("Please enter the age for this person: ");
		     userInput = sc.nextLine();            
		     isValidAge(userInput);     //check is the name is valid
		    age = Integer.parseInt(userInput);  //if so parse the string and set it to the age
		 
		    System.out.println("Pleanse enter a bank account for this person: \n"); 
		    userInput = sc.nextLine();
		    isBalance(userInput);    //make sure the input is valid for the bank account
		     balance = Double.parseDouble(userInput); //if so parse the string and set it to the account
		   people.add(new Person(age,balance,name));  //create the person and add them to the list
		   
		  }catch(InvalidAgeException e){  //if an age exception is thrown catch it and output, start over
			  System.out.println("Execption thrown " + e);
		  }catch(InvalidBalanceException e){//if a balance exception is thrown catch it and output, start over
			  System.out.println("Excetion thrown " + e);
		  }catch(InvalidNameException e){ //if a name exception is thrown catch it and output, start over
			  System.out.println("Exception thrown "+ e);
		  }
		  System.out.println("Enter person info or q to quit.\n Please enter the name of this person:");
		  userInput = sc.nextLine();  //get input for next person
	  }
	  
	     for(Person p : people){  //output all account holder information
	    	 System.out.printf("%s \n", p.toString()); //call each persons toString method
	     }
	  sc.close();
  }
  
   /**
    * checks to see if the age is valid (an integer over 0 and under 150)
    * @param age String to be the age checked
    * @throws InvalidAgeException exception to be caught in main
    */
   public static void isValidAge(String age) throws InvalidAgeException{
	  try{
	   int num =Integer.parseInt(age);  //NumberFormat exception will be thrown here if age has letters or symbols
	   if(num<=0 || num>=150){   
		   //throw exception if the age is over 150 or under 0
		  throw new InvalidAgeException(String.format("%s", num>=150 ? "Age can not be equal to or more than 150" : "Age cannot be less than or equal to 0"));	  
		  }
	  }catch(NumberFormatException e){  
		  char[] chars = age.toCharArray();
		  throw new InvalidAgeException(String.format("%s", chars == null ? "You did not enter an age" : "You did not enter an integer" ));
	  }
	   
   }
   /**
    * checks to see if the balance is a double 
    * 
    * @param balance String to be the balance checked
    * @throws InvalidBalanceException exception to be thrown in main
    */
   public static void isBalance(String balance) throws InvalidBalanceException{
	   try{
		   Double.parseDouble(balance);
	   }catch(NumberFormatException e){  //throw the exception if the parseDouble threw the exception
		   throw new InvalidBalanceException("You did not enter a double."); 
	   }
   }
   
   /**
    * Checks to see if name passed in has anything other than letters and spaces
    * @param name  String to be checked for name
    * @throws InvalidNameException exception to be thrown
    */
   public static void isName(String name) throws InvalidNameException{
	     if(name.equals("")){
	    	 throw new InvalidNameException(String.format("%s","You did not enter a name."));
	     }
	     char[]tempName = name.toCharArray();  //convert the input into a char array
	      for(char c : tempName){    //check each character to make sure it is only letters and spaces
	    	  if(Character.isLetter(c) || Character.isWhitespace(c) ){
	    		continue;
	    	  }else{  //if it is not then throw the exception
	    		  throw new InvalidNameException(String.format("%s", "You have entered an invalid name"));
	    	  }
	      }
      }
}
