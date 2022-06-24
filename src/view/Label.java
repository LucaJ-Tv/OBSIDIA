package view;

import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel {
	
	private static final long serialVersionUID = -2433538833694309924L;

	protected Label(String name, int fontDim) {
		super(name);
		this.setFont(new Font("Ink Free",Font.BOLD, fontDim));
	}
}
