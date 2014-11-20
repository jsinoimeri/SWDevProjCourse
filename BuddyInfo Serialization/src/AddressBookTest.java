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
		BuddyInfo bI = new BuddyInfo("H", "2349", "234234234");
		this.ab.addBuddy(bI.getName(), bI);
	}

	@After
	public void tearDown() throws Exception 
	{
		this.ab = null;
	}

	@Test
	public void testAddressBook() 
	{
		assertEquals(this.ab.getSize(), 1);
	}

	@Test
	public void testAddBuddy() 
	{
		assertEquals(this.ab.getSize(), 1);
		
		
		BuddyInfo bI = new BuddyInfo("H", "234, 9", "234234234");
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 1);
		
		
		bI = new BuddyInfo("L", "234, 4", "23234234");
		this.ab.addBuddy(bI.getName(), bI);
		assertEquals(this.ab.getSize(), 2);
		
	}

	@Test
	public void testRemove() 
	{
				
		BuddyInfo bI = new BuddyInfo("L", "234, 4", "23234234");
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
		assertEquals(this.ab.getSize(), 1);
	}
	
	
	@Test
	public void testImportAddressBook()
	{
		this.ab.export();
		this.ab = new AddressBook();
		
		this.ab.importAddressBook();
		
		BuddyInfo [] bI = new BuddyInfo [this.ab.getSize()];
		
		// index of array
		int i = 0; 
		
		// for each buddy, add to array and increment the index
		for (String s: this.ab.getAddressbook().keySet())
		{
			bI[i] = this.ab.getAddressbook().get(s);
			assertTrue(bI[i].getName().equals("H"));
			i++;
		}
		
	}
	
	
	@Test
	public void testObjectWriteRead()
	{
		this.ab.writeSerialized();
		this.ab.readSerialized();
		
		assertEquals(1, this.ab.getSize());
	}


}
