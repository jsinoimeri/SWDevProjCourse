/**
 * AddressBook is a collection of
 * BuddyInfos.
 * 
 * @author Jeton Sinoimeri
 * @StudenNum 100875046
 * 
 * @version 1.2
 * @Created Sept 18, 2014
 * @Modified Oct 15, 2014
 *
 */


import java.util.HashMap;


public class AddressBook 
{
	// hash map representing a collection of BuddyInfos
	private HashMap<String, BuddyInfo> addressBook;          
	
	
	/**
	 * Constructor for AddressBook class
	 * 
	 */
	
	public AddressBook()
	{
		addressBook = new HashMap<>();
	}
	
	
	/**
	 * Adds a BuddyInfo to the AddressBook
	 * 
	 * @param name -> String representing the name of the Buddy
	 * @param buddy_info -> BuddyInfo instance to be added to the
	 *                      collection
	 */
	
	public void addBuddy(String name, BuddyInfo buddy_info)
	{
		this.addressBook.put(name, buddy_info);
	}
	
	
	/**
	 * Removes a BuddyInfo from the AddressBook
	 * 
	 * @param name -> String representing the name of the Buddy
	 *                to be deleted.
	 */
	
	public void remove(String name)
	{
		this.addressBook.remove(name);
	}
	
	
	/**
	 * Gets all the BuddyInfos that are in the AddressBook in
	 * an array.
	 * 
	 * @return bI -> An array of BuddyInfos that are in the
	 *               AddressBook
	 */
	
	public BuddyInfo [] getAddressBookArray()
	{
		// create an array
		BuddyInfo [] bI = new BuddyInfo [this.addressBook.size()];
		
		// index of array
		int i = 0; 
		
		// for each buddy, add to array and increment the index
		for (String s: this.addressBook.keySet())
		{
			bI[i] = this.addressBook.get(s);
			i++;
		}
		
		return bI;
	}
	
}
