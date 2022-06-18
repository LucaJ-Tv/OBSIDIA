package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TurnGUI {

	
	Frame turnFrame = new Frame();
	
	public TurnGUI() {
		turnFrame.add(new turnPane());
		turnFrame.setLocationRelativeTo(null);
		turnFrame.pack();
		turnFrame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public class turnPane extends JPanel{
		
		//TODO: il pannello della mappa va importato dalla defaultMap
		JPanel mapPanel = new JPanel(new GridLayout(3,3));
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		JPanel playerInfoPanel = new JPanel(new GridBagLayout());
		
		JButton button1 = new JButton("..1..");
		JButton button2 = new JButton("..2..");
		JButton button3 = new JButton("..3..");
		
		public turnPane() {
			setLayout(new GridBagLayout());
			
			mapPanel.setBackground(Color.RED);
			mapPanel.add(button1);
			buttonsPanel.setBackground(Color.BLUE);
			buttonsPanel.add(button2);
			playerInfoPanel.setBackground(Color.GREEN);
			playerInfoPanel.add(button3);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.VERTICAL;
			
			gbc.gridx = 0;
	        gbc.gridy = 0;
			add(mapPanel,gbc);
			
			gbc.gridx = 1;
	        gbc.gridy = 0;
			add(playerInfoPanel,gbc);
			
	        gbc.gridx = 0;
	        gbc.gridy = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridwidth = 2;
			add(buttonsPanel,gbc);
		}
	}

}
