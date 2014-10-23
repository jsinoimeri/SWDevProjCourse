
public class BuddyInfo 
{
	private static final int DEFAULTVAL = 0,
			                 LEGALAGE = 18;
	
	private String name,
	               address,
	               phone_num;
	
	private int age;
	
	public BuddyInfo(String name, String address, String phone_num, int age)
	{
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
		
		if (age >= 0)
			this.age = age;
		
		else
			this.age = DEFAULTVAL;
	}
	
	public BuddyInfo(BuddyInfo bI)
	{
		this.name = bI.getName();
		this.address = bI.getAddress();
		this.phone_num = bI.getPhoneNum();
		this.age = bI.getAge();
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
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setAge(int age)
	{
		if (age >= 0)
			this.age = age;
		
		else
			this.age = DEFAULTVAL;
	}
	
	public boolean isOver18()
	{
		return this.age > LEGALAGE;
	}
	
	public String greeting()
	{
		return "Hi " + this.name;
	}
	

}
