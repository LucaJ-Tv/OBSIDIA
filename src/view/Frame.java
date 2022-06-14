package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	private final int PROPORTION_M = 3;
	private final int PROPORTION_D = 4;
	//JFrame frame = new JFrame();
	
	
	public Frame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("OBSIDIA");
		
		//set dimension and position of the frame
		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int sw = (int) screen.getWidth();
		final int sh = (int) screen.getHeight();
		this.setSize(sw * PROPORTION_M / PROPORTION_D, sh * PROPORTION_M / PROPORTION_D);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(screen);
		this.setMinimumSize(new Dimension(sw / 2, sh / 2));
		
		/* --how use the method addPanel
		JPanel panel1 = new JPanel();
		panel1.add(new JButton("Ciao"));
		JPanel panel2 = new JPanel();
		panel2.add(new JButton("fff"));

		addPanel(panel2,BorderLayout.EAST);
		addPanel(panel1,BorderLayout.SOUTH);
		*/
		
		this.setVisible(true);
	}
	
	public void addPanel(JPanel panel, String position) {
		this.add(panel,position);
	}
	
}
