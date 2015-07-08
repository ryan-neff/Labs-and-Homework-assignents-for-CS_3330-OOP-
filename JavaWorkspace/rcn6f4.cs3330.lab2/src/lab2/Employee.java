package lab2;

public class Employee {
	private String name;
	private int age;
	private double salary;

	/**
	 * Employee constructor
	 * Sets all attributes for the instance of the class
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, double salary) {

		setAge(age);
		setName(name);
		setSalary(salary);
	}

	/**
	 * Sets salary to passed value as long as the value is greater than 0
	 * Default: 20000
	 * @param salary
	 */
	private void setSalary(double salary) {
		if (salary > 0) {         //set salary if value is greater than 0
			this.salary = salary;
		} else {
			this.salary = 20000.00;  //set default value if passed value is >1
		}
	}
 
	/**
	 * Sets the name for the instance of the class
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the age for the instance as long
	 * as 150<age<17 
	 * Default: 17
	 * @param age
	 */
	private void setAge(int age) {
		if (age < 150 && age >= 17) {
			this.age = age; //set age to passed value if 150<age<17
		} else {
			this.age = 17; //set default if !(150<age<17)
		}
	}

	/**
	 * gets the name of the given instance
	 * @return name value of that instance 
	 */
	public String getName() {
		return this.name;
	}
    /**
     * gets the age of the given instance
     * @return age value of that instance
     */
	public int getAge() {
		return this.age;
	}
    /**
     * gets the salary of the given instance
     * @return salary of that given instance
     */
	public double getSalary() {
		return this.salary;
	}

}
