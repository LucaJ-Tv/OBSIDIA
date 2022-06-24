package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton{
	
	private static final long serialVersionUID = -4960173395649269458L;

	protected Button(String name, int fontDim) {
		super(name);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Ink Free",Font.BOLD, fontDim));
	}
	
}
