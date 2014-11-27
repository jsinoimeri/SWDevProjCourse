import java.io.Serializable;


public class BuddyInfo implements Serializable
{

	private static final long serialVersionUID = 9134289657792087686L;
	
	private static final String SPECIAL_CHAR = "#";
	
	private String name,
	               address,
	               phone_num;
	
	
	public BuddyInfo(String name, String address, String phone_num)
	{
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getPhoneNum()
	{
		return this.phone_num;
	}

	public String toString()
	{
		String str = this.name + SPECIAL_CHAR + 
				this.address + SPECIAL_CHAR + this.phone_num;
		
		return str;
	}
	
	
	public static BuddyInfo import_buddyInfo(String str)
	{
		String [] str_arrayBuddyInfo = str.split(SPECIAL_CHAR);
		
		BuddyInfo bI = new BuddyInfo(str_arrayBuddyInfo[0], str_arrayBuddyInfo[1], str_arrayBuddyInfo[2]);
		
		return bI;
	}
	
	
	

}