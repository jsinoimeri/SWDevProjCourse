/** 
 * SYSC 3110 - Prof-Student-TA Example using Event Model
 * 
 * TeachingAssistant implements the CourseListener interface
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

public class TeachingAssistant implements CourseListener
{
	private String name;      // name of TA
	private Date midterm;     // date of the midterm

	
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
	
	private void proctor(Date date)
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
	
	private void postpone(Date date)
	{
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
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
		this.proctor(((Prof) e.getSource()).getMidterm());
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
		this.postpone(((Prof) e.getSource()).getMidterm());
	}
	
}
