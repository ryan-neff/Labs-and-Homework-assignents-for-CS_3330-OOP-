/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Homework 1
 */
package hw1;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameDataReader {
    
	/**
     * Empty constructor for the class
     */
	public GameDataReader(){
		
	}
	
	/**
	 * Reads a given file of to become game items
	 * Fills an array of parsed lines from the file and creates an Item array
	 * from the given data from the file
	 * @return a filled array of items for the game
	 */
	public Item[] getGameItems(){
		File file = new File("GameData/GameItems.csv");  //create a file
		Item[] gameItems = new Item[25];   //initialize an empty item array
		int i = 0;  //counter for array index
		
		try{
			Scanner sc = new Scanner(file); //create scanner for file
			
			while(sc.hasNextLine() && i< 25){  //loop through the scanner for the file
				String line = sc.nextLine(); //..take line..
				String[] data = line.split(","); //..fill a temp array with separate pieces of data separated by commas..
               	gameItems[i] =  new Item(data[0],Integer.parseInt(data[1]), Integer.parseInt(data[2])); //..use the temp array to become the data for a new Item in the gameItems array		
			    i++; //increment
			}
			 sc.close();	
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
     return gameItems;  //return the array of Items
	}
}
