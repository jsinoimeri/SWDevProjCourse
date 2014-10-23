import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


public class AllTests extends TestCase
{
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(suite());
	}
	
	public static Test suite() 
	{
		TestSuite suite = new TestSuite("Test for com.saorsa.nowplaying.tests");
		suite.addTest(new TestSuite(TestMovieListWithEmptyList.class));
		suite.addTest(new TestSuite(TestMovieListWithOneMovie.class));
		suite.addTest(new TestSuite(TestMovieListWithTwoMovies.class));
		return suite;
	}
}
