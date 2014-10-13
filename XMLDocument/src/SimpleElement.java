/**
 * SimpleElement is an Element that has an opening tag,
 * a value and a closing tag.
 * 
 * @author Jeton Sinoimeri
 * @version 1.8
 *
 */


public class SimpleElement extends Element 
{

    private String value;

    
    /**
     * Constructor for the SimpleElement
     * 
     * @param tag -> String representing the tag of the element
     * @param value -> String representing the value of the
     *                 element
     *                 
     */
    
    public SimpleElement(String tag, String value) 
    {
        super(tag);
        this.value = value;
    }

    
    /**
     * String representation of the element
     * 
     * @return str -> String representing of the simple
     *                element
     *                
     */
    
    public String toString() 
    {
    	String s = this.getOpeningTag() + value + this.getClosingTag();
        
    	return s;
    }
}
