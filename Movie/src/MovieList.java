import java.util.ArrayList;


public class MovieList 
{
	
	// ArrayList object to maintain a list of Movies
	private ArrayList<Movie> movieList;
	
	
	/**
	 * Constructor for the MovieList class
	 * 
	 */
	
	public MovieList()
	{
		this.movieList = new ArrayList<Movie>();
	}
	
	
	/**
	 * Accessor for the size of the list of movies.
	 * 
	 * @return size -> integer representing the size of
	 *                 the movie list.
	 *                 
	 */
	
	public int getSize()
	{
		return this.movieList.size();
	}
	
	
	/**
	 * Adds a movie to the list.
	 * 
	 * @param movie -> Movie object representing the movie to
	 *                 be added to the list.
	 *                 
	 */
	
	public void add(Movie movie)
	{
		this.movieList.add(movie);
	}
	
	
	/**
	 * Checks if a movie is in the list or not.
	 * 
	 * @param movie -> Movie object to be checked if it is in
	 *                 the list.
	 * @return value -> boolean value representing if a movie
	 *                  is in the list or not.
	 *                  
	 */
	
	public boolean contains(Movie movie)
	{
		return this.movieList.contains(movie);
	}

}
