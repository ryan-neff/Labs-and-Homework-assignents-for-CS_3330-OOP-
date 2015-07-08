/**
 * Name: Ryan Neff
 * PawPrint: rcn6f4
 * Date: 9/17/14
 * Lab 2
 */

package lab2;

public class Lab2Driver {

	public static void main(String[] args) {
		EmployeeDataReader employeeDataReader = new EmployeeDataReader(
				"EmployeeData/EmployeeData.csv");
		Employee[] employeeDatabase = employeeDataReader.getEmployeeData();
		displayEmployees(employeeDatabase);
		System.out.println("");
		Employee highestPaid = findHighestPaidEmployee(employeeDatabase);

		System.out.println("Highest Paid Employee is " + highestPaid.getName()
				+ " at " + highestPaid.getSalary());
		System.out.println("Total Cost of All Employees is "
				+ totalCostOfAllEmployees(employeeDatabase));
	}
	
	
   /**
    * Prints all of the employee data in the employee database
    * @param employeeDatabase
    */
	public static void displayEmployees(Employee[] employeeDatabase) {
       for(Employee employee : employeeDatabase){   						//loop through array
    	    System.out.println(employee.getName()+" "+ employee.getAge());  //print the name and age
       }
	}
   
	/**
	 * Finds the employee with the highest salary
	 * @param employeeDatabase
	 * @return the highest paid employee
	 */
	public static Employee findHighestPaidEmployee(Employee[] employeeDatabase) {    
		Employee highestPaidEmpl = employeeDatabase[0]; //start with the first employee in the array
		for (int i = 1; i< employeeDatabase.length; i++){  //loop through the rest of the array..
			 if(employeeDatabase[i].getSalary() > highestPaidEmpl.getSalary() ){  //.. and compare salaries
				 highestPaidEmpl = employeeDatabase[i];                   //the employee with the higher salary is stored in the highestPaidEmpl variable
			 }
            	 
            }
	   return highestPaidEmpl;
	}

	
	/**
	 * Adds up all of the salaries producing the total cost 
	 * @param employeeDatabase
	 * @return total cost
	 */
	public static double totalCostOfAllEmployees(Employee[] employeeDatabase) {
        double totalStacks = 0.0; //create counter starting at 0.0
         for(Employee employee : employeeDatabase){ //loop through database
        	 totalStacks+= employee.getSalary(); //add each salary to counter
         }
        
         return totalStacks;
	}

}
