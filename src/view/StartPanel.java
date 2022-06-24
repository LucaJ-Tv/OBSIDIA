package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.ViewManager;
import logic.entity.EntityManager;
import logic.entity.Manager;

public class StartPanel {
	
	//TODO: settings can be change in choose map
	
	private final Manager manager;
	private ViewManager viewManager = new ViewManager();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private int count = 0;
	private final int NMAXPLAYER = 5;
	private Color tempColor;
	
	//title
	private JLabel title = new JLabel("OBSIDIA");
	
	//panel which adds players
	JPanel playerPanel = new JPanel(new GridBagLayout());
	JButton bAddPlayer = createButton("addPlayer");
	JLabel insert = new JLabel("Inserisci nome");
	JTextField nameInser = new JTextField(1);
	
	//panel with buttons
	JPanel buttonsPanel = new JPanel(new FlowLayout());
	JButton bStart = createButton("start");
	JButton bSettings = createButton("settings");
	JButton bExit = createButton("exit");
    
	public StartPanel(Frame frame) {

		this.manager = new EntityManager();
		
        frame.setFrameLayout(new GridBagLayout());
        
        //title
        title.setFont(new Font("Ink Free",Font.BOLD, 80));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        frame.addComponent(title, gbc);
        
        //playerPanel >> bAddPlayer + isert +nameInser
        insert.setHorizontalAlignment(JLabel.CENTER);
        insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        nameInser.setPreferredSize(new Dimension(10,20));
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        playerPanel.add(bAddPlayer, gbc);
        playerPanel.add(insert,gbc);
        playerPanel.add(nameInser, gbc);
        
        //add of a new player and write the name bottom the TextField
        bAddPlayer.addActionListener(e -> {

        	JLabel tempLabel;
        	if(!nameInser.getText().isBlank()) {
        		tempColor = this.viewManager.getColor(count);
        		count++;
        		tempLabel = new JLabel((count) + ". " + nameInser.getText());
        		this.manager.insertPlayer(nameInser.getText(), tempColor);
        		tempLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        		tempLabel.setForeground(tempColor);
        		
        		gbc.gridwidth = GridBagConstraints.REMAINDER;
        		playerPanel.add(tempLabel ,gbc);
        		
        		nameInser.setText("");
        		
        		//check min number of Player
        		if(count >= 2) {
        			bStart.setEnabled(true);
        		}
        		
        		//check max number of Player
        		if( count >= NMAXPLAYER) {
        			bAddPlayer.setEnabled(false);
        			bAddPlayer.setBackground(Color.DARK_GRAY);
        			nameInser.setEnabled(false);
        		}
        		
        		frame.validate();
        	}
        	
        });
        
        gbc.weighty = 5;
        frame.addComponent(playerPanel, gbc);
        
        bStart.setEnabled(false);

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        buttonsPanel.add(bStart);
        buttonsPanel.add(bSettings);
        buttonsPanel.add(bExit);
        
        bStart.addActionListener(e -> {
        	this.viewManager.moveTurn("Map2");
        });
        
        bSettings.addActionListener(e -> {
        	
        });
        
        bExit.addActionListener(e -> {
        	this.viewManager.exit();
        });
        
        gbc.weighty = 5;
        frame.addComponent(buttonsPanel, gbc);
        
        frame.setVisible(true);
	}

	//create a generic button
	private JButton createButton(String name) {
		JButton b = new JButton(name);
		b.setOpaque(true);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Ink Free",Font.BOLD, 40));
		return b;
	}
	
}
