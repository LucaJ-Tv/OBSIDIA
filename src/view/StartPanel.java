package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.ViewManager;
import logic.game.PlayerManager;
import logic.Manager;

public class StartPanel {
	
	//TODO: settings can be change in choose map
	private Frame frame;
	private final Manager manager;
	private ViewManager viewManager = new ViewManager();
	private GridBagConstraints gbc = new GridBagConstraints();

	private int count = 0;
	private final int NMAXPLAYER = 5;
	
	private final int bDimension = 40;
	JButton bStart;
    
	public StartPanel(Frame frame) {
		
		this.frame = frame;
		this.manager = new PlayerManager();
		
        frame.setFrameLayout(new GridBagLayout());
        
        frame.addComponent(addTitle(), gbc);
        
        frame.addComponent(addplayerPanel(), gbc);
        
        frame.addComponent(addButtonsPanel(), gbc);
        
        frame.setVisible(true);
	}
	
	private JComponent addTitle() {
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        return new Label("OBSIDIA", 80);
	}
	
	private JComponent addplayerPanel() {
		
		//panel which adds players
		JPanel playerPanel = new JPanel(new GridBagLayout());
		JButton bAddPlayer = new Button("addPlayer", bDimension);
		JLabel insert = new Label("Inserisci nome", 20);
		JTextField nameInser = new JTextField(1);
		
		//playerPanel >> bAddPlayer + isert + nameInser
        insert.setHorizontalAlignment(JLabel.CENTER);
        nameInser.setPreferredSize(new Dimension(10,20));
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        playerPanel.add(bAddPlayer, gbc);
        playerPanel.add(insert,gbc);
        playerPanel.add(nameInser, gbc);
        
        //add of a new player and write the name bottom the TextField
        bAddPlayer.addActionListener(e -> {

        	JLabel tempLabel;
        	Color tempColor;
        	if(!nameInser.getText().isBlank()) {
        		
        		tempColor = this.viewManager.getColor(count);
        		count++;
        		tempLabel = new JLabel((count) + ". " + nameInser.getText());
        		this.manager.addPlayer(nameInser.getText(), tempColor);
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
        		
        	}
        	
        	frame.validate();
        });
        
        gbc.weighty = 5;
		return playerPanel;
	}
	
	private JComponent addButtonsPanel() {
		
		//panel with buttons
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		bStart = new Button("start", bDimension);
		JButton bSettings = new Button("settings", bDimension);
		JButton bExit = new Button("exit", bDimension);
		
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
    		if(JOptionPane.showConfirmDialog(
        			frame,
        			"Are you sure to exit?",
        			"EXIT",
        			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
    			this.viewManager.exitGame();
        });
        
        gbc.weighty = 5;
        return buttonsPanel;
	}
	
}
