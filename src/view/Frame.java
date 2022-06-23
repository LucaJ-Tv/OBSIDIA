package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frame extends JFrame{

	private static final long serialVersionUID = 2066419076195637796L;
	private final int PROPORTION_M = 3;
	private final int PROPORTION_D = 4;

	public Frame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("OBSIDIA");
		
		//set dimension and position of the frame
		final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		final int sw = (int) screen.getWidth();
		final int sh = (int) screen.getHeight();
		setSize(sw * PROPORTION_M / PROPORTION_D, sh * PROPORTION_M / PROPORTION_D);
		setLocationRelativeTo(null);
		setMaximumSize(screen);
		setMinimumSize(new Dimension(sw / 2, sh / 2));
		
		setLocationRelativeTo(null);
	}
	
	public void setFrameLayout(LayoutManager layout) {
		this.setLayout(layout);
	}
	
	public void addComponent(JComponent comp, String position) {
		this.add(comp,position);
	}
	
	public void addComponent(JComponent comp, GridBagConstraints position) {
		this.add(comp,position);
	}
}
