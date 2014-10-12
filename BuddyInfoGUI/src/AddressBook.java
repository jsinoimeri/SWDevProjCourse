import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


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
	
	public BuddyInfo [] getAddressBookSet()
	{
		BuddyInfo [] b = new BuddyInfo [this.addressBook.size()];
		
		int i = 0;
		
		for (String s: this.addressBook.keySet())
		{
			b[i] = this.addressBook.get(s);
			i++;
		}
		
		return b;
	}
	
	public static void main(String [] args)
	{
		AddressBook ab = new AddressBook();
		BuddyInfo b = new BuddyInfo("s", "h", "r");
		ab.addBuddy(b.getName(), b);
		
		b = new BuddyInfo("f", "e", "u");
		ab.addBuddy(b.getName(), b);
		
		for (int i = 0; i < ab.getAddressBookSet().length; i++)
		{
			System.out.println(ab.getAddressBookSet()[i].getName());
			System.out.println(ab.getAddressBookSet()[i].getAddress());
			System.out.println(ab.getAddressBookSet()[i].getPhoneNum());
		}
		
	}
	
}
