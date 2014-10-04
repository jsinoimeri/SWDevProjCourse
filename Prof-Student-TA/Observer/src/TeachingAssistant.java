/** 
 * SYSC 3110 - Prof-Student-TA Example using Observer Pattern
 * 
 * TeachingAssistant class is an observer of Prof class and waits
 * for Prof to notify observers of any changes to its state. 
 * 
 * This class implements the Observer class.
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 2, 2014
 * @version 1.0
 * 
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer
{
	private String name;     // name of TA
	private Date midterm;    // date of midterm

	
	/**
	 * Constructor for the TeachingAssistant class
	 * 
	 * @param aName -> String representing the name of 
	 *                 TeachingAssistant
	 *                 
	 */
	
	public TeachingAssistant(String aName) 
	{
		this.name = aName;
	}

	
	/**
	 * Getter for the name of the TA
	 * 
	 * @return name -> String representing the name of TA
	 * 
	 */
	
	public String getName() 
	{
		return this.name;
	}

	
	/**
	 * This method sets the date of the midterm and outputs 
	 * to the screen a message stating the name of TA, and
	 * the date of the midterm to be proctored.
	 * 
	 * @param date -> Date representing the date of the midterm
	 * 
	 */
	
	public void proctor(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	
	/**
	 * This method sets the date of the midterm and outputs 
	 * to the screen a message indicating that there is a
	 * new date for the midterm.
	 * 
	 * @param date -> Date representing the date of the midterm
	 * 
	 */
	
	public void postpone(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}
	
	
	/**
	 * Overrides the update method provided by the interface Observer
	 * in order to call the appropriate methods based on the information
	 * passed by the parameters o and arg.
	 * 
	 * @param o -> Observable representing a child of the Observable class
	 * @param arg -> Object representing the date of the midterm
	 * 
	 */

	@Override
	public void update(Observable o, Object arg) 
	{				
		// check if midterm is not initialized
		if(this.midterm == null)
			this.proctor((Date) arg);
		
		// check if new midterm date is earlier than old midterm date
		else if( ((Date) arg).compareTo(this.midterm) < 0)
			this.proctor((Date) arg);
		
		// check if new midterm date is later than old midterm date
		else if( ((Date) arg).compareTo(this.midterm) > 0)
			this.postpone((Date) arg);
		
	}
}
