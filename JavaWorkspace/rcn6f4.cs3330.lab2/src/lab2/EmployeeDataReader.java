package lab2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class EmployeeDataReader {
	String filePath;

	/**
	 * Constructor for the EmployeeDataReader class
	 * @param filePath
	 */
	public EmployeeDataReader(String filePath) {
		setFilePath(filePath);
	}

	/**
	 * assigns the file path to the class 
	 * @param filePath
	 */
	private void setFilePath(String filePath) {
		this.filePath = filePath;
	}
    
	/**
	 * retrieves the file path
	 * @return file path
	 */
	private String getFilePath() {
		return this.filePath;
	}

	/**
	 * retrieves the file and loads all of the 
	 * data into an employee array
	 * @return filled employee array
	 */
	public Employee[] getEmployeeData() {
		File file = new File(getFilePath());  //retrieve file
        Employee[] employees = new Employee[10]; //create empty employee array
		int i = 0;
        try{
			Scanner sc = new Scanner(file); //create scanner for file
			
			while(sc.hasNextLine() && i<10){ //loop through file..
				String line = sc.nextLine(); //..take line..
				String[] data = line.split(","); //..fill temp array with separate pieces of data separated by commas..
		        employees[i] = new Employee(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2])); //.. finally create an employee within the array with the data		
			    i++;
			}
			sc.close(); //close scanner
	   }
        catch(FileNotFoundException e){
       	 e.printStackTrace();
       }
     return employees;   
	}
}
