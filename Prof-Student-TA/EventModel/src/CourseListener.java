/**
 * SYSC 3110 - Prof-Student-TA Example using Event Model
 * 
 * CourseListener interface which Student and
 * TeachingAssistant classes will have to implement
 * 
 * By: Jeton Sinoimeri
 * 
 * @date Oct 4, 2014
 * @version 1.0
 *
 */


public interface CourseListener 
{
	public void midtermAnnounced(CourseEvent e);
	public void midtermPostponed(CourseEvent e);
	public void assignmentPostponed(CourseEvent e);
}
