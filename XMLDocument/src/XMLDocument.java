/**
 * XMLDocument represents an XML Document that
 * comprised of Elements.
 * 
 * @author Jeton Sinoimeri
 * @version 2.0
 *
 */


public class XMLDocument 
{
	private Element root_element;
	
	
	/**
	 * Constructor for the XMLDocument class
	 * 
	 * @param root_element -> Element representing the 
	 *                        root of the document
	 *                        
	 */
	
	public XMLDocument(Element root_element) 
	{
		this.root_element = root_element;
	}
	
	
	/**
	 * String representation of the XML Document
	 * 
	 * @return String representing the XML Document
	 * 
	 */
	
	public String toString() 
	{
		return this.root_element.toString();
	}
	
	
	
	public static void main(String[] args) 
	{
		// example 1
		SimpleElement simple_el = new SimpleElement("student", "bart");
		XMLDocument doc = new XMLDocument(simple_el);
		System.out.println(doc);
		
		
		System.out.println();
		System.out.println();
		
		
		// example 2
		CompositeElement composite_el = new CompositeElement("university");
		composite_el.addElement(simple_el);
		doc = new XMLDocument(composite_el);
		System.out.println(doc);
		
		
		System.out.println();
		System.out.println();
		
		
		// example 3
		simple_el = new SimpleElement("student", "lisa");
		composite_el.addElement(simple_el);
		System.out.println(doc);
		
		
		System.out.println();
		System.out.println();
		
		
		// example 4
		CompositeElement composite_el2 = new CompositeElement("world");
		composite_el2.addElement(composite_el);
		composite_el2.addElement(simple_el);
		doc = new XMLDocument(composite_el2);
		System.out.println(doc);
	}
}
