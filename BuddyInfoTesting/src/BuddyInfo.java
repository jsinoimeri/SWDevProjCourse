/**
 * BuddyInfo contains information about a
 * contact such as name, age, address, and
 * phone number.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.1
 * @created Sept 25, 2014
 * @modified Oct 26, 2014
 * 
 */


public class BuddyInfo 
{
	
	// static variables for default values and legal age
	private static final int DEFAULTVAL = 0,
			                 LEGALAGE = 18;
	
	
	private String name,                 // String representing the name of the buddy
	               address,              // String representing the address of the buddy
	               phone_num;            // String representing the phone number of the buddy
	
	private int age;                     // integer representing the age of the buddy.
	
	
	
	/**
	 * Constructor for the BuddyInfo class.
	 * 
	 * @param name -> String representing the name of
	 *                the buddy.
	 * @param address -> String representing the address 
	 *                   of the buddy. 
	 * @param phone_num -> String representing the phone 
	 *                     number of the buddy
	 * @param age -> integer representing the age of the buddy
	 * 
	 */
	
	public BuddyInfo(String name, String address, String phone_num, int age)
	{
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
		
		// check if age is positive
		if (age >= 0)
			this.age = age;
		
		// otherwise set age to default value
		else
			this.age = DEFAULTVAL;
	}
	
	
	/**
	 * Constructor for the BuddyInfo class.
	 * 
	 * @param bI -> BuddyInfo instance to be copied.
	 * 
	 */
	
	public BuddyInfo(BuddyInfo bI)
	{
		this.name = bI.getName();
		this.address = bI.getAddress();
		this.phone_num = bI.getPhoneNum();
		this.age = bI.getAge();
	}
	
	
	/**
	 * Accessor for the name of the buddy.
	 * 
	 * @return name -> String representing the name
	 *                 of the buddy.
	 *                 
	 */
	
	public String getName()
	{
		return this.name;
	}
	
	
	/**
	 * Accessor for the address of the buddy.
	 * 
	 * @return address -> String representing the address
	 *                    of the buddy.
	 *                 
	 */
	
	public String getAddress()
	{
		return this.address;
	}
	
	
	/**
	 * Accessor for the phone number of the buddy.
	 * 
	 * @return phone_num -> String representing the phone
	 *                      number of the buddy.
	 *                 
	 */
	
	public String getPhoneNum()
	{
		return this.phone_num;
	}
	
	
	/**
	 * Accessor for the age of the buddy.
	 * 
	 * @return age -> integer representing the age
	 *                of the buddy.
	 *                 
	 */
	
	public int getAge()
	{
		return this.age;
	}
	
	
	/**
	 * Sets the age of the buddy to a new age if it is
	 * positive. Otherwise it sets it to default value.
	 * 
	 * @param age -> integer representing the new age
	 *               of the buddy.
	 *               
	 */
	
	public void setAge(int age)
	{
		// check if age is positive
		if (age >= 0)
			this.age = age;
		
		
		// otherwise set it to default
		else
			this.age = DEFAULTVAL;
	}
	
	
	/**
	 * Checks if the buddy is over 18 years of age or not.
	 * 
	 * @return value -> boolean representing if the buddy
	 *                  is over 18 years of age.
	 *                  
	 */
	
	public boolean isOver18()
	{
		return this.age > LEGALAGE;
	}
	
	
	/**
	 * Greeting returns a string representing a greeting for a
	 * particular buddy.
	 * 
	 * @return greeting -> String representing the greeting
	 *                     for the buddy.
	 *                     
	 */
	
	public String greeting()
	{
		return "Hi " + this.name;
	}
	

}
