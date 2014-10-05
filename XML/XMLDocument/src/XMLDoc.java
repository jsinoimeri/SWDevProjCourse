import java.util.ArrayList;


public class XMLDoc 
{
	private ArrayList<String> elements;
	
	public XMLDoc(ArrayList<String> elements)
	{
		this.elements = elements;
	}
	
	public void printXML()
	{
		for (int i = 0; i < this.elements.size(); i++)
		{
			if (this.elements.get(i).contains("<\\") && !this.elements.get(i).startsWith("<\\"))
			    System.out.println("\t" + this.elements.get(i));
			
			else
				System.out.println(this.elements.get(i));
		}
	}
	
	public static void main(String [] args)
	{
		Elements e1 = new Elements("code", "Sysc 3110");
		Elements e2 = new Elements("course", e1);
		//Elements [] e = {e1, e2};
		//Elements e4 = new Elements("course", e);
		
		
		XMLDoc x = new XMLDoc(e2.getElements());
		
		x.printXML();
	}

}
