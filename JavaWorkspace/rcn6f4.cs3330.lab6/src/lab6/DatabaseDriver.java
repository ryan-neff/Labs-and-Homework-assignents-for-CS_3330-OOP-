/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

public class DatabaseDriver {
	
/**
 * Main driver method
 * Creates the data base with a given file
 * calls a search on the database
 * @param args
 */
	public static void main(String[] args) {
		GoonDatabase db = new GoonDatabase("Data/Goons.csv"); //create a new GoonDatabase with a given file
		System.out.println("Import Complete"); 
		db.searchMenu();  //call a search on the data base
        System.out.println("Program Complete"); 
	}

}
