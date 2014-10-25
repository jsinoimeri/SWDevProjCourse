/**
 * View displays the contents of the Model
 * to the GUI. It relies on the Controller to
 * increment the counter on button press.
 * 
 * This class is a subclass of JFrame and it
 * implements Observer.
 * 
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.0
 * @created Oct 23, 2014
 * @modified Oct 23, 2014 
 * 
 */

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;



public class View extends JFrame implements Observer
{
	private static final long serialVersionUID = 1L;

	
	// int array for dimensions
	private static final int [] DIMENSIONS = {300, 400};
	
	
	// enum instance for the text
	private static enum TEXT { INCREMENT, COUNTER_MVC};
	

	
	private JFrame frame;               // JFrame instance for the frame
	private JButton button;             // JButton instance for the button
	private JLabel text;                // JLable instance for the counter to be displayed
	private JPanel panel;               // JPanel instance for the panel to be added to the frame
	
	
	/**
	 * Constructor for the View class.
	 * 
	 */
	
	public View()
	{	
		
		this.makeFrame();         // call makeFrame method
		this.makePanel();         // call makePanel method
		
		
		this.makeButton();        // call makeButton method
		this.makeText();          // call makeText method
		
		
		// refresh the frame to display the contents
		this.frame.setVisible(true);   
	}
	
	
	/**
	 * Sets up the frame to be displayed on the screen.
	 * 
	 */
	
	private void makeFrame()
	{
		// frame is assigned a new JFrame with title COUNTER_MVC
		this.frame = new JFrame(TEXT.COUNTER_MVC.name());
		
		// frame size is set to DIMENSIONS[0] and DIMENSIONS[1]
    	this.frame.setSize(DIMENSIONS[0], DIMENSIONS[1]);
    	
    	// set the default close operation to be DISPOSE_ON_CLOSE
    	this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * Sets up the panel to be added to the screen.
	 * 
	 */
	
	private void makePanel()
	{
		// panel is assigned a new JPanel with a BorderLayout
		this.panel = new JPanel(new BorderLayout());
		
		// adds panel to the frame
    	this.frame.add(this.panel);
	}
	
	
	/**
	 * Sets up the button to be added to the screen.
	 * 
	 */
	
	private void makeButton()
	{
		// button is assigned a new JButton with title INCREMENT
		this.button = new JButton(TEXT.INCREMENT.name());
		
		// button is added to the frame at the bottom of the panel
		this.frame.add(this.button, BorderLayout.SOUTH);
	}
	
	
	/**
	 * Sets up the text to be displayed onto the screen.
	 * 
	 */
	
	private void makeText()
	{
		// text is assigned a new JLabel with empty string
		this.text = new JLabel();
		
		// text is added to the frame at the center of the panel
		this.frame.add(this.text, BorderLayout.CENTER);
	}

	
	/**
	 * Update method being implemented to correspond to
	 * changes in the Model (Counter class)
	 * 
	 * @param o -> Observable instance representing the
	 *             Counter class.
	 * @param arg -> Object instance representing the
	 *               argument passed by the Counter class.
	 * 
	 */
	
	@Override
	public void update(Observable o, Object arg)
	{
		// set the text to be the value of the arg
		this.text.setText(""+((Integer) arg).intValue());
		
		// refresh the frame to display the new change
		this.frame.setVisible(true);
	}
	
	
	/**
	 * Adds an actionListener provided by the Controller
	 * to the button.
	 * 
	 * @param controller -> Controller instance representing
	 *                      the controller to be added to the
	 *                      actionListener of the button.
	 *                      
	 */
	
	public void addController(Controller controller)
	{
		this.button.addActionListener(controller);
	}
	
	

}
