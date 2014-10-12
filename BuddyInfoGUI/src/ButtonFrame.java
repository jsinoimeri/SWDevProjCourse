import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class ButtonFrame extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;

	
	private JButton button;
	
	
	public ButtonFrame(String buttonName)
	{
		makeButton(buttonName);
	}
	
	
	private void makeButton(String buttonName)
	{
		this.button = new JButton(buttonName);
		this.button.addActionListener(this);
		
		getContentPane().add(this.button);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		e.getSource();

	}

}
