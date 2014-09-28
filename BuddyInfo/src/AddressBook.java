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
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AddressBook ab = new AddressBook();
		
		BuddyInfo bi1 = new BuddyInfo("Homer Simpson", "238 dixon rd", "615-245-3443");
		BuddyInfo bi2 = new BuddyInfo("Lisa Simpson", "28 diop st", "555-256-3478");
		
		ab.addBuddy(bi1.getName(), bi1);
		ab.addBuddy(bi2.getName(), bi2);
	
		System.out.println("Address book");
		
		ab.remove(bi1.getName());

	}

}
