import java.util.ArrayList;


public class MovieList 
{
	
	
	private ArrayList<Movie> movieList;
	
	public MovieList()
	{
		this.movieList = new ArrayList<Movie>();
	}
	
	public int getSize()
	{
		return this.movieList.size();
	}
	
	public void add(Movie movie)
	{
		this.movieList.add(movie);
	}
	
	public boolean contains(Movie movie)
	{
		return this.movieList.contains(movie);
	}

}
