/** 
 * SYSC 2101 - Prof-Student-TA Original Example
 * 
 * Prof class sets and announces midterms to Student
 * and TeachingAssistant instances by calling each one's
 * appropriate methods.
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Sept 30, 2014
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof 
{
	private String name;                   // name of Prof
	private Date midtermDate;              // date of midterm
	private ArrayList<Student> students;   // list of students
	private TeachingAssistant ta;          // instance of TA

	
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
		this.students = new ArrayList<Student>();
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
	 * Sets the midterm date, and calls the appropriate methods
	 * for both the instances of Students and TA
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void setMidterm(Date date) 
	{
		this.midtermDate = date;
		
		// iterate over all students and call study() method
		for(Student s: this.students)
			s.study(date);
		
		ta.proctor(date);
	}
	
	
	/**
	 * Sets a new midterm date and calls the appropriate methods
	 * for both the instances of Students and TA
	 * 
	 * @param date -> Date representing the date of the midterm.
	 * 
	 */
	
	public void postponeMidterm(Date date)
	{
		this.midtermDate = date;
		
		// iterate over all students and call party() method
		for(Student s: this.students)
			s.party(date);
		
		ta.postpone(date);
	}
	
	
	/**
	 * Set a new TA
	 * 
	 * @param theTA -> TeachingAssistant representing a new TA
	 * 
	 */
	
	public void setTA(TeachingAssistant theTA)
	{
		this.ta = theTA;
	}
	
	
	/**
	 * Add a new student to the list
	 * 
	 * @param s -> Student representing a new student that will
	 *             be added to the list of students
	 *             
	 */
	
	public void addStudent(Student s)
	{
		this.students.add(s);
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
	
	
		p.addStudent(s);
		p.addStudent(s2);
		p.setTA(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		System.out.println();
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
		
	}

}
