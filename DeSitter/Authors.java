package pojava.brycie.DeSitter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Authors extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Authors() throws HeadlessException 
	{
		
		super("Authors");
		setLayout(null);
		setBounds(800,100,150,60);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		final JTextArea field = new JTextArea();
		field.setBounds(0, 0, 640, 480);
		getContentPane().add(field);
		field.setText(" Ewelina Cieśla \n Marek Brynda");
		field.setEditable(false);

		
		
		JButton closeFrameButton = new JButton("Exit");
		closeFrameButton.setBounds(520,400,100,20);
		add(closeFrameButton);
		
		ActionListener closeListener = new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						System.exit(1);
					}
				};
		closeFrameButton.addActionListener(closeListener);
		
	}
}