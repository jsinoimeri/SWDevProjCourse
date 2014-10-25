/**
 * Movie class representing a Movie Object
 * that contains only a name.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.1
 * @created Oct 23, 2014
 * @modified Oct 25, 2014
 *
 */

public class Movie 
{

	private String name;            // String instance representing name of movie
	
	
	/**
	 * Contructor for the Movie class
	 * 
	 * @param name -> String object representing the name
	 *                of the Movie.
	 *                
	 */
	
	public Movie (String name)
	{
		this.name = name;
	}
	
	
	/**
	 * Accessor for the name of the Movie.
	 * 
	 * @return name -> String object representing the name
	 *                 of the Movie.
	 */
	
	public String getName()
	{
		return this.name;
	}
}
