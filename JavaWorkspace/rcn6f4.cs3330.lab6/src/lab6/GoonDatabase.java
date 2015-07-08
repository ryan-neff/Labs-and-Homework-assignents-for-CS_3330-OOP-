/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GoonDatabase {
	//declare a database attribute
   private ArrayList<Goon> goonDB;
	 
  /**
   * Constructor for the class, calls the file importer 
   * @param file String to become the file
   */
  public GoonDatabase(String filePath){
		  importFile(filePath);
		  
	 }
	 
  /**
   * Takes a file path and creates a file to be scanned into the data base according 
   * to the type of entry it is in the file
   * @param input  String to be used as the file path
   */
	 protected void importFile(String input){
	  File file = new File(input);       //create new file from file path
      goonDB = new ArrayList<Goon>();    //create an empty instance for the database
      
      try{
		   Scanner sc = new Scanner(file);                //create scanner for the file
		   while(sc.hasNextLine()){                      //while the file has a next line
		   String line = sc.nextLine();                 //create a string of the line
          String[] goon = line.split(",");             //split the line into an array of values
		  
          /*
           * switch off of the first value (the type of Goon)       *
           * add new instance of the specific type to the data base *
           * using the rest of the entries in the array as the      *
           * parameters for the object's constructor                *
           */
          switch(goon[0]){                            
          case "Don" : 
        	   goonDB.add(new Don(goon[1], goon[3], goon[2], Integer.parseInt(goon[4]))); 
          break;
          case "Talent":
        	  goonDB.add(new Talent(goon[1],goon[2],goon[3]));
          break;
          case "Overseer":
        	  goonDB.add(new Overseer(goon[1],goon[2],goon[3]));
          break;
          
          }
          
	  }
		   
		 sc.close();
	   }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
      
	 }
	 
	 /**
	  * Asks user to input a query to search the data base			  *
	  * As long as the input is valid, an ArrayList of Goon object(s) *
	  * tailored to the query is returned						      *		
	  * the script terminates if the user inputs a 'q'                *
	  */
	 public void searchMenu(){
		 Scanner userInput = new Scanner(System.in);  //create scanner
		 System.out.println("Please enter your query (q to exit): ");  
		 String input = userInput.nextLine();          
		 
		 while(!(input.equals("q"))){             //loop as long as input is not "q"
		ArrayList<Goon> result = searchDataBase(input);   //get the resulting goon array list using the query
		
		if(result.isEmpty()){                           //if nothing was returned
			System.out.println("No results found...");  //alert the user
		}else{
		
		System.out.println("Results:");               
		 for(int i = 0; i< result.size(); i++){      //..otherwise organize the output for each Object in the array list..
		     System.out.println(i+1 +" - " + result.get(i).getName());	//..and print each object's name 
		 }
		}
		 System.out.println("Please enter your query (q to exit): ");  //don't want to loop forever 
		 input = userInput.nextLine();                                //no sir
	   } 
         
		 userInput.close();
	 }
	 
	 /**
	  *  Searches the data base with a given input from the user *
	  * @param input to be searched for							 *
	  * @return a populated array list tailored toward the input *
	  */
	 protected ArrayList<Goon> searchDataBase(String input){
		 
		 ArrayList<Goon> goons = new ArrayList<Goon>(); //create empty array list to be returned
		 for(Goon goon : goonDB){                       //for every object in the list
			  										
			 											  //add the object if...
			 if(goon.getName().equalsIgnoreCase(input)){  //the name is the same is the input 
				 goons.add(goon); 
			 }else if(input.equalsIgnoreCase("don") && goon instanceof Don){  //..or the input is the same as the type
				 goons.add(goon);										      //of the object (refers to each else if statement)
			 }else if(input.equalsIgnoreCase("talent") && goon instanceof Talent){
				 goons.add(goon);
			 }else if(input.equalsIgnoreCase("overseer") && goon instanceof Overseer){
				 goons.add(goon);
			 }else if(input.equalsIgnoreCase("goon") && goon instanceof Goon){
				 goons.add(goon);
			 }
			
		 }	 
	  return goons; //return the array list
	 }
}
