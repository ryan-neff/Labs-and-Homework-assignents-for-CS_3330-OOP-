/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Homework 1
 */
package hw1;

public class Command {
   private String commandName;  //declare commandName instance variable
   
   /**
    *Command name constructor calls setCommand name 
    * @param String commandName
    */
   public Command(String commandName){ 
	  setCommandName(commandName); //calls setCommand name to set command name for the given instance   
   }
   
   /**
    * Sets the name for the given instance
    * @param commandName passed by the constructor
    */
   private void setCommandName(String commandName){
	   this.commandName= commandName; //sets the instance variable commandName to the value of the passed String
   }
   
   /**
    * retrieves the command name of the given instance of the class
    * @return the name of the object
    */
   public String getCommandName(){
	   return this.commandName;  //returns the name the object has
	   
   }
	
}
