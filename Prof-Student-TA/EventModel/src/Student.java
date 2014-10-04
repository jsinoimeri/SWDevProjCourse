/** 
 * SYSC 3110 - Prof-Student-TA Example using Event Model
 * 
 * Student implements the CourseListener interface
 * in order to listen to updates when Prof makes
 * announcements.
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 4, 2014
 * @version 1.0
 * 
 */

import java.util.Date;

public class Student implements CourseListener
{
	private String name;      // name of Student
	private Date midterm;     // date of midterm

	
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

	private void study(Date date)
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
	
	private void party(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
	
	
	/**
	 * Outputs to the screen that an assignment has been postponed
	 * 
	 */
	
	private void postponedAssignment()
	{
		System.out.println("Assignment postponed");
	}

	
	/**
	 * Overrides the inherited method in order to 
	 * set the midterm date and output the appropriate
	 * message.
	 * 
	 * @param e -> CourseEvent representing an Event
	 * 
	 */
	
	@Override
	public void midtermAnnounced(CourseEvent e) 
	{
		this.study(((Prof) e.getSource()).getMidterm());
	}

	
	/**
	 * Overrides the inherited method in order to 
	 * call the appropriate method to output a message
	 * 
	 * @param e -> CourseEvent representing an Event
	 * 
	 */
	
	@Override
	public void assignmentPostponed(CourseEvent e) 
	{
		this.postponedAssignment();
	}

	
	/**
	 * Overrides the inherited method in order to 
	 * set the new midterm date and output the appropriate
	 * message.
	 * 
	 * @param e -> CourseEvent representing an Event
	 * 
	 */
	
	@Override
	public void midtermPostponed(CourseEvent e) 
	{
		this.party(((Prof) e.getSource()).getMidterm());
	}
	
}
