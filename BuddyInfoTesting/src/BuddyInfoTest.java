import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest 
{
	
	private BuddyInfo buddy1,
	                  buddy2;

	@Before
	public void setUp() throws Exception 
	{
		this.buddy1 = new BuddyInfo("Homer", "78 Springfield", "23794223", 40);
		this.buddy2 = new BuddyInfo(this.buddy1);
	}

	@After
	public void tearDown() throws Exception
	{
		this.buddy1 = this.buddy2 = null;
	}

	@Test
	public void testBuddyInfoStringStringStringInt() 
	{
		assertEquals(this.buddy1.getAddress(), "78 Springfield");
		assertEquals(this.buddy1.getAge(), 40);
		
		assertEquals(this.buddy1.getName(), "Homer");
		assertEquals(this.buddy1.getPhoneNum(), "23794223");
	}

	@Test
	public void testBuddyInfoBuddyInfo()
	{
		assertEquals(this.buddy1.getAddress(), this.buddy2.getAddress());
		assertEquals(this.buddy1.getAge(), this.buddy2.getAge());
		
		assertEquals(this.buddy1.getName(), this.buddy2.getName());
		assertEquals(this.buddy1.getPhoneNum(), this.buddy2.getPhoneNum());
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
		assertEquals(this.buddy2.getAddress(), "78 Springfield");
	}

	@Test
	public void testGetPhoneNum() 
	{
		assertEquals(this.buddy1.getPhoneNum(), "23794223");
		assertEquals(this.buddy2.getPhoneNum(), "23794223");
	}

	@Test
	public void testGetAge() 
	{
		assertEquals(this.buddy1.getAge(), 40);
		assertFalse(this.buddy1.getAge() == -1);
		
		assertFalse(this.buddy2.getAge() == 19);
		assertTrue(this.buddy2.getAge() == 40);
	}

	@Test
	public void testSetAge() 
	{
		assertEquals(this.buddy1.getAge(), 40);
		
		this.buddy1.setAge(-1);
		assertEquals(this.buddy1.getAge(), 0);
		
		this.buddy1.setAge(100);
		assertEquals(this.buddy1.getAge(), 100);
		
		this.buddy1.setAge(-100);
		assertEquals(this.buddy1.getAge(), 0);
		
		
		
        assertEquals(this.buddy2.getAge(), 40);
		
		this.buddy2.setAge(-1);
		assertEquals(this.buddy2.getAge(), 0);
		
		this.buddy2.setAge(100);
		assertEquals(this.buddy2.getAge(), 100);
		
		this.buddy2.setAge(-100);
		assertEquals(this.buddy2.getAge(), 0);
		
	}

	@Test
	public void testIsOver18() 
	{
		assertTrue(this.buddy1.isOver18());
		
		this.buddy1.setAge(-9);
		
		assertFalse(this.buddy1.isOver18());
		
		this.buddy1.setAge(18);
		
		assertFalse(this.buddy1.isOver18());
		
		this.buddy1.setAge(19);
		assertTrue(this.buddy1.isOver18());
		
		
		
        assertTrue(this.buddy2.isOver18());
		
		this.buddy2.setAge(-9);
		
		assertFalse(this.buddy2.isOver18());
		
		this.buddy2.setAge(18);
		
		assertFalse(this.buddy2.isOver18());
		
		this.buddy2.setAge(19);
		assertTrue(this.buddy2.isOver18());
	}

	@Test
	public void testGreeting() 
	{
		assertEquals(this.buddy1.greeting(), "Hi " + this.buddy1.getName());
		assertEquals(this.buddy2.greeting(), "Hi " + this.buddy2.getName());
	}

}
