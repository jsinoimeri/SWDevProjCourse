
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

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BuddyInfo bi1 = new BuddyInfo("Homer Simpson", "238 dixon rd", "615-245-3443");
		
		System.out.println(bi1.getName());
		System.out.println(bi1.getAddress());
		System.out.println(bi1.getPhoneNum());
	}

}
