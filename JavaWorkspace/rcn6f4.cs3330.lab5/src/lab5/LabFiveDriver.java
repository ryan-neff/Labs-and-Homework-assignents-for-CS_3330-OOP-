/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Lab 5
 * Sub Code: Matt Was Late
 * 
 */
package lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class LabFiveDriver {
	//declare Scanner and ArrayList of shapes to use throughout the class
	 private static ArrayList<Shape> shapes;
	 private static Scanner userInput;
	 
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("Enter number of shapes to create: ");
		int size = Integer.parseInt(userInput.nextLine());
		initShapes(size);
		displayShapes();
		System.out.print("Enter a shape color to remove:");
		String shapeColor = userInput.nextLine();
		removeShape(shapeColor);
		displayShapes();
		userInput.close();
	}
	
	/**
	 * Loops through a specified number of times asking a user for the shape and its parameters 
	 * which is then error checked. If the input is valid the shape is added to the list of Shapes 
	 * @param number to of shapes to add
	 */
	public static void initShapes(int numberOfShapes){
		
		shapes = new ArrayList<Shape>(); //instantiate the array list
		for(int i = 0; i < numberOfShapes; i++){      //iterate for as many shapes that need to be added 
			int flag = 0;                             // set a flag to 0 and change it if input is valid
			while(flag == 0){                         //keep looping if the flag has not been tripped
			System.out.println("Enter a Shape: ");   
			String input = userInput.nextLine();      //scan the line..
			String[]inputArr = input.split(" ");      //..split the line by spaces
			switch(inputArr[0]){                      //assume the first index will be the name of the shape and switch off that value
			
			/**
			 * If the name matches the case and the length of the input array without the 
			 * first index (the name) matches the amount of parameters for the case, then instantiate the new Shape, 
			 * add it to the "shapes" list, trip the flag, and break the switch
			 * If not then do not trip the flag, and break the switch
			 */
			case "circle" :         
				 if(inputArr.length == 3){
					 shapes.add(new Circle(Double.parseDouble(inputArr[1]),inputArr[2]));	//instantiate and add to the list 
				 }
				 else{
					 System.out.println("Invalid Shape, Try Again!");
					 flag = 0;
					 break;
				 }
				 
				 flag = 1;
				 break;
			
			case "ellipse":
				 if(inputArr.length == 4){
				   shapes.add(new Ellipse(Double.parseDouble(inputArr[1]),Double.parseDouble(inputArr[2]),inputArr[3])); //instantiate and add to the list
				   flag = 1;
				 }
				 else{
					 System.out.println("Invalid Shape, Try Again!"); 
					 flag = 0;
				      break;
				      }
				 flag = 1;
				 break;
			
			case "rectangle":
				 if(inputArr.length == 4){
					   shapes.add(new Rectangle(Double.parseDouble(inputArr[1]),Double.parseDouble(inputArr[2]),inputArr[3])); //instantiate and add to the list
					 }
				 else{
					 System.out.println("Invalid Shape, Try Again!");
					 flag = 0;
					 break;
				 }
				 flag = 1;
				 break;
				 
			case "square" :
				 if(inputArr.length == 3){
					 shapes.add(new Square(Double.parseDouble(inputArr[1]),inputArr[2]));	//instantiate and add to the list 
				 }
				 else{
					 System.out.println("Invalid Shape, Try Again!");
					 flag = 0;
					 break;
				 }
				 flag = 1;
				 break;
			
			default:
				System.out.println("Invalid Shape, Try Again!");
				flag = 0;
				break;
			}
	     }	
	   }
	 }
	
	/**
	 * Calls every Instances toString method and prints it to the console
	 */
	public static void displayShapes(){
		for(Shape shape : shapes){   //for every shape
			System.out.printf("%s  \n", shape.toString()); //call the toString method and print
		}
	}
	
	/**
	 * Removes the first shape with the occurrence of a specified color
	 * @param the color to search for within the list
	 */
	public static void removeShape(String shapeColor){
		
		for(Shape shape : shapes){          //for each shape
			if(shape.getColor().equals(shapeColor)){  //if the shape's color equals the specific color 
			shapes.remove(shapes.indexOf(shape));  //remove that instance from the list
			 break;                                //break so no more instances are deleted
			}
		}
		
	}
}
