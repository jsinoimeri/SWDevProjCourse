import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MovieListTest 
{
	private Movie movie;
	private MovieList movieList;
	
	@Before
	public void setUp() throws Exception 
	{
		this.movie = new Movie("Star Wars");
		this.movieList = new MovieList();
	}

	@After
	public void tearDown() throws Exception 
	{
		this.movie = null;
		this.movieList = null;
	}

	@Test
	public void test() 
	{
		assertEquals(this.movieList.getSize(), 0);
	}
	
	@Test
	public void testgetSize()
	{
		assertEquals(this.movieList.getSize(), 0);
	}
	
	@Test
	public void testSizeAfterAdding() 
	{
		this.movieList.add(this.movie);
		assertEquals(1, this.movieList.getSize());
		
		this.movie = new Movie("2 fast 2 furious");
		this.movieList.add(this.movie);
		assertEquals(2, this.movieList.getSize());
		
		
		this.movie = new Movie("BlackHawk Down");
		this.movieList.add(this.movie);
		assertEquals(3, this.movieList.getSize());
		
	}
	
	@Test
	public void testContents()
	{
		this.movieList.add(this.movie);
		assertTrue(this.movieList.contains(this.movie));
		
		this.movie = new Movie("Star Trek");
		this.movieList.add(this.movie);
		
		assertTrue(this.movieList.contains(this.movie));
		this.movie = new Movie("Star Gate");
		assertFalse(this.movieList.contains(this.movie));
		
	}
	
	

}
