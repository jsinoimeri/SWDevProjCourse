
public class Item 
{
	private Room room;
	private String name;
	private double weight;
	
	public Item(Room room, String name, double weight)
	{
		this.room = room;
		this.name = name;
		this.weight = weight;
	}

	public Room getRoom() 
	{
		return room;
	}

	public void setRoom(Room room) 
	{
		this.room = room;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	
	public String description()
	{
		String description = "There is an item called " + name + " its weight is " + weight + " kg.";
		return description;
		
	}
	
	

}
