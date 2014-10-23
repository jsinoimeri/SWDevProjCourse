import junit.framework.*;

public class TestMovieListWithTwoMovies extends TestCase 
{
	private MovieList movieList = null;
	private Movie starWars = null;
	private Movie starTrek = null;
	private Movie stargate = null;
	
	protected void setUp() 
	{
		starWars = new Movie("Star Wars");
		starTrek = new Movie("Star Trek");
		stargate = new Movie("StarGate");
		movieList = new MovieList();
		movieList.add(starWars);
		movieList.add(starTrek);
	}
	
	public void testSizeAfterAddingTwo() 
	{
		assertEquals("Size of a two item list should be 2.", 2, movieList.getSize());
	}
	
	public void testContents() 
	{
		assertTrue("List should contain starWars.", movieList.contains(starWars));
		assertTrue("List should contain starTrek.", movieList.contains(starTrek));
		assertFalse("List should not contain stargate.",
		movieList.contains(stargate));
	}
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TestMovieListWithTwoMovies.class);
	}
}
