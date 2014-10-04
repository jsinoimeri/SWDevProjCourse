/** 
 * SYSC 3110 - Prof-Student-TA Example using Observer Pattern
 * 
 * Student class is an observer of Prof class and waits
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

public class Student implements Observer
{
	private String name;     // name of Student
	private Date midterm;    // date of midterm


	/**
	 * Constructor for the Student class
	 * 
	 * @param aName -> String representing the name of 
	 *                 Student
	 *                 
	 */
	
	public Student(String aName) 
	{
		this.name = aName;
	}
	
	
	/**
	 * Getter for the name of the Student
	 * 
	 * @return name -> String representing the name of Student
	 * 
	 */

	public String getName() 
	{
		return this.name;
	}
	
	
	/**
	 * This method sets the date of the midterm and outputs 
	 * to the screen a message stating the name of Student, the
	 * fact that they have to study and the date of the midterm.
	 * 
	 * @param date -> Date representing the date of the midterm
	 * 
	 */

	public void study(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	
	/**
	 * This method sets the new date of the midterm and outputs 
	 * to the screen a message indicating that there is a
	 * new date for the midterm, therefore they can party.
	 * 
	 * @param date -> Date representing the date of the midterm
	 * 
	 */
	
	public void party(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	
	/**
	 * Overrides the update method provided by the interface Observer
	 * in order to call the appropriate methods based on the information
	 * passed by the parameters prof and midterm.
	 * 
	 * @param prof -> Observable representing a child of the Observable class
	 * @param midterm -> Object representing the date of the midterm
	 * 
	 */
	
	@Override
	public void update(Observable prof, Object midterm) 
	{
		// check if midterm is not initialized
		if (this.midterm == null)
			this.study((Date)midterm);
		
		// check if new midterm date is earlier than old midterm date
		else if( ((Date) midterm).compareTo(this.midterm) < 0)
			this.study((Date)midterm);
		
		// check if new midterm date is later than old midterm date
		else if( ((Date) midterm).compareTo(this.midterm) > 0)
			this.party((Date)midterm);
	}
	
}
