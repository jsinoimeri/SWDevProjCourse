/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class models an item that is present in the room. It
 * contains a reference to the room, the name of the item and
 * the weight of that item.
 * 
 * @author  Jeton Sinoimeri
 * @version 2014.09.19
 *
 */


public class Item 
{
	
	private Room room;
	private String name;
	private double weight;
	
	
	/**
	 * Conctructor for the Item class
	 *
	 * @param room -> a reference to a Room object
	 * @param name -> String representing the name
	 *                of the item
	 * @param weight -> double representing the weight
	 *                  of the item
	 *
	 */
	 
	public Item(Room room, String name, double weight)
	{
		this.room = room;
		this.name = name;
		this.weight = weight;
	}


  /**
   * Accessor for the Room
   *
   * @return Room object
   *
   */
   
	public Room getRoom() 
	{
		return room;
	}
	
	
	/**
	 * Mutator for the Room
	 *
	 * @param room -> a reference to a Room object
	 *
	 */
	 
	public void setRoom(Room room) 
	{
		this.room = room;
	}


	/**
   * Accessor for the name of item
   *
   * @return String representing the name of item
   *
   */

	public String getName() 
	{
		return name;
	}


	/**
	 * Mutator for the name
	 *
	 * @param name -> String object representing the name
	 *                of the item
	 *
	 */
	 
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	/**
   * Accessor for the weight of item
   *
   * @return double representing the weight of item
   *
   */

	public double getWeight() 
	{
		return weight;
	}


  /**
	 * Mutator for the weigth
	 *
	 * @param weight -> double value representing the weight
	 *                  of the item
	 *
	 */
	 
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	
	
	/**
	 * Description of the item with its name and weight
	 *
	 * @return String representing the description of the item
	 *
	 */
	
	public String description()
	{
		String description = "There is an item called " + name + " its weight is " + weight + " kg.";
		return description;
		
	}
	
	

}
