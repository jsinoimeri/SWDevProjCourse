/** 
 * SYSC 3110 - Prof-Student-TA Example using Event Model
 * 
 * CourseEvent is a child of EventObject class
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 4, 2014
 * @version 1.0
 * 
 */

import java.util.EventObject;


public class CourseEvent extends EventObject 
{
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor for the CourseEvent class
	 * 
	 * @param arg0 -> Object representing the source of
	 *                the Event
	 *                
	 */
	
	public CourseEvent(Object arg0) 
	{
		super(arg0);
	}

}
