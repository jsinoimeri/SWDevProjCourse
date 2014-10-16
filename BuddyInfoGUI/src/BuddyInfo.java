/**
 * BuddyInfo contains information about
 * a contact such as name, address and
 * phone number.
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.0
 * @Created Sept 18, 2014
 * @Modified Oct 15, 2014
 *
 */


public class BuddyInfo 
{
	private String name,               // name of buddy
	               address,            // address of buddy
	               phone_num;          // phone number of buddy
	
	/**
	 * Constructor for the BuddyInfo class
	 * 
	 * @param name -> String representing the name of the buddy
	 * @param address -> String representing the address of the 
	 *                   buddy.
	 * @param phone_num -> String representing the phone number 
	 *                     of the buddy.
	 *
	 */
	
	public BuddyInfo(String name, String address, String phone_num)
	{
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
	}
	
	
	/**
	 * Accessor for name of the buddy.
	 * 
	 * @return name -> String representing the name of the
	 *                 buddy
	 */
	
	public String getName()
	{
		return this.name;
	}
	
	
	/**
	 * Accessor for the address of the buddy.
	 * 
	 * @return address -> String representing the address of the 
	 *                    buddy.
	 */
	
	public String getAddress()
	{
		return this.address;
	}
	
	
	/**
	 * Accessor for the phone number of the buddy.
	 * 
	 * @return phone_num -> String representing the phone number 
	 *                      of the buddy.
	 */
	
	public String getPhoneNum()
	{
		return this.phone_num;
	}
	
}
