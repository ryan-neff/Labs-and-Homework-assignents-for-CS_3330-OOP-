/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */
package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameDataReader {
	
/**
 * Parses a file of game commands, puts it in a array list
 * @param file of commands
 * @return array list of commands
 */
	public ArrayList<String> getGameCommand(String filePath){
	   ArrayList<String> commands = new ArrayList<String>();  //create empty array list
	   File file = new File(filePath);                       //create file object
	   try{
		   Scanner sc = new Scanner(file);                //create scanner for the file
		   while(sc.hasNextLine()){                      //while the file has a next line
		   String line = sc.nextLine();                 //create a string of the line
		   commands.add(line);                         //add the string to the array list
		   }
		   
		 sc.close();
	   }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	  return commands;    //return the array list
	}
	
	/**
	 * Parses a file of game Items(Weapon and Healer), puts it in a array list
	 * @param file of Items
	 * @return array list of Items
	 */
	public ArrayList<Item> getGameItems(String filePath){
		ArrayList<Item> items = new ArrayList<Item>();   //create empty array list
		String[] typeNName;
		File file = new File(filePath);                 //create file object
		try{
			Scanner sc = new Scanner(file);             //create scanner for the file
			while(sc.hasNextLine()){                    //while the file has a next line
			String line = sc.nextLine();               //create a string of the line
			String[] inputArr = line.split(",");       //parse the string by the ',' delimiter into an array of strings
			if(inputArr[0].equals("Weapon")){
			      typeNName = inputArr[1].split(" ");
			      items.add(new Weapon(typeNName[1],typeNName[0], Integer.parseInt(inputArr[2]), (Integer.parseInt(inputArr[3]))));     //create a new item with the individual indexes of the array as parameters
			}else{
		         typeNName = inputArr[1].split(" ");	
		         items.add(new Healer(typeNName[1],typeNName[0], Integer.parseInt(inputArr[2]), Integer.parseInt(inputArr[3])));    //create a new item with the individual indexes of the array as parameters   
			}
			}
		sc.close();	
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return items;  //return the array list 
	}
	
	/**
	 * Parses a file of game Beasts, puts it in a array list
	 * parses the Beasts weapon and creates a bag to pass into the beasts constructor
	 * @param file of Beasts
	 * @return array list of Beasts
	 */
	public ArrayList<Beast> getGameBeasts(String filePath){
		ArrayList<Beast> beasts = new ArrayList<Beast>();                //create empty array list
		Bag beastBag = new Bag();
		File file = new File(filePath);                                  //create file object
		try{
			Scanner sc = new Scanner(file);                             //create scanner for the file
			while(sc.hasNextLine()){                                    //while the file has a next line
			String line = sc.nextLine();                               //create a string of the line
			String[] inputArr = line.split(",");                       //parse the string by the ',' delimiter into an array of strings
			String[] typeNName = inputArr[0].split(" ");
			String[] weapon = inputArr[2].split(" ");
			beastBag.addItem(new Weapon(weapon[1],weapon[0],Integer.parseInt(inputArr[3]), Integer.parseInt(inputArr[4])));
			beasts.add(new Beast(typeNName[0],typeNName[1], Integer.parseInt(inputArr[1]), beastBag));  //create a new beasts with the individual indexes of the array as parameters
			}
		 sc.close();	
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return beasts;   //return the array list
	}
	
 }
