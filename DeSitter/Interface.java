package pojava.brycie.DeSitter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class Interface extends JFrame implements Runnable{


	private static final long serialVersionUID = 1L;
	//public static int sliderValue;
	
	static boolean ifSave=false;
	boolean ifStart=false;
	//java.util.Timer movement;

//file chooser
	final JFileChooser fc = new JFileChooser();
	
//tworzenie 3ch glownych paneli
  	static Animation2 pAnmation = new Animation2();
  	JPanel pDescription = new JPanel();
  	JPanel pSettings = new JPanel(new FlowLayout());
  	
  	
  	
  	
 //tworzenie menu
	JMenuBar menuBar = new JMenuBar();
	JMenu menuFile = new JMenu("Plik");
	JMenu menuTools = new JMenu("Narzędzia");
	JMenu menuInfo = new JMenu("Info");
	JMenuItem menuItemSave = new JMenuItem("Zapisz");
	JMenuItem menuItemOpen = new JMenuItem("Otwórz");
	JMenuItem menuItemLanguage = new JMenuItem("Język");
	JMenuItem menuItemTheme = new JMenuItem("Motyw");
	JMenuItem menuItemAuthors = new JMenuItem("Autorzy");
	JMenuItem menuItemDescritption = new JMenuItem("Opis");
	
	

 //tworzenie paneli i przycisków/suwaków w tych panelach
	JPanel pSLeft = new JPanel(new GridLayout(1, 2));
	JPanel pSRight = new JPanel(new GridLayout(2, 2));
    JPanel pSRigtSliders = new JPanel(new GridLayout(2,2));

	JRadioButton buttonSlider = new JRadioButton("c != const",true);
	JRadioButton buttonTime = new JRadioButton("c == const",false);
	JButton pStart = new JButton("START");
	JButton pStop = new JButton("STOP");
	
	
	static JSlider sliderChangeC = new JSlider();
	JSlider sliderAutomaticCChange = new JSlider();

	ButtonGroup choice = new ButtonGroup();
	
	public Interface() //throws HeadlessException 
	{
		super("DeSitter Main Window");
		setSize(640,380);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

	//menu
		menuBar.add(menuFile);
		//menuBar.add(menuTools);
		menuBar.add(menuInfo);
		menuFile.add(menuItemSave);
		//menuFile.add(menuItemOpen);
		//menuTools.add(menuItemLanguage);
		//menuTools.add(menuItemTheme);
		menuInfo.add(menuItemAuthors);
		menuInfo.add(menuItemDescritption);

		setJMenuBar(menuBar);
		

		
// jeszcze nie wiem czy się jakoś przyda ten listener ale kto wie...
		MenuListener menuListener = new MenuListener()
		{
			public void menuCanceled(MenuEvent e) 
			{
				// TODO Auto-generated method stub
			}
			public void menuDeselected(MenuEvent e) 
			{
				// TODO Auto-generated method stub
			}
			public void menuSelected(MenuEvent e) 
			{
				// TODO Auto-generated method stub
			}	
		};	
		
	

	//zakładka authors
		ActionListener authors = new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Authors abcdef = new Authors();
				abcdef.setVisible(true);
			}
		};
		menuItemAuthors.addActionListener(authors);
		
		
	//zakładka help /opis
		ActionListener description = new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Help abc = new Help();
				abc.setVisible(true);
			}
		};
		menuItemDescritption.addActionListener(description);
		
		
        //final JFrame frame = new JFrame("JFileChooser Demo");
        /*
	//zakładka open
		ActionListener open = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				int retVal = fc.showOpenDialog(frame);
	        	if (retVal == JFileChooser.APPROVE_OPTION) {
	           		File[] selectedfiles = fc.getSelectedFiles();
	          		StringBuilder sb = new StringBuilder();
	            	for (int i = 0; i < selectedfiles.length; i++) {
	                	sb.append(selectedfiles[i].getName() + "\n");
	            	}
	            	JOptionPane.showMessageDialog(frame, sb.toString());
	        	}
         	}
	    };  
	    menuItemOpen.addActionListener(open);
	    */
	    
	  //zakładka save
	  	ActionListener save = new ActionListener() {
	  		public void actionPerformed(ActionEvent e) {
                //fc.showSaveDialog(pAnmation);
			    int w = Animation2.window_width;
			    int h = Animation2.window_height;
			    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			    Graphics2D g = bi.createGraphics();
			    pAnmation.print(g);
			    g.dispose();

			    File outputfile = new File("DeSitter.jpg");
				try {
					ImageIO.write(bi, "jpg", outputfile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
        }; 
        menuItemSave.addActionListener(save);

		menuFile.addMenuListener(menuListener);
		menuTools.addMenuListener(menuListener);
		menuInfo.addMenuListener(menuListener);
		
		
	//rozmieszczenie 3ch paneli
		add(pAnmation,BorderLayout.CENTER);
		add(pDescription,BorderLayout.WEST);
		add(pSettings,BorderLayout.SOUTH);
		
	//wypełnienie panelu pSLeft przyciskami i dodanie ich do grupy
		pSettings.add(pSLeft);
		//pSLeft.add(new JLabel("c != const")); 
		pSLeft.add(buttonSlider);
		//pSLeft.add(new JLabel("c == const")); 
		pSLeft.add(buttonTime);
		
		choice.add(buttonSlider);
		choice.add(buttonTime);
	
		
	//wypełnienie panelu pSRight przyciskiem START i STOP
		pSettings.add(pSRight);
		pSRight.add(pStart);
		pSRight.add(pStop);
	
		
		
	//wypełnienie panelu pSRigtSliders suwakiem
	    pSRight.add(pSRigtSliders);
		pSRigtSliders.add(sliderChangeC);
		//pSRigtSliders.add(sliderAutomaticCChange);
		pSRigtSliders.add(new JLabel("prędkośc obrotu planet")); 
		//pSRigtSliders.add(new JLabel("c zmniejsza sie z czasem")); 

		
	//ustawianie przycisku STOP	
		class StopListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	//pAnmation.setVisible(false);
		    	//System.exit(0);
		    	Animation2.stop();
		    }
		}
		pStop.addActionListener(new StopListener());
		
		
	//ustawianie przycisku START	
		class StartListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	//pAnmation.setVisible(true);
		    	Animation2.start();
		    }
		}
		pStart.addActionListener(new StartListener());	
		
	//action listenery dla radiobuttonów
		buttonSlider.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	sliderChangeC.setEnabled(true);
		    }
		});
		
		buttonTime.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	sliderChangeC.setEnabled(false);
		    	sliderChangeC.setValue(0);
		    }
		});
	
		

	}
	public static int toChange=0;

	public static void main(String[] args) 
	{
		Interface frame = new Interface();
		frame.setVisible(true);
		while(true) {
			toChange=sliderChangeC.getValue();
			try {
					Thread.sleep(100);
			} catch(InterruptedException e) { }
			frame.repaint();

		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
	}

}