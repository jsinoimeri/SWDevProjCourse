import java.util.HashMap;


public class AddressBook 
{
	private HashMap<String, BuddyInfo> addressBook;
	
	public AddressBook()
	{
		addressBook = new HashMap<>();
	}
	
	public void addBuddy(String name, BuddyInfo buddy_info)
	{
		this.addressBook.put(name, buddy_info);
	}
	
	public void remove(String name)
	{
		this.addressBook.remove(name);
	}
	
	public int getSize()
	{
		return this.addressBook.size();
	}
	
	public void clearAddressBook()
	{
		this.addressBook.clear();
	}
}
