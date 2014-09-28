import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Room 
{
	private final static double WEIGHTDIFF = 0.0001;
	private final static double MAXWEIGHT = 20.0;
	
    private String description;
    private HashMap <String, Room> exits;
    private ArrayList <Item> items;
 

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.exits = new HashMap <String, Room>();
        this.items = new ArrayList <Item>();
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(String direction, Room room) 
    {
        exits.put(direction, room);
    }
    
    public void addItem(Item item)
    {
    	this.items.add(item);
    }
    
    public String getAllItems()
    {
    	String allItems = "";
    	for(int i = 0; i < this.items.size(); i++)
    		allItems += this.items.get(i).description() + "\n";
    	
    	return allItems;
    }
    
    private Item removeItem()
    {
    	if (!this.items.isEmpty())
    		for(int i = 0; i < this.items.size(); i++)
        		if ((this.items.get(i).getWeight() - MAXWEIGHT) < WEIGHTDIFF)
        			return this.items.remove(i);
    	
    	return null;
    }
    
    public Item getItem()
    {
    	return removeItem();
    }
    
    
    public Room getExit(String direction)
    {
    	return exits.get(direction);
    }
    
    public Set<String> exitsKeySet()
    {
    	return exits.keySet();
    }
    

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Prints the exits in the game
     */
    public String printExits()
    {
        String exitString = "Exits:";
        
        Set <String> keys = this.exitsKeySet();
        
        for (String k: keys)
            exitString += " " + k;
        
        return exitString;
        
    }
    
    public String getLongDescription()
    {
    	return "You are " + description + ".\n" + this.getAllItems() + printExits();
    }
    
    public Room leaveRoom(String direction)
    {
    	Room newRoom = this.exits.get(direction);
    	System.out.println(newRoom.getLongDescription());
    	
    	return newRoom;
    }

}
