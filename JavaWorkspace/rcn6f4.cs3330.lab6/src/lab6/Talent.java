/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

public class Talent extends Goon{
   private String skill;
   
   /**
    * Constructor for the class
    * @param name  String to be the name (instantiated by super class) *
    * @param DOB   String to be the DOB (Instantiated by super class)  *
    * @param skill String to be the skill                              *
    */
   public Talent(String name, String DOB, String skill){
	   super(name,DOB); //call the super classes constructor 
	   setSkill(skill); //call setter for local attribute
   }
   
   /**
	  * Setter for the skill attribute                 *
	  * @param skill string to be the skill attribute  *
	  */
   protected void setSkill(String skill){
	   this.skill = skill;
   }
   
   /**
	 * Retrieves the skill attribute of the object *
	 * @return String that is the skill            *
	 */
   public String getSkill(){
	   return this.skill;
   }
}
