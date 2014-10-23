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
		// add buddyInfo
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234", 40);
		this.ab.addBuddy(bI.getName(), bI);
		
		// add buddyInfo
		bI = new BuddyInfo("L", "234, 4", "23234234", 23);
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 2);
		
		// remove first buddyInfo
		this.ab.remove("H");
		
		// test size
		assertEquals(this.ab.getSize(), 1);
		
		// remove second buddyInfo
		this.ab.remove("L");
		
		// test size
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
		// add buddyInfo 1
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234", 40);
		this.ab.addBuddy(bI.getName(), bI);
		
		// add buddyInfo 2
		bI = new BuddyInfo("L", "234, 4", "23234234", 23);
		this.ab.addBuddy(bI.getName(), bI);
		
		// check value
		assertEquals(this.ab.getSize(), 2);
		
		// clear the address book
		this.ab.clearAddressBook();
		
		// check value
		assertEquals(this.ab.getSize(), 0);
		
	}

}
