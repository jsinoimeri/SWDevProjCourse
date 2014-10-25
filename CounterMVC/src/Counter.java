/**
 * Counter class increments up to a max amount
 * and then resets to a default value.
 * 
 * This class is a subclass of Observable.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.0
 * @created Oct 23, 2014
 * @modified Oct 23, 2014
 * 
 */

import java.util.Observable;


public class Counter extends Observable
{

	// default value
	private static int DEFAULTVAL = 0;
	
	
    private int max,              // integer representing max value
                value;            // integer representing the counter value
    

    
    /**
     * Constructor for the Counter class
     * 
     * @param max -> integer representing the max
     *               value that the counter can go
     *               to.
     * 
     */
    
    public Counter(int max) 
    {
        this.value = DEFAULTVAL;
        this.max = max;
    }

    
    /**
     * Increments the value, checks if the counter value has reached
     * the max value. If so then resets the counter value back to the
     * default value.
     * 
     * Notifies all the observers that there has been a change in the
     * counter value.
     * 
     */
    
    public void increment()
    {
    	// inc value
        value ++;
        
        // reset value if reached max
        if (value == max) 
        	value = DEFAULTVAL;
        
        // set the changed flag
        this.setChanged();
        
        // notify observers that the value has changed
        this.notifyObservers(this.value);
    }
}
