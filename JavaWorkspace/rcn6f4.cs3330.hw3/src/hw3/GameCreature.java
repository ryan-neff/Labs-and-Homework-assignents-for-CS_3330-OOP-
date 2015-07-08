/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * HW 3
 */
package hw3;

import java.util.ArrayList;

public abstract class GameCreature implements Creature{
  private String name;
  protected Bag bag;
  protected Health health;
  private CommandProcessor commandProcessor;
	 public GameCreature(String name, int hp, Bag emptyBag){
		  setName(name);
		  initBag(emptyBag);
		  initCommandProcessor();
		  createHealth(hp);
	 }
	/* * Sets the name attribute for the object
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
	    this.bag.addItem(new Weapon("Crowbar","Standard",30,5));
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
	 * Injures current objects health by a given item
	 * @param item to injure the object
	 * @return true if hit was successful, false if not
	 */
	public boolean injured(Item item){
		if(!item.equals(null)){                //if the item is not null
			if(this instanceof Human){
			this.health.hit(((Weapon)item).getPoints());  //hit the objects health
			return true;             
			}else{
				this.health.hit(((Weapon)item).getPoints()*2);  //hit the objects health
				return true;
			}
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
	 * Retrieves the current health points of the given object
	 * @return the objects health points
	 */
	public int currentHealthPoints(){
		return this.health.getHealthPoints();
	}
	
	/**
	 * Takes a given command, parses, validates, and returns a specific Human response depending on certain criteria 
	 * @param User input commands
	 * @param beast to be utilized
	 * @param item to be utilized
	 * @return a certain response and true or false
	 */
	public CreatureResponse processCommand(String commands, GameCreature creature, Item item){
		   
		   String response="";               //create a string variable
		   boolean result, validAction = true;     //set boolean variables to true
		   String[] splitCommands = commands.split(" ");       //split the user input command by a " " delimiter
		   
		   if(commandProcessor.validateUserCommand(splitCommands[0]) == false){   //if the first word is not a command
			   return new CreatureResponse("Invalid Game Command", false);          //return with a human response and a validAction value of false
		   }
		   
		   switch(splitCommands[0].toLowerCase()){                                           //otherwise switch on the command given by the user
		   
		   case "attack":             //if the command is attack
			   
			   //if the commands are > 5, the 3rd word is "with" and the beast is living .. 
			   if(splitCommands.length >= 2  && splitCommands[1].equalsIgnoreCase("with")  && creature.isLiving() && this.bag.getItem(splitCommands[2]) instanceof Weapon){
				  result = attack(creature, this.bag.getItem((splitCommands[2]))); //..attack the beast with the given item (result will be  true if the result is successful)
			    if( result == false ){                  //if the result is false..
				   response = "Not a valid weapon";    //..set response and set validAction to false
				   validAction = false;
				}
			   
			    break;
			   }
			   
			   break;
		  
		   case "pickup":   //if command is pickup
			     if(this.pickup(item)){        //if the item was added successfully.. 
			       response = "Item added successfully";  //set the response
			       
			     }else{                               //..otherwise
			    	 response = "Item was not Added"; //set the response and set validAction to false
			    	 validAction = false;
			     }
			     break;
		   
		   case "drop":  //if the command is drop
			   //if the command length is >=2 and dropItem returns true 
			      if(splitCommands.length == 3 && bag.dropItem(bag.getItem(Integer.parseInt(splitCommands[2])-1))){
			      response = "Item was dropped successfully"; 
		          }else if(splitCommands.length >=2 && bag.dropItem(bag.getItem(splitCommands[1]))){
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
			    
		   case "heal" :    //if the command is heal 
			   //heal the object and remove the item from the bag if the input is valid
			   if(splitCommands.length >= 2  && splitCommands[1].equalsIgnoreCase("with")  && bag.getItem(splitCommands[2]) instanceof Healer) {  
				  if(this.heal(bag.getItem(splitCommands[2])) && bag.dropItem(bag.getItem(splitCommands[2]))){
			      response = "Item successfully used for healing";
			      
			   }
			   }else{
				  validAction = false;
				  response= "Item was not successfully used for healing";
			   }
			  
			     break;
		   
		   case "runaway":  //if the command is to runaway
			       ((Human)this).dropAll();  //drop all the items
			       response = "fled and dropped all items";
			         
		        break;
		     }
		   return new CreatureResponse(response, validAction);  //return with the specific response and validAction values
		}
}
