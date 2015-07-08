/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Homework 1
 */
package hw1;



import java.util.Random;
import java.util.Scanner;

public class Scavenger {
	
	private static Scanner userInput;
	private static Item[] playerItems;
	private static Item[] gameItems;
	private static Command[] gameCommands;
	private static int currentPlayerItemsIdx;

	public static void main(String[] args) {
		initGameDataAndArrays();
		System.out.print("Enter a name: ");
		String name = userInput.nextLine();
		
		System.out.println("Welcome to the Scavenger Game "  + name );
		System.out.println("");
		
		while( currentPlayerItemsIdx < playerItems.length) {
			Item foundItem = scavengeArea();
			System.out.println("Item found: " + foundItem.getName());
			String[] splitStrings = null;
			do {
				System.out.print("Command: ");
				String input = userInput.nextLine();
				splitStrings = input.split(" ");
				while (!validCommand(splitStrings)) {
					System.out.print("Invalid Try Again, Command: ");
					input = userInput.nextLine();
					splitStrings = input.split(" ");
				}	
			}while (!runCommand(splitStrings[0],foundItem));
		}
		
		displayPlayerItems();
		PlayerItemStats();
	}
	
  /**
   * Creates the instances for the Item, Command, and GameDataReader class
   * creates an empty Item array for player
   * creates an array for commands
   * creates an array filled with the game items
   */
	public static void initGameDataAndArrays(){
	  
	  userInput = new Scanner(System.in);  //create scanner for the user input
	 
	  playerItems = new Item[10]; //declare array
	  for (int j = 0; j < playerItems.length; j++) {
		  playerItems[j]= new Item("",0,0);  //instantiate the array with empty items
	 }
	  
	  GameDataReader gameDataReader = new GameDataReader(); // create a new data reader
	  gameItems = gameDataReader.getGameItems(); //fill the  gameItems array with the data read
	  
	  currentPlayerItemsIdx = 0; //set player item index to 0
	  
	  gameCommands = new Command[5];       //create command array and fill array (lines 68 - 72)
	  gameCommands[0] = new Command("help");
	  gameCommands[1] = new Command("pickup");
	  gameCommands[2] = new Command("drop");
	  gameCommands[3] = new Command("view");
	  gameCommands[4] = new Command("quit");
	  
  }
	
/**
 *  Randomly loops to give that nice searching feeling
 *  	
 * @return A random Game Item
 */
  private static Item scavengeArea(){
	  Random randomGenerator = new Random();  //create the random generator
	  
	  for(int i = 0; i< randomGenerator.nextInt(5); i++){    //loop anywhere from 0 - 4 times 
		  System.out.println("Scavanging Area For An Item..."); //Alert the user that he is indeed scavanging
		   }
	  
	  return gameItems[randomGenerator.nextInt(gameItems.length)]; //return the item at the index given at random
	  
  }
  
  /**
   * Run a specific task given the specific command given by the user
   * @param the command given by the user
   * @param the item the user has discovered
   * @return true or false based on the command given
   */
  public static boolean runCommand(String commandName, Item item){
	     switch(commandName){ 
	     	case "pickup":  //if command is pickup
	     		    addItemToPlayerItems(item);   //add the item 
	     		    System.out.println("Item Successfully Added"); //alert user of successful pickup
	     		    return true; //true return to notify main loop to break
	     	case "drop":    //if command is drop
	     		     System.out.println("Item Successfully Dropped"); //alert user of successful drop
	     		     return true; //true return to notify main loop to break
	     	case "view":   //if command is view
	     		     displayPlayerItems(); //display items to user
	     		     return false; //false return to stay in the loop in main
	     	case "help":    //if command is help
	     		     displayGameCommands(); //display commands to user
	     		     return false; //false return to stay in loop in main
	     	case "quit":  //if command is quit
	     		     System.out.println("Game Terminated."); 
	     		     System.exit(0); //terminate program
	         }
       return false; 
  }
  
  /**
   * Loops through the playerItems array printing the value and name 
   * of every item picked up
   */
  public static void displayPlayerItems(){
	  if(currentPlayerItemsIdx == 0){ 		//if the index is zero
		   System.out.println("Bag Is Empty."); //alert player that there is nothing in the array (Bag)
	  }
	  else{
		  for(Item item : playerItems){   //for every item.. 
			  if(item.getName() == ""){  //.. "" name infers that there are no more items left in bag..
				   break;               //..so break the loop..
			  }
		   System.out.println(item.getName() + " "+ item.getValue()); //..or print the name and value of the item
	      }
	  }
 }
  
  /**
   * Output all commands to user 
   */
  public static void displayGameCommands(){
	  for(Command command : gameCommands){  //for every command
		  System.out.println(command.getCommandName()); //print the command's name to user
	  }
	}
  
  /**
   * Checks if the passed string is a valid command
   * @param array of strings passed by main
   * @return true if true and false if false
   */
  public static boolean validCommand(String[] splitStrings){
	    for(Command command: gameCommands){                      //loop through all commands
	    	 if(splitStrings[0].equals(command.getCommandName())){  //return true if the string matches a command name at any point
	    		 return true;
	    	 }
	    }
        return false;   //return false if no match was found
  }
  /**
   * Add a passed item to the playerItems array as long
   * as the index counter is within bounds of the playerItems array
   * @param the item "found" by the user
   * @return true if the item was successfully added / false if the index has gone out of bounds
   */
  public static boolean addItemToPlayerItems(Item item){
	  if(currentPlayerItemsIdx >=playerItems.length){  //return false if the index is out of bounds 
		  return false;
	  }
	  else{
		  playerItems[currentPlayerItemsIdx]= item; //add item at the index
		  currentPlayerItemsIdx++; //increment index
		  return true; 
	  }
  }
  
  /**
   * Calculates and prints out to the user the total weight, max weight,
   * min weight, and total value, of all of the items in the playerItems array
   */
  public static void PlayerItemStats(){
	  int totalWeight = 0;  //declare all variable
	  int minWeight = 200;
	  int maxWeight = 0;
	  int totalValue = 0;
	  
	  for(Item item: playerItems){  //loop through all items in the array
		   totalValue+= item.getValue();  //add all values to each other
		   totalWeight+= item.getWeight(); //add all weights to each other
		   if(item.getWeight() < minWeight){  //if the given item's weight is less than the min weight
			   minWeight = item.getWeight();  //make it the new minimum weight
			   }else if(item.getWeight() > maxWeight){  //if the given item's weight is more than the max weight
				   maxWeight = item.getWeight();  //make it the new maximum weight
				   }
		   }
	  //print out all data to the user
	  System.out.printf("Player Stats: \n Total Weight: %d \n Min Weight: %d \n Max Weight: %d \n Total Value: %d \n", totalWeight,minWeight,maxWeight,totalValue);
  }

}
