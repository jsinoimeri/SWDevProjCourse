import junit.framework.*;

public class TestMovieListWithEmptyList extends TestCase {
	private MovieList movieList = null;
	
	protected void setUp() 
	{
		movieList = new MovieList();
	}
	
	public void testSize() 
	{
		assertEquals(0, movieList.getSize());
	}
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TestMovieListWithEmptyList.class);
	}
}