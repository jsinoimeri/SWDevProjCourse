/** 
 * SYSC 3110 - Prof-Student-TA Original Example
 * 
 * TeachingAssistant class
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Sept 30, 2014
 * @version 1.0
 * 
 */

import java.util.Date;

public class TeachingAssistant 
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
	
}
