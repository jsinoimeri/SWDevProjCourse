/** 
 * SYSC 3110 - Prof-Student-TA Example using Observer Pattern
 * 
 * Prof class sets and announces midterms to Student
 * and TeachingAssistant instances using the notify 
 * observers method. 
 * 
 * This class is a subclass of the Observable class.
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 2, 2014
 * @version 1.0
 * 
 */

import java.util.Date;
import java.util.Observable;

public class Prof extends Observable
{
	private String name;         // name of Prof
	private Date midtermDate;    // date of midterm

	
	/**
	 * Constructor for the Prof class.
	 * 
	 * @param aName -> String representing the name of
	 *                 the Prof.
	 * 
	 */

	public Prof(String aName) 
	{
		this.name = aName;
	}

	
	/**
	 * Getter for the date of the midterm.
	 * 
	 * @return date -> Date representing the date of the
	 *                 midterm.
	 *                 
	 */
	
	public Date getMidterm() 
	{
		return this.midtermDate;
	}

	
	/**
	 * Getter for the name of the Prof.
	 * 
	 * @return name -> String representing the name of the
	 *                 Prof.
	 *                 
	 */
	
	public String getName() 
	{
		return this.name;
	}


	/**
	 * Sets the midterm date and calls the notify observers method
	 * with a parameter representing the date of the midterm
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void setMidterm(Date date) 
	{
		this.midtermDate = date;

		// set the hasChanged flag in order for notifyObservers to work
		this.setChanged();
		
		// notifies all observers
		this.notifyObservers(midtermDate);
	}
	
	
	/**
	 * Sets a new midterm date and calls the notify observers method
	 * with a parameter representing the new date of the midterm.
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void postponeMidterm(Date date)
	{
		this.midtermDate = date;
	
		// set the hasChanged flag in order for notifyObservers to work
		this.setChanged();
		
		// notifies all observers
		this.notifyObservers(midtermDate);
	}


	/**
	 * Main method of the class.
	 * 
	 * @param args -> String array of arguments
	 * 
	 */
	
	public static void main(String[] args) 
	{

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
		
		p.addObserver(s);
		p.addObserver(s2);
		p.addObserver(ta);
		
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		System.out.println();
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
		
	}

}
