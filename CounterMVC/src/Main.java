/**
 * Main class has the main method for 
 * running Counter, Controller and View
 * 
 * @author Jeton Sinoimeri
 * 
 * @version 1.0
 * @created Oct 23, 2014
 * @modified Oct 23, 2014
 * 
 */

public class Main
{	
	public static void main(String[] args) 
    {
		View v = new View();
		
    	Counter counter = new Counter(10);
    	counter.addObserver(v);
    	
    	Controller c = new Controller(counter);
    	v.addController(c);
    }

}
