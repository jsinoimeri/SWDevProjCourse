/**
 * JUnit testing for BuddyInfo class.
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.1
 * @created Oct 23, 2014
 * @modified Oct 26, 2014
 * 
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest 
{
	
	private BuddyInfo buddy1;


	@Before
	public void setUp() throws Exception 
	{
		this.buddy1 = new BuddyInfo("Homer", "78 Springfield", "23794223");
	}

	@After
	public void tearDown() throws Exception
	{
		this.buddy1 = null;
	}

	@Test
	public void testBuddyInfoStringStringStringInt() 
	{
		assertEquals(this.buddy1.getAddress(), "78 Springfield");
		
		assertEquals(this.buddy1.getName(), "Homer");
		assertEquals(this.buddy1.getPhoneNum(), "23794223");
	}

	@Test
	public void testGetName() 
	{
		assertTrue("Homer".equals(this.buddy1.getName()));
		assertFalse("Lisa".equals(this.buddy1.getName()));
	}

	@Test
	public void testGetAddress() 
	{
		assertEquals(this.buddy1.getAddress(), "78 Springfield");

	}

	@Test
	public void testGetPhoneNum() 
	{
		assertEquals(this.buddy1.getPhoneNum(), "23794223");
	}

	
}
