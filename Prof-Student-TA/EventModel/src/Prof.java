/** 
 * SYSC 3110 - Prof-Student-TA Example using Event Model
 * 
 * Prof class sets and announces midterms to Student
 * and TeachingAssistant instances kept in a list by using the
 * CourseListeners methods.
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 4, 2014
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof 
{
	private String name;                                  // name of Prof
	private Date midtermDate;                             // date of midterm
	private ArrayList<CourseListener> courseListener;     // a list of course listeners

	
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
		this.courseListener = new ArrayList<CourseListener>();
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
	 * Adds a CourseListener instance to the list.
	 * 
	 * This method is synchronized for mutual exclusion in order to prevent
	 * more than one thread from changing the list of CourseListeners at the
	 * same time
	 * 
	 * @param c -> CourseListener representing an instance that implements
	 *             the CourseListener interface
	 * 
	 */
	
	public synchronized void addCourseListener(CourseListener c)
	{
		this.courseListener.add(c);
	}
	
	
	/**
	 * Removes a CourseListener instance to the list.
	 * 
	 * This method is synchronized for mutual exclusion in order to prevent
	 * more than one thread from changing the list of CourseListeners at the
	 * same time
	 * 
	 * @param c -> CourseListener representing an instance that implements
	 *             the CourseListener interface
	 * 
	 */
	
	public synchronized void removeCourseListener(CourseListener c)
	{
		// loops through the entire list, until it finds and removes c
		for(int i = 0; i < this.courseListener.size(); i++)
			if (this.courseListener.get(i).equals(c))
				this.courseListener.remove(i);
	}

	
	/**
	 * Sets the midterm date and notifies all instances of CourseListener 
	 * in the list that the midterm has been set
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void setMidterm(Date date) 
	{
		this.midtermDate = date;
		
		// the prof creates the event
		CourseEvent e = new CourseEvent(this);
		
		// notify the listeners that midterm has been posted
		for (CourseListener cl: this.courseListener)
			cl.midtermAnnounced(e);
		
	}
	
	
	/**
	 * Sets a new midterm date and notifies all instances of CourseListener 
	 * in the list that the midterm has been postponed
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void postponeMidterm(Date date)
	{
		this.midtermDate = date;
		
		// the prof creates the event
		CourseEvent e = new CourseEvent(this);
		
		// notify the listeners that midterm has been postponed
		for (CourseListener cl: this.courseListener)
			cl.midtermPostponed(e);
		
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
		
		p.addCourseListener(new Student("H"));
		p.addCourseListener(new Student("I"));
		p.addCourseListener(new TeachingAssistant("J"));

	
		Date midterm = new Date();
		p.setMidterm(midterm);
		
		System.out.println();
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}