/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 2
 */
package hw2;

import java.util.ArrayList;

public class Human {
	//Create all attributes
	private String name;
	private Bag bag;
	private Health health;
	private CommandProcessor commandProcessor;
	
	/**
	 * Constructor for the Human class
	 * calls all setters for the attributes
	 * @param String to be the name
	 * @param int to be the health
	 * @param Bag item to be the Bag attribute
	 */
	public Human(String name, int hp, Bag emptyBag){
        setName(name);
        createHealth(hp);
        initBag(emptyBag);
        initCommandProcessor();
        
	}
	
	/**
	 * Sets the name attribute for the object
	 * @param String to be the name
	 */
	private void setName(String name) {
        this.name = name;		
	}
	
	/**
	 * Instantiates a new command processor object for the commandProcessor attribute of the object
	 */
	private void initCommandProcessor(){
		this.commandProcessor = new CommandProcessor();
	}
	
	/**
	 * Sets the bag attribute for the object
	 * instantiates an empty bag
	 * inserts a crowbar item to the bag
	 * @param Bag item to be the bag attribute
	 */
	private void initBag(Bag emptyBag){
	    this.bag = emptyBag;
	    this.bag.addItem(new Item("Crowbar",30,5));
	}
	
	/**
	 * Instantiates a new health object for the health attribute of the object
	 * @param int to be the health for the object
	 */
	private void createHealth(int hp){
		this.health = new Health(hp);
	}
	
	/**
	 * Retrieves the name of the object
	 * @return the name of the object
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Retrieves the bag object of the object
	 * @return the bag of the object
	 */ 
    public Bag getBag(){
		return this.bag;
	}
    
    /**
	 * Retrieves the health attribute of the object
	 * @return the health attribute of the object
	 */
    public Health getHealth(){
    	return this.health;
    }
	
    /**
     * Adds an item to the bag attribute 
     * @param item to add to the bag
     * @return true if the item was added, false if unsuccessful
     */
    public boolean pickup(Item item){
		return this.bag.addItem(item); //the result of addItem
		
	}
	
    /**
     * Drops a given item in the bag attribute
     * @param item to be removed
     * @return true if removed, false if unsuccessful
     */
	public boolean drop(Item item){
		return this.bag.dropItem(item); //return the resul of dropItem
		
	}
	
	/**
	 * Attacks a given Beast with a given Item
	 * @param beast to be injured
	 * @param item to injure the beast
	 * @return true if attack was successful, false if not
	 */
	public boolean attack(Beast beast, Item item){
		return beast.injured(item);		//return result of injured
	}
	
	/**
	 * Injures current objects health by a given item
	 * @param item to injure the object
	 * @return true if hit was successful, false if not
	 */
	public boolean injured(Item item){
		if(!item.equals(null)){                //if the item is not null
			this.health.hit(item.getValue());  //hit the objects health
			return true;             
		}
	       return false;
	 }
	
	/**
	  * Checks if the human object is down for the count 
	  * @return true if the human's health points are not zero, false if dead 
	  */
	public boolean isLiving(){
		return this.health.getAlive();
	}
	
	/**
	 * Takes a given command, parses, validates, and returns a specific Human response depending on certain criteria 
	 * @param User input commands
	 * @param beast to be utilized
	 * @param item to be utilized
	 * @return a certain response and true or false
	 */
	public HumanResponse processCommand(String commands, Beast beast, Item item){
	   String response="";               //create a string variable
	   boolean result, validAction = true;     //set boolean variables to true
	   String[] splitCommands = commands.split(" ");       //split the user input command by a " " delimiter
	   
	   if(commandProcessor.validateUserCommand(splitCommands[0]) == false){   //if the first word is not a command
		   return new HumanResponse("Invalid Game Command", false);          //return with a human response and a validAction value of false
	   }
	   
	   switch(splitCommands[0]){                                           //otherwise switch on the command given by the user
	   
	   case "attack":             //if the command is attack
		   
		   //if the commands are > 5, the 3rd word is "with" and the beast is living .. 
		   if(splitCommands.length >= 4  && splitCommands[2].equals("with")  && beast.getName().equals(splitCommands[1]) && beast.isLiving()){
			  result = attack(beast, this.bag.getItem((splitCommands[3]))); //..attack the beast with the given item (result will be  true if the result is successful)
		    if( result == false ){                  //if the result is false..
			   response = "Not a valid weapon";    //..set response and set validAction to false
			   validAction = false;
			}
		   
		    break;
		   }
		   
		   break;
	  
	   case "pickup":   //if command is pickup
		     if(pickup(item)){        //if the item was added successfully.. 
		       response = "Item added successfully";  //set the response
		       
		     }else{                               //..otherwise
		    	 response = "Item was not Added"; //set the response and set validAction to false
		    	 validAction = false;
		     }
		     break;
	   
	   case "drop":  //if the command is drop
		   //if the command length is >=2 and dropItem returns true 
		      if(splitCommands.length >=2 && bag.dropItem(bag.getItem(splitCommands[1]))){
		    		response = "Item was dropped successfully";     //set the response
		      } else{
		    	  response = "Item was not dropped successfully";   //otherwise set the response and set validAction to false
		    	  validAction = false;
		      }
		   break;
	   
	   case "help":  //if the command is help
		   String tempString = "";    //create an empty string
		   ArrayList<String> help = new ArrayList<String>();    //create an array list of strings 
		     help = commandProcessor.getGameCommands();        //set the array list to the gameCommands arrayList
		        for(String move : help){        //for every command in the list
		         tempString += String.format("%s \n", move); //concatenate the commands into a string formatted with a new line after every command
		       }
		       response = tempString;       //set the string to the response
		    break;
	      
	     }
	   return new HumanResponse(response, validAction);  //return with the specific response and validAction values
	}


}
