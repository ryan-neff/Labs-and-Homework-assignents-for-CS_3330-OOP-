/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 2
 */
package hw2;

import java.util.ArrayList;

public class CommandProcessor {
   //make an empty array list of strings
	private ArrayList<String> commands;
	
	/**
	 * Constructor for the class
	 * calls the setter for the game commands
	 */
	public CommandProcessor(){
    	setGameCommands();
    }

	/**
	 * sets the game commands for the game
	 * Gets an array list of commands from the GameDataReader
	 */
	private void setGameCommands() {
	   GameDataReader reader = new GameDataReader();                 //Creates a game data reader
	   this.commands = reader.getGameCommand("GameData/Commands.txt");  //the reader returns a list of commands by reading and parsing the passed in file
	 }
	
	/**
	 * retrieves the array list of commands 
	 * @return the array list of commands
	 */
	public ArrayList<String> getGameCommands(){
		return this.commands;
	}
	
	/**
	 * Makes sure the user input for a command is within the list of commands
	 * @param command to be validated
	 * @return true is valid, false if not
	 */
	public boolean validateUserCommand(String command){
		for(String gameCommand : commands){   //for every command in the list
			if(gameCommand.equals(command)){   //..if the users command is found
				return true;                  //..return true
			}
		}
	  return false;
	}
}
