/**
 * CompositeElement is an Element that may contain one
 * or more sub Elements.
 * 
 * @author Jeton Sinoimeri
 * @version 1.8
 * 
 */


import java.util.*;

public class CompositeElement extends Element 
{
    private List<Element> elements;

    
    /**
     * Contructor for the CompositeElement class
     * 
     * @param tag -> String representing the tag of the
     *               element.
     * 
     */
    
    public CompositeElement(String tag) 
    {
    	super(tag);
        elements = new ArrayList<Element>();
    }

    
    /**
     * Adds an element to the List of elements
     * 
     * @param element -> Element class
     * 
     */
    
    public void addElement(Element element) 
    {
        elements.add(element);
    }
    

    /**
     * String representation of the List of elements
     * 
     * @return str -> String representing all the elements in a
     *                well formatted way in order to be printed 
     *                screen.
     *                
     */
    
    public String toString() 
    {
    	// get opening tag
    	String str = this.getOpeningTag() + "\n";
    	
    	// for every element in elements, add to string
    	for (Element element : elements)
    		str += element + "\n";  		
    	
    	// get closing tag
    	str += this.getClosingTag();
    	
    	return str;
    }
        
}
