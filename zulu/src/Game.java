import java.util.ArrayList;
import java.util.Stack;


/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> stackRoom;
    private ArrayList <Item> items;
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        stackRoom = new Stack<Room>();
        items = new ArrayList<Item>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room pub,
             lab,
             outside, 
             theater,
             office, 
             cellar;

        
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        
        office = new Room("in the computing admin office");
        cellar = new Room("in the Cellar");
        
        
        // initialise room exits
        outside.setExits("east", theater);
        outside.setExits("south", lab);
        outside.setExits("west", pub);
        
        theater.setExits("west", outside);
        
        pub.setExits("east", outside);
        
        lab.setExits("north", outside);
        lab.setExits("east", office);
        
        office.setExits("west", lab);
        office.setExits("down", cellar);
        
        cellar.setExits("up", office);
        
        // add items to rooms
        outside.addItem(new Item(outside, "tree", 1000));
        outside.addItem(new Item(outside, "tree", 347));
        
        theater.addItem(new Item(theater, "seat 1", 4.5));
        theater.addItem(new Item(theater, "seat 2", 4.5));
        theater.addItem(new Item(theater, "seat 3", 4.5));
        theater.addItem(new Item(theater, "seat 4", 4.5));
        
        pub.addItem(new Item(pub, "bench", 6.1));
        pub.addItem(new Item(pub, "table", 9.97));

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        
        else if (commandWord.equals("go"))
            goRoom(command);
        
        
        else if (commandWord.equals("look"))
            look();
        
        
        else if (commandWord.equals("back"))
        	back();
        
        else if (commandWord.equals("pickup"))
        	pickUp();
        
        else if (commandWord.equals("drop"))
        	drop();
        
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);
        

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println(parser.showCommands());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null,
        	 prevRoom = currentRoom;
        
        if(direction.equals("north"))
            nextRoom = currentRoom.getExit("north");
        
        if(direction.equals("east"))
            nextRoom = currentRoom.getExit("east");
        
        if(direction.equals("south"))
            nextRoom = currentRoom.getExit("south");
        
        if(direction.equals("west"))
            nextRoom = currentRoom.getExit("west");;
        
        if(direction.equals("up"))
        	nextRoom = currentRoom.getExit("up");
        
        if(direction.equals("down"))
        	nextRoom = currentRoom.getExit("down");

        if (nextRoom == null) 
            System.out.println("There is no door!");
                
        else 
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            this.stackRoom.push(prevRoom);
            
        }
        
        
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        
        else 
            return true;  // signal that we want to quit
        
    }
    
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    private void back()
    {
    	while (!stackRoom.empty())
    		currentRoom = stackRoom.pop();
    	
    	System.out.println(currentRoom.getLongDescription());
    }
    
    private void pickUp()
    {
    	if (currentRoom.getItem() == null)
    		System.out.println("Cannot pick up an item.");
    	
    	else
    	{
    		Item item = currentRoom.getItem();
    		items.add(item);
    		System.out.println("Picked up item");
    	}
    		
    }
    
    private void drop()
    {
    	if (items.isEmpty())
    		System.out.println("Cannot drop anything");
    	
    	else
    	{
    		items.remove(0);
    		System.out.println("Dropped item");
    	}

    		
    }
    
    public static void main(String args[])
    {
    	Game g = new Game();
    	g.play();
    }
}
