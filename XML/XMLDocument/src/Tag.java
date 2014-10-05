

public class Tag
{
	private String name;
	private Text data;
	
	public Tag(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getData()
	{
		return this.data.getData();
	}
	
	public void setData(String data)
	{
		this.data = new Text(data);
	}
	
	public String getOpeningTag()
	{
		String s = "<" + this.name + ">";
		
		return s;
	}
	
	public String getClosingTag()
	{
        String s = "<\\" + this.name + ">";
		
		return s;
	}

}
