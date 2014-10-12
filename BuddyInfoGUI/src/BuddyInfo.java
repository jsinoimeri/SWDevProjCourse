
public class BuddyInfo 
{
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
	
}
