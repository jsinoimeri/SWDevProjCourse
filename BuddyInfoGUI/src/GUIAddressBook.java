
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIAddressBook extends JFrame implements  ActionListener
{

	private static final long serialVersionUID = 1L;

	private enum text {NEW, SAVE, ADD};
	
	private JFrame f;
	private JMenuBar menuBar;
	
	private AddressBook ab;

	
	public GUIAddressBook(String frameName)
	{
		super(frameName);
		this.makeFrame(frameName);
	}
	
	
	private void makeFrame(String frameName)
	{
		// create frame
		f = new JFrame(frameName);
		
		f.setSize(400, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// create menu
		this.makeMenu();
		
		// display the menu
		f.setJMenuBar(this.menuBar);
	}
	
	
	private void makeMenu()
	{
		// Menu Bar
		this.menuBar = new JMenuBar();
				
		
		// Different tabs on Menu Bar
		JMenu fileMenu = new JMenu("File");
		this.menuBar.add(fileMenu);
		
		JMenu buddyMenu = new JMenu("BuddyInfo");
		this.menuBar.add(buddyMenu);
		
		
		//Menu Items for each tab
		JMenuItem item;
		
		item = new JMenuItem(text.NEW.name());
		item.addActionListener(this);
		fileMenu.add(item);
		
		item = new JMenuItem(text.SAVE.name());
		item.addActionListener(this);
		fileMenu.add(item);
		
		item = new JMenuItem(text.ADD.name());
		item.addActionListener(this);
		buddyMenu.add(item);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		//System.out.println(e.getSource());
		//System.out.println(e.getActionCommand());
		
		if (e.getSource() instanceof JMenuItem)
		{
			if (e.getActionCommand().equals(text.NEW.name()))
			{
				this.ab = new AddressBook();
				System.out.println("Created");
			}
			
			else if (e.getActionCommand().equals(text.SAVE.name()))
			{
				System.out.println("Saved");
				
				//Set entries =
				
			}
			
			else if (e.getActionCommand().equals(text.ADD.name()))
			{
				System.out.println("Added");
			}
		}

	}
	
	public static void main(String [] args)
	{
		GUIAddressBook g = new GUIAddressBook("Gui Address Book");
		
	}
}
