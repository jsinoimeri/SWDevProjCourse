/** 
 * SYSC 3110 - Prof-Student-TA Original Example
 * 
 * Student class
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Sept 30, 2014
 * @version 1.0
 * 
 */

import java.util.Date;

public class Student
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
	
}
