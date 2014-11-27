import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class AddressBook implements Serializable
{
	
	private static final long serialVersionUID = -1561140546027231230L;

	
	
	private static final String FILENAME = "MyAddressBook.txt",
			                    FILENAMXML = "MyAddressBook.xml" ;
	
	private HashMap<String, BuddyInfo> addressBook;
	
	private int ObjectSize;
	

	
	public AddressBook()
	{
		this.ObjectSize = 0;
		addressBook = new HashMap<>();
	}
	
	public void addBuddy(String name, BuddyInfo buddy_info)
	{
		this.addressBook.put(name, buddy_info);
	}
	
	public void remove(String name)
	{
		this.addressBook.remove(name);
	}
	
	private void writeTOfile()
	{
		// try to create and write to a file
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(FILENAME));
			
			BuddyInfo [] bIarray = this.getAddressBookArray();
			out.write("My addressbook");
			// for every BuddyInfo in array write to file
			for(BuddyInfo bI: bIarray)
			{
				String contact = bI.toString();
				out.newLine();
				out.write(contact);
			}
			
			out.close();           // close the file
		}
		
		// catch an IOException and display message
		catch (IOException io)
		{
			System.out.println("Cannot create the file to write in.");
		}
		
	}
	
	/**
	 * Gets all the BuddyInfos that are in the AddressBook in
	 * an array.
	 * 
	 * @return bI -> An array of BuddyInfos that are in the
	 *               AddressBook
	 */
	
	private BuddyInfo [] getAddressBookArray()
	{
		// create an array
		BuddyInfo [] bI = new BuddyInfo [this.addressBook.size()];
		
		// index of array
		int i = 0; 
		
		// for each buddy, add to array and increment the index
		for (String s: this.addressBook.keySet())
		{
			bI[i] = this.addressBook.get(s);
			i++;
		}
		
		return bI;
	}
	
	
	
	public void export()
	{
		this.writeTOfile();
	}
	
	public void importAddressBook()
	{
		this.readFromFile();
	}
	
	public HashMap<String, BuddyInfo> getAddressbook()
	{
		return this.addressBook;
	}
	
	
	private void readFromFile()
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String x ="";
			for ( x = in.readLine(); x != null; x = in.readLine())
			{
				if (!x.equals("My addressbook"))
				{
					String[] array = x.split("#");
					this.addBuddy(array[0], BuddyInfo.import_buddyInfo(x.toString()));
				}
			}
			
			in.close();
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("Cannot find file.");
		}
		catch (IOException io)
		{
			System.out.println("Cannot close BufferedReader");
		}
			
	}
	
	
	public int getSize()
	{
		return this.addressBook.size();
	}
	
	
	public void writeSerialized()
	{
		try {

	         // create a new file with an ObjectOutputStream
	         FileOutputStream out = new FileOutputStream(FILENAME);
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         // write something in the file
	         BuddyInfo s[] = this.getAddressBookArray();
	         
	         for (int i = 0; i < s.length; i++)
	         {
	        	 this.ObjectSize ++;
	        	 oout.writeObject(s[i]);
	         }

	         this.addressBook.clear();
	         // close the stream
	         oout.close();


	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
	
	
	public void readSerialized()
	{
	    // create an ObjectInputStream for the file we created before
        ObjectInputStream ois;
		try 
		{
			ois = new ObjectInputStream(new FileInputStream(FILENAME));
			// read and print what we wrote before
			for (int i = 0; i < this.ObjectSize; i++)
			{
				BuddyInfo b = ((BuddyInfo) ois.readObject());
				String s = b.toString();
				System.out.println(s);
				this.addBuddy(s.split("#")[0], b);
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}
	
	
	public void ExportToXMLFile()
	{
		
		try
		{
		   // create a new file with an ObjectOutputStream
			BufferedWriter out = new BufferedWriter(new FileWriter(FILENAMXML));
			
			
		    out.write(this.toXML());
			// for every BuddyInfo in array write to file
			
		    
		    
			out.close();           // close the file
		}
		
		// catch an IOException and display message
		catch (IOException io)
		{
			System.out.println("Cannot create the file to write in.");
		}
		
	}
	
	public String toXML()
	{
		String xmlDoc = "<AddressBook>\n";
		
		BuddyInfo [] bI = this.getAddressBookArray();
		
		for(int i = 0; i < bI.length; i++)
		{
			xmlDoc += "\t<BuddyInfo>\n";
			xmlDoc += "\t\t<Name>" + bI[i].getName() + "</Name>\n";
			xmlDoc += "\t\t<Address>" + bI[i].getAddress() + "</Address>\n";
			xmlDoc += "\t\t<PhoneNum>" + bI[i].getPhoneNum() + "</PhoneNum>\n";
			xmlDoc += "\t</BuddyInfo>\n";
		}
		
		xmlDoc += "</AddressBook>";
		
		return xmlDoc;
	}
	
	public void importFromXMLFileDOM()
	{
		
		try 
		{
			this.addressBook.clear();
			this.readDOM(new File(FILENAMXML));
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void readDOM(File f) throws Exception
	{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = factory.newDocumentBuilder();
		Document doc = (Document) d.parse(f);
		
		System.out.println("\nRoot: " + ((org.w3c.dom.Document) doc).getDocumentElement().getNodeName());
		
		NodeList list = ((org.w3c.dom.Document) doc).getDocumentElement().getChildNodes();
		
		for(int i = 0; i < list.getLength(); i++)
		{
			Node n = (Node) list.item(i);
			System.out.println("Child: " + n.getNodeName() + " --> " + n.getTextContent());
			
			
			String s[] = n.getTextContent().split("\t\t");
			
			if (s.length > 2)
				this.addBuddy(s[1],new BuddyInfo(s[1], s[2], s[3]));
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AddressBook ab = new AddressBook();
		
		BuddyInfo bi1 = new BuddyInfo("Homer Simpson", "238 dixon rd", "615-245-3443");
		BuddyInfo bi2 = new BuddyInfo("Lisa Simpson", "28 diop st", "555-256-3478");
		
		ab.addBuddy(bi1.getName(), bi1);
		ab.addBuddy(bi2.getName(), bi2);
	
		System.out.println("Address book");
		
		
		//ab.export();
		
		//ab.importAddressBook();
		
		ab.writeSerialized();
		
		ab.readSerialized();
		
		ab.ExportToXMLFile();
		ab.importFromXMLFileDOM();
		
		System.out.println(ab.getSize());
	}

}