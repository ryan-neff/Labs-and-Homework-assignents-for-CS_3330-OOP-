/**
 * Name: Ryan Neff
 * PawPrint: rcn6f4
 * Lab 3
 * Code: Nope Grubs
 */
package lab3;

import java.util.Random;

public class LabThreeDriver {
	//Declare instance variables
	private static int heroHits = 0;
	private static int villainHits = 0;

	public static void main(String[] args) {
		HeroFileReader heroFileReader = new HeroFileReader("DataFiles/Heroes.csv");
		Hero[] heroes = heroFileReader.getHeroes();
		LabThreeDriver.displayHeroes(heroes);
		Hero villain = LabThreeDriver.createVillain();
		System.out.println("Villain: " + villain.getName());
		System.out.println("");
		LabThreeDriver.battle(heroes,villain,10);
		LabThreeDriver.displayFightResults();
		LabThreeDriver.heroTraining(heroes);
		LabThreeDriver.heroHits = 0;
		LabThreeDriver.villainHits = 0;
		battle(heroes,villain,10);
		LabThreeDriver.displayFightResults();
	}
   /**
    * Prints all heroes out to user
    * @param array of heroes to print
    */
	public static void displayHeroes(Hero[] heroes){
		for(Hero hero : heroes){ //for every hero..
			System.out.println("Hero: "+ hero.getName());//..get hero name and print it
		}
	}
	/**
	 * Creates a Hero instance to be the villain for the game
	 * @return Hero instance to act as villain 
	 */
	public static Hero createVillain(){
		
	   Hero naughtyOne = new Hero("Loki", "Staff", 20); //create the instance for the villain
	   return naughtyOne; //return the villain
		
	}
	/**
	 * Updates the hero's attackPoint by a multiple of 2 
	 * @param the hero to be updated
	 */
	 public static void heroTraining(Hero[] heroes){ 
		 
		 for(Hero hero : heroes){  // for every hero in the array..
			 hero.updateAttackPoints(hero.getAttackPoints()*2); //..double the original value
		   
		 }
	 }
	 /**
	  * Battle sequence for the program 
	  * A loop will run the amount of Battlerounds
	  * A hero will be randomly chosen as well as the amount of the heroes attackpoints
	  * Hits are determined by the higher attack points 
	  * @param array of heroes
	  * @param Hero to be the villain
	  * @param the amount of rounds to loop
	  */
	 public static void battle(Hero[] heroes, Hero villain, int battleRounds){
		 Random randomGenerator = new Random();  //create new random generator
		 for(int i = 0; i <= battleRounds; i++){   //loop as many times as the rounds
			Hero hero = heroes[randomGenerator.nextInt(heroes.length)]; //find random hero
			if(randomGenerator.nextInt(hero.getAttackPoints()+1) > villain.getAttackPoints()){  // if the random amt of attackpoints of the hero is greater than the villains attack points
				heroHits++; //increment the hits
			   System.out.println(hero.getName()+" got a successful hit with "+ hero.getWeapon()); //alert the user
			}else if(villain.getAttackPoints() > hero.getAttackPoints()){  //if the villain's attack points are grater than the hero's..
				 System.out.println(villain.getName()+" got a successful hit with "+ villain.getWeapon()); //alert the user
				 villainHits++; //increment the hits
			 }
		 }
	 }
	 /**
	  * Displays the final results to user
	  * Shows both hero and villain hits
	  */
	 public static void displayFightResults(){
		 System.out.println("\nBattle Stats: ");
		 System.out.println("Hero Hits on Villian: "+ heroHits); //show hero hits
		 System.out.println("Villain Hits on Heroes: "+ villainHits); //show villain hits
		 System.out.printf("\n\n");
	 }
	 
	 
	 /*
	 * I can be your hero, baby.
	 * I can kiss away the pain.
	 * I will stand by you forever.
	 * You can take my breath away
	 *
	 * - Enrique Iglesias 
	 */

}
