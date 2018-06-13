package pojava.brycie.DeSitter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Help extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help() throws HeadlessException 
	{
		
		super("Help");
		setLayout(null);
		setBounds(400,100,550,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		final JTextArea field = new JTextArea();
		field.setBounds(0, 0,  600, 600);
		getContentPane().add(field);
		field.setText("Wszechświat de Sittera (lub rozwiązanie de Sittera) – Wszechświat z prawem ekspansji " +
				"\n\n a(t) ~ exp(Ht) " +
				"\n\n gdzie a(t) jest czynnikiem skali, t czasem kosmicznym, a H parametrem Hubble'a" +
				"\n Rozwiązanie de Sittera opisuje sytuację, gdy stała kosmologiczna jest dodatnia, " +
				"\n a gęstość materii równa zero." +
				"\n W przypadku rozwiązania de Sittera nie ma miejsca na Wielki Wybuch – według tego " +
				"\n modelu Wszechświat rozszerza się w sposób wykładniczy (gwałtowny), " +
				"\n bez początku i bez końca." +
				" Hipottyczna epoka inflacji może być w przybliżeniu \n opisywana rozwiązaniem de Sittera.");
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