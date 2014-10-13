/**
 * Abstract class Element represents an XML Document
 * element that which has a tag, a value that may or
 * may not consist of other elements.
 * 
 * @author Jeton Sinoimeri
 * @version 1.8
 *
 */


public abstract class Element 
{
    private String tag;
    
    
    /**
     * Constructor for the Element class
     * 
     * @param tag -> String representation of the
     *               element tag
     *               
     */
    
    public Element(String tag) 
    {
    	this.tag = tag;
    }
    
    
    /**
     * Accessor for the opening tag of the element
     * 
     * @return openingTag -> String that represents the opening
     *                       tag of the element
     *                       
     */
    
    public String getOpeningTag() 
    {
    	String openingTag = "<" + this.tag + ">";
    	
    	return openingTag;
    }
    
    
    /**
     * Accessor for the closing tag of the element
     * 
     * @return openingTag -> String that represents the closing
     *                       tag of the element
     *                       
     */
    
    public String getClosingTag()
    {
        String closingTag = "</" + this.tag + ">";
    	
    	return closingTag;
    }
    

}
