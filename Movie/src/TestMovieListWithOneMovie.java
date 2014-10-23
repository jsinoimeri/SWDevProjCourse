
import junit.framework.*;

public class TestMovieListWithOneMovie extends TestCase
{
	private MovieList movieList = null;
	private Movie starWars = null;
	protected void setUp() 
	{
		starWars = new Movie("Star Wars");
		movieList = new MovieList();
		movieList.add(starWars);
	}
	public void testSize() 
	{
		assertEquals(1, movieList.getSize());
	}
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TestMovieListWithOneMovie.class);
	}
}
