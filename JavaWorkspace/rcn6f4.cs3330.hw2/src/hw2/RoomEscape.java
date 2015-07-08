/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 2
 */
package hw2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RoomEscape {
	/**
     * Please explain the game process, so we know, you know how this game works
     *
     */
	//instantiate instance variables
	private static Scanner userInput;
	private static ArrayList<Item> gameItems;
	private static ArrayList<Beast> gameBeasts;
	private static ArrayList<Beast> currentRoomBeasts;
	private static Human currentPlayer;
	private static Random randomGenerator;
	
	
    public static void main(String[] args) {
            
            initGameData();
            System.out.print("Enter Character Name: ");
            String name = userInput.nextLine();
            System.out.print("Enter number of levels: ");
            int maxRooms = Integer.parseInt(userInput.nextLine());
            
            currentPlayer = new Human(name,100, new Bag());
            int roomsBeat = 0;
            
            while (roomsBeat < maxRooms) {
                    /*
                     * Create room bad guys and items
                     */
                    System.out.println("Entering Room " + (roomsBeat + 1));
                    System.out.println(" ");
                    initCurrentRoomBeasts();
                    int creaturesDestroyed = 0;
                    
                    while (currentPlayer.isLiving() && creaturesDestroyed < 2) {     //while the player  is alive and two beats were not killed
                            int encounterProb = randomGenerator.nextInt(100);  
                            Item foundItem = null;                  
                            Beast foundEnemy = null;
                            /*
                             * 60 percent chance of being a Beast.
                             */
                            if (encounterProb <= 40) {
                                    foundItem = findItem();                  //get a random item
                                    System.out.println("You have discovered the item " + foundItem.getName()); //alert user
                                    while (noBattle(foundItem));     //no battle happens   
                                    
                            }
                            else {
                                    foundEnemy = findEnemy();        //get random beast
                                    System.out.println("You have encountered a(n) " + foundEnemy.getName()); //alert user
                                    if (battle (foundEnemy)) {      //have battle
                                            creaturesDestroyed++;   //increment creatures destroyed
                                    }
                                    else {
                                            System.out.println("You are dead!");  //or you are dead
                                            return;
                                    }
                            }
                    }
                    roomsBeat++;
            }
            System.out.println("You have beat RoomEscape!");
    }
    
   
    /**
     * Allows the current player to engage in combat with the incoming beast. The player uses 
     * items from his bag to kill the enemy. 
     * 
     * @param battlingBeast The found beast the player has encountered
     * @return Whether the currentPlayer is dead being false or alive being true.
     */
    private static boolean battle (Beast battlingBeast) {
            
            while (currentPlayer.isLiving()) {
                    displayBagContents();
                    String attackString = "attack " + battlingBeast.getName() + " with ";
                    System.out.print(attackString);
                    String input = userInput.nextLine();
                    System.out.println(" ");
                    
                    attackString += input;
                    HumanResponse response = currentPlayer.processCommand(attackString, battlingBeast,null);
                    if (!response.getValidAction()) {
                            System.out.println(response.getResponse());
                    }
                    if (currentPlayer.isLiving() && !battlingBeast.isLiving()) {
                            System.out.println(battlingBeast.getName() + " is killed");
                            System.out.println(" ");
                            return true;
                    }
                    else {
                            System.out.println(battlingBeast.getName() + " HP: " + battlingBeast.getHealth());
                    }
            }
            return false;
    }


    /**
     * Displays the contents of the bag to player
     *
     */
    private static void displayBagContents () {
            System.out.println("Contents of Bag:");
            System.out.println("Name      HitPoints    Weight");
            Bag playerBag = currentPlayer.getBag();
            for (Item i : playerBag.getItems()) {
                    System.out.printf("%-10s%6d%10d\n", i.getName(),i.getValue(),i.getWeight());
            }
            System.out.println(" ");
    }
    
    /**
     * Allows the player to run the following game commands "pickup" on the found item, view the player bag contents,
     * "drop" an item from their bag, show the game commands using "help", "ignore" current item, and "quit" the game.
     *  
     * 
     * @param foundItem An instantiated Item that the player has found
     */
    
    private static boolean noBattle (Item foundItem) {
            displayBagContents();
            System.out.print("Command: ");
            String input = userInput.nextLine();
            if (input.isEmpty()) {
                    return false;
            }
            HumanResponse response = currentPlayer.processCommand(input, null,foundItem);
            while (!response.getValidAction()) {
                    System.out.print(response.getResponse() + ", Try Again: ");
                    input = userInput.nextLine();
                    response = currentPlayer.processCommand(input, null,foundItem);                
                    if (input.isEmpty()) {
                            return false;
                    }
            }        
            System.out.println(response.getResponse());
            return true;
    
    }
    /**
     * Instantiates all instance variables
     */
    private static void initGameData(){
    	userInput = new Scanner(System.in);   //creates Scanner for input
    	randomGenerator = new Random(1337);      //create psuedoRandom generator
    	GameDataReader gameData = new GameDataReader();        //create a gameDataReader object
    	gameItems = gameData.getGameItems("GameData/GameItems.csv");    //get an array list of game Items
    	gameBeasts = gameData.getGameBeasts("GameData/GameBeasts.csv");  //get an array list of game Beasts
       }
    
     
    /**
     * creates a beast array list for the current beasts in the current room
     */
    private static void initCurrentRoomBeasts(){
    	 currentRoomBeasts = new ArrayList<Beast>();  //create an empty array lists of type Beast
    	 
    	 for(Beast beast : gameBeasts){   //for each beast in the original best array list
    		 currentRoomBeasts.add(new Beast(beast.getName(),beast.getHealth())); //copy each beast into the new array list
    	 }
     }
    
    /**
     * Loops a random amount of times to give that nice scavanging feel
     * retrieves an item at a random index 
     * @return the item at the random index
     */
    private static Item findItem(){
    	int itemIdx = randomGenerator.nextInt(gameItems.size());  //get random item
    	int moveIterations = randomGenerator.nextInt(3) + 1;      //get random iterator
    	
    	for(int i = 0; i< moveIterations; i++){    //loop the random amount of times 
  		  System.out.println("Scavanging Area..."); //Alert the user that he is indeed scavanging
  		   }
    	return gameItems.get(itemIdx);  //return the item
    }
    
    /**
     * Loops a random amount of times to give that nice scavanging feel
     * retrieves a beast at a random index 
     * @return the beast at the random index
     */
    private static Beast findEnemy(){
    	int itemIdx = randomGenerator.nextInt(currentRoomBeasts.size()); //get random beast
    	int moveIterations = randomGenerator.nextInt(3) + 1;            //get random iterator
    	
    	for(int i = 0; i< moveIterations; i++){          //loop the random amount of times 
    		  System.out.println("Scavanging Area..."); //Alert the user that he is indeed scavanging
    		   }
      	return currentRoomBeasts.get(itemIdx);    //return the beast
    }
    
  
    
    
}
