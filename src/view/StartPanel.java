package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.entity.EntityManager;
import logic.entity.Manager;

public class StartPanel {
	
	private final Manager manager;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private int count = 1;
	private final int NMAXPLAYER = 5;
	private List<Color> listColor = new ArrayList<>();
	private Random ran = new Random();
	private Color tempColor;
	
	//title
	private JLabel title = new JLabel("OBSIDIA");
	
	//panel which adds players
	JPanel playerPanel = new JPanel(new GridBagLayout());
	JButton bAddPlayer = createButton("addPlayer");
	JLabel insert = new JLabel("Inserisci nome");
	JTextField nameInser = new JTextField(1);
	
	//panel with buttons
	JPanel buttonsPanel = new JPanel(new GridBagLayout());
	JButton bStart = createButton("start");
	JButton bSettings = createButton("settings");
	JButton bExit = createButton("exit");
    
	public StartPanel(Frame frame) {
		//inizialise color for player
		listColor.addAll(Arrays.asList(
				new Color(200,15,15),
				new Color(200,15,150),
				new Color(50,40,235),
				new Color(30,210,210),
				new Color(10,200,30),
				new Color(240,250,20),
				new Color(250,150,30)
				));
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
        
        bAddPlayer.addActionListener(e -> {
        	//add of a new player and write the name bottom the TextField
        	JLabel lab = new JLabel((count++) + ". " + nameInser.getText());
        	try {
        		tempColor = listColor.remove(ran.nextInt(listColor.size()));
        		this.manager.insertPlayer(nameInser.getText(), tempColor);
        		lab.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        		lab.setForeground(tempColor);	
        	}catch(java.util.NoSuchElementException ex) {
        		System.out.println("Not enought color");
        		System.out.println(ex);
        		System.exit(1);
        	}
        	
        	gbc.gridwidth = GridBagConstraints.REMAINDER;
        	playerPanel.add(lab ,gbc);
        	
        	nameInser.setText("");
        	
        	//check min number of Player
        	if(count > 2) {
        		bStart.setEnabled(true);
        	}
        	
        	//check max number of Player
        	if( count > NMAXPLAYER) {
        		bAddPlayer.setEnabled(false);
        		bAddPlayer.setBackground(Color.DARK_GRAY);
        		nameInser.setEnabled(false);
        	}
        	
        	frame.validate();
        	
        });
        
        gbc.weighty = 5;
        frame.addComponent(playerPanel, gbc);
        
        bStart.setEnabled(false);

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        buttonsPanel.add(bStart,gbc);
        buttonsPanel.add(bSettings,gbc);
        buttonsPanel.add(bExit,gbc);
        
        bStart.addActionListener(e -> {
        	frame.removePanel();
        	new TurnGUI(frame);
        });
        
        bSettings.addActionListener(e -> {
        	
        });
        
        bExit.addActionListener(e -> {
        	if(JOptionPane.showConfirmDialog(
        			frame,
        			"Are you sure to exit?",
        			"EXIT",
        			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        		System.exit(0);
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
