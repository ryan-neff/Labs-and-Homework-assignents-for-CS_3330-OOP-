/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * Lab 3
 * Code: Nope Grubs
 */
package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeroFileReader {
  //declare instance variables
	private String filePath;
  /**
   * Constructor for the class
   * call the setter
   * @param filePath to be set
   */
  public HeroFileReader(String filePath){
	     setFilePath(filePath); //set the value for filePath
  }
  
  /**
   * sets the filePath instance
   * @param String to become the filePath
   */
  private void setFilePath(String filePath){
	  this.filePath = filePath; //assign the string to the instance 
  }
  /**
   * Retrieves the filePath from the instance
   * @return the filePath value
   */
  public String getFilePath(){
	  return this.filePath;
  }
  
  /**
   * Scans a file of heros and chacks if there is a valid hero entry
   * If so, a hero is created and added to an array of heroes
   * @return the array of heroes
   */
  public Hero[] getHeroes(){
	  Hero[] heroes = new Hero[5];  //create empty array
	  File file = new File(getFilePath()); //retrieve the file 
	  int i = 0; //make counter
	  
	  try {
		Scanner sc = new Scanner(file);     //make a scanner for the file
		while(sc.hasNextLine() && i < heroes.length){  //scan the file  as long as there is a line and the counter is not out of bounds
		   String line = sc.nextLine();
		   String[] tempArr = line.split(","); //parse the line's pieces by ','
		   if(tempArr[0].length()!=0){  //if the the first entry is not empty (implying a valid hero entry 
			heroes[i] = new Hero(tempArr[0], tempArr[1], Integer.parseInt(tempArr[2])); //add the hero to the array  
		    i++;
		   }
		}
		sc.close(); //close the file
	  } 
	  catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	  return heroes;  //return the array
  }
}
