/**
 * Name: Ryan Neff
 * Pawprint rcn6f4
 * Sub Code: MatIsOnTime
 */
package lab6;

public class Don extends Goon{
	
	private String mobName;
	private int netWorth;
	
	/**
	 * Constructor for the class									    *
	 * @param name  String to be the name (instantiated by super class) *
	 * @param mobName String to be the mob name 						*
	 * @param DOB     String to be the DOB (Instantiated by super class)*
	 * @param netWorth Int to be the netWorth 						    *
	 */
	public Don(String name, String mobName, String DOB, int netWorth){
		super(name,DOB);   //call super class constructor
		setMobName(mobName);  //call setters for attributes
		setNetWorth(netWorth);
	}
	
	/**
	  * Setter for the mobName attribute                  *
	  * @param mobName String to be the mobName attribute *
	  */
	protected void setMobName(String mobName){
		this.mobName = mobName;
	}
	
    /**
	  * Setter for the netWorth attribute                *
	  * @param netWorth int to be the netWorth attribute *
	  */
	protected void setNetWorth(int netWorth){
		this.netWorth = netWorth;
	}
	
	/**
	 * Retrieves the mobName attribute of the object *
	 * @return String that is the mobName            *
	 */
	public String getMobName(){
		return this.mobName;
	}
	
	/**
	 * Retrieves the netWorth attribute of the object *
	 * @return integer that is the netWorth           *
	 */
	public int getNetWorth(){
		return this.netWorth;
	}
	

}
