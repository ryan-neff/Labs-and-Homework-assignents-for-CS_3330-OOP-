/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * SubCode: FreeCandy
 */
package lab11;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DensityA {

	public static void main(String[] args){
		
		//1. Create the frame.
		JFrame frame = new JFrame();
		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //4. Size the frame.
		frame.pack();
		
		double alt = Double.parseDouble(JOptionPane.showInputDialog(frame,"What is the altitude (in feet) of the airport")); //get altitude from user
		double oat = Double.parseDouble(JOptionPane.showInputDialog(frame,"What is the current outside temperature (in Celcius)")); //get the temperature from user
		double aps = Double.parseDouble(JOptionPane.showInputDialog(frame,"What is the current air pressure at the airport?"));  //get air pressure from user
		double runway = Double.parseDouble(JOptionPane.showInputDialog(frame,"Enter the length of the runway at the airport."));  //get run way length from user
	    double stdDistance = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter the standard takeoff distance (0 elevation) for your aircraft")); //get the standard takeoff distance for the aircraft 
	    
	    double densityAltitude = ((oat-(15-(alt*.002)))*120)+(((29.92 - aps)*1000)+alt); //calculate the density altitude
	    double takeoffDistance = stdDistance + ((densityAltitude/100)*10);   //calculate the distance needed to takeoff
	    
	    String message = String.format("%s%.2f\n%s%.2f","The density altitude is currently ", densityAltitude, "The distance required for takeoff at this density altitude for your plane is ", takeoffDistance);
	    JOptionPane.showMessageDialog(frame,message);  //output the density altitude and required take off distance 
	    
	    //Alert user that they are clear or not clear for 
	    //take off if the run way is too short 
	    if(runway >= takeoffDistance){ 
	    	JOptionPane.showMessageDialog(frame, "CLEARED FOR TAKEOFF","TAKEOFF",JOptionPane.INFORMATION_MESSAGE);
	    }else{
	    	JOptionPane.showMessageDialog(frame, "DO NOT TAKEOFF!!!","TAKEOFF",JOptionPane.WARNING_MESSAGE);
	    }
	    
   }
}
