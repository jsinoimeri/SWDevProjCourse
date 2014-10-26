/**
 * JUnit testing for AddressBook class.
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


public class AddressBookTest 
{
	private AddressBook ab;

	@Before
	public void setUp() throws Exception 
	{
		this.ab = new AddressBook();
	}

	@After
	public void tearDown() throws Exception 
	{
		this.ab = null;
	}

	@Test
	public void testAddressBook() 
	{
		assertEquals(this.ab.getSize(), 0);
	}

	@Test
	public void testAddBuddy() 
	{
		assertEquals(this.ab.getSize(), 0);
		
		
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234", 40);
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 1);
		
		
		bI = new BuddyInfo("L", "234, 4", "23234234", 23);
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 2);
		
	}

	@Test
	public void testRemove() 
	{
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234", 40);
		this.ab.addBuddy(bI.getName(), bI);
		
		bI = new BuddyInfo("L", "234, 4", "23234234", 23);
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 2);

		this.ab.remove("H");
		assertEquals(this.ab.getSize(), 1);
		
		this.ab.remove("L");
		assertEquals(this.ab.getSize(), 0);
	}

	@Test
	public void testGetSize() 
	{
		assertEquals(this.ab.getSize(), 0);
	}

	@Test
	public void testClearAddressBook() 
	{
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234", 40);
		this.ab.addBuddy(bI.getName(), bI);

		bI = new BuddyInfo("L", "234, 4", "23234234", 23);
		this.ab.addBuddy(bI.getName(), bI);

		assertEquals(this.ab.getSize(), 2);

		this.ab.clearAddressBook();
		assertEquals(this.ab.getSize(), 0);
		
	}

}
