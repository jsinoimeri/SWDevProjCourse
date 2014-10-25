/**
 * The Controller class tells the Counter
 * to modify itself accordingly to the 
 * action performed in the View.
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.0
 * @created Oct 23, 2014
 * @modified Oct 23, 2014
 * 
 */

import java.awt.event.*;


public class Controller implements ActionListener 
{
	
	private Counter counter;       // counter instance
	
	
	/**
	 * Constructor for the Controller classes
	 * 
	 * @param counter -> Counter class representing the 
	 *                   Model.
	 *                   
	 */
	
    public Controller(Counter counter)
    {
        this.counter = counter;
    }
    
    
    /**
     * Overrides the actionPerformered method to change the
     * Model state.
     * 
     */

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		counter.increment();
	}

}
