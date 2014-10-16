/**
 * GUIAddressBook is a GUI representation of the 
 * AddressBook where the user is able to create
 * a Address book, save it and to add Contacts
 * which are represented by the BuddyInfo class
 * 
 * This class is a subclass of JFrame and it
 * implements ActionListener
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.3
 * @Created Oct 9, 2014
 * @Modified Oct 15, 2014
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class GUIAddressBook extends JFrame implements  ActionListener
{

	private static final long serialVersionUID = 1L;

	private static final int [] FRAMEDIMENSION = {400, 300};     // the dimensions of the frame
	
	
	// name of file to be written along with the info to be displayed on first line of file
	private static final String FILENAME = "MyAddressBook.txt",
			                    ADDRESSBOOKINFO = "My address book containing: \n";
	
	
	
	private enum text {NEW, SAVE, ADD};                 // enum for the menu bar texts
	
	private JFrame f,                                   // AddressBook JFrame instance
	               buddyFrame;                          // BuddyInfo JFrame instance
	
	private JMenuBar menuBar;                           // JMenuBar instance
	private AddressBook ab;                             // AddressBook instance
	
	private JTextArea name,                             // name of Buddy inputted into JTextArea
	                  address,                          // address of Buddy inputed into JTextArea
	                  phone_num;                        // phone_num of Buddy inputed into JTextArea

	
	/**
	 * Constructor for the GUIAddressBook class
	 * 
	 * @param frameName -> String representing the title of
	 *                     the frame to be displayed at top
	 *                     bar
	 * 
	 */
	
	public GUIAddressBook(String frameName)
	{
		super(frameName);
		this.makeFrame(frameName);
	}
	
	
	/**
	 * This method creates the frame as well as calls the method
	 * responsible for creating the menu bar.
	 * 
	 * @param frameName -> String representing the title of
	 *                     the frame to be displayed at top
	 *                     bar
	 */
	
	private void makeFrame(String frameName)
	{
		// create frame
		this.f = new JFrame(frameName);
		
		
		// set the size and closing feature
		this.f.setSize(FRAMEDIMENSION[0], FRAMEDIMENSION[1]);
		this.f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// create menu
		this.makeMenu();
		
		
		// display the menu
		this.f.setJMenuBar(this.menuBar);
		
		
		// set frame visible
		this.f.setVisible(true);
	}
	
	
	/**
	 * This method is responsible for creating the
	 * menu bar and the menu items for the frame.
	 * 
	 */
	
	private void makeMenu()
	{
		// Menu Bar
		this.menuBar = new JMenuBar();
				
		
		// create different tabs on Menu Bar
		JMenu fileMenu = new JMenu("File");
		this.menuBar.add(fileMenu);
		
		JMenu buddyMenu = new JMenu("BuddyInfo");
		this.menuBar.add(buddyMenu);
		buddyMenu.setEnabled(false);               // disable this menu at initialization
		
		
		//Menu Items for each tab
		JMenuItem item;
		
		item = new JMenuItem(text.NEW.name());
		item.addActionListener(this);
		fileMenu.add(item);
		
		item = new JMenuItem(text.SAVE.name());
		item.addActionListener(this);
		fileMenu.add(item);
		item.setEnabled(false);                     // disable this item at initialization
		
		item = new JMenuItem(text.ADD.name());
		item.addActionListener(this);
		buddyMenu.add(item);
		
	}
	
	
	/**
	 * Writes to a file all the contacts in the address book.
	 * If error occurs, it will print to the console a message.
	 * 
	 * @param bIarray -> An array of all the BuddyInfos in the
	 *                   Address Book
	 */
	
	private void writeTOfile(BuddyInfo [] bIarray)
	{
		// try to create and write to a file
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(FILENAME));
			
			out.write(ADDRESSBOOKINFO);                   // write to file opening line
			
			// for every BuddyInfo in array write to file
			for(BuddyInfo bI: bIarray)
			{
				String contact = bI.getName() + "\n" + bI.getAddress() + "\n" + bI.getPhoneNum() + "\n";
				out.write(contact);
			}
			
			out.close();           // close the file
		}
		
		// catch an IOException and display message
		catch (IOException io)
		{
			System.out.println("Cannot create the file to write in.");
		}
		
	}
	
	
	/**
	 * Makes the BuddyInfo Frame for inputting
	 * a new buddy.
	 * 
	 */
	
	private void makeBuddyFrame()
	{
		this.name = new JTextArea();
		this.address = new JTextArea();
		this.phone_num = new JTextArea();
		
		
		this.buddyFrame = new JFrame("Add BuddyInfo");
		
		this.buddyFrame.setSize(FRAMEDIMENSION[0], FRAMEDIMENSION[1]);
		this.buddyFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JMenuBar buddyMenuBar = new JMenuBar();
		
		JMenu buddyMenu = new JMenu("BuddyInfo");
		buddyMenuBar.add(buddyMenu);
		
		JMenuItem item = new JMenuItem(text.ADD.name());
		item.addActionListener(this);
		buddyMenu.add(item);
		
		// display the menu
		this.buddyFrame.setJMenuBar(buddyMenuBar);
		
		JButton button = new JButton("Add");
		button.addActionListener(this);
		
		JPanel buddyPanel = new JPanel(new BorderLayout());
		
		JPanel buddyInfoPanel = new JPanel(new GridLayout(3, 2));

		
		buddyInfoPanel.add(new JLabel("Name"));
		buddyInfoPanel.add(this.name);
		buddyInfoPanel.add(new JLabel("Address"));
		buddyInfoPanel.add(this.address);
		buddyInfoPanel.add(new JLabel("Phone Number"));
		buddyInfoPanel.add(this.phone_num);
		
		
		buddyPanel.add(button, BorderLayout.SOUTH);
		buddyPanel.add(buddyInfoPanel, BorderLayout.CENTER);
		
		this.buddyFrame.add(buddyPanel);
		this.buddyFrame.setLocation(FRAMEDIMENSION[0], FRAMEDIMENSION[1]);
		
		
		
		// set frame visible
		this.buddyFrame.setVisible(true);
		
	}
	
	
	/**
	 * Checks if an action as been performed and if it has
	 * then checks the individual source commands to find
	 * the appropriate information.
	 * 
	 * @param e -> ActionEvent instance representing an action
	 *             event.
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//System.out.println(e.getSource());
		//System.out.println(e.getActionCommand());
		
		if (e.getSource() instanceof JMenuItem)
		{
			// create new address book and enables menus and menu items
			if (e.getActionCommand().equals(text.NEW.name()))
			{
				this.ab = new AddressBook();              // initialize the address book
				System.out.println("Created");
				
				// enable the disable menu tab and menu item
				this.menuBar.getMenu(1).setEnabled(true);
				this.menuBar.getMenu(0).getMenuComponent(1).setEnabled(true);
								
			}
			
			
			// save address book to file
			else if (e.getActionCommand().equals(text.SAVE.name()))
			{
				System.out.println("Saved");
			
				BuddyInfo [] ab_array = this.ab.getAddressBookArray();    // get an array of buddyInfos
				
				this.writeTOfile(ab_array);                               // call writeTOfile method
			}
			
			
			// add a buddy to the address book
			else if (e.getActionCommand().equals(text.ADD.name()))
			{
				System.out.println("Added");				
				
				this.makeBuddyFrame();
			
			}
		}
		
		if (e.getSource() instanceof JButton)
		{
			if (e.getActionCommand().equals("Add"))
			{
				System.out.println("Button Pressed");
				
				BuddyInfo bI = new BuddyInfo(this.name.getText(), this.address.getText(), this.phone_num.getText());
				this.ab.addBuddy(bI.getName(), bI);
				
				this.buddyFrame.dispose();
			}
		}

	}
	
	
	
	public static void main(String [] args)
	{
		GUIAddressBook g = new GUIAddressBook("Gui Address Book");
		
	}
}
