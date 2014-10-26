/**
 * AddressBook contains a list of BuddyInfo.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.1
 * @created Sept 25, 2014
 * @modified Oct 26, 2014
 * 
 */

import java.util.HashMap;


public class AddressBook 
{
	// hashmap instance to contain BuddyInfos.
	private HashMap<String, BuddyInfo> addressBook;
	
	
	/**
	 * Constructor for the Addressbook class
	 * 
	 */
	
	public AddressBook()
	{
		addressBook = new HashMap<>();
	}
	
	
	/**
	 * Add a BuddyInfo to the address book.
	 * 
	 * @param name -> String representing the name of the
	 *                buddy to be added.
	 * @param buddy_info -> BuddyInfo instance representing
	 *                      the buddy info to be added.
	 *                      
	 */
	
	public void addBuddy(String name, BuddyInfo buddy_info)
	{
		this.addressBook.put(name, buddy_info);
	}
	
	
	/**
	 * Removing a BuddyInfo from the address book.
	 * 
	 * @param name -> String representing the name of
	 *                buddy to be removed.
	 *                
	 */
	
	public void remove(String name)
	{
		this.addressBook.remove(name);
	}
	
	
	/**
	 * Accessor for the size of the address book.
	 * 
	 * @return size -> Integer representing the current 
	 *                 size.
	 *                 
	 */
	
	public int getSize()
	{
		return this.addressBook.size();
	}
	
	
	/**
	 * Clears the entire address book.
	 * 
	 */
	
	public void clearAddressBook()
	{
		this.addressBook.clear();
	}
}
