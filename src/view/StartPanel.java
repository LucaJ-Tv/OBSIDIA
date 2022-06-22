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
import javax.swing.border.EmptyBorder;

import logic.StartGame;
import obsidia.players.Player;
import obsidia.players.PlayerList;

@SuppressWarnings("serial")
public class StartPanel extends JPanel{
	
	private StartGame startGame = new StartGame();
	private Frame frame = new Frame();
	
	private int count = 0;
	private final int NMAXPLAYER = 5;
	private List<Color> listColor = new ArrayList<>();
	private Random ran = new Random();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public StartPanel() {
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
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new GridBagLayout());
        
        //title
        JLabel label = new JLabel("OBSIDIA");
        label.setFont(new Font("Ink Free",Font.BOLD, 80));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        add(label, gbc);
        
        //panel which adds players
        JPanel playerPanel = new JPanel(new GridBagLayout());
        
        JButton bAddPlayer = createButton("addPlayer");
        JLabel insert = new JLabel("Inserisci nome");
        insert.setHorizontalAlignment(JLabel.CENTER);
        insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        JTextField nameInser = new JTextField(1);
        nameInser.setPreferredSize(new Dimension(10,20));
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        playerPanel.add(bAddPlayer, gbc);
        playerPanel.add(insert,gbc);
        playerPanel.add(nameInser, gbc);
        
        bAddPlayer.addActionListener(e -> {
        	startGame.
        	//add of a new player
        	listPlayer.add(nameInser.getText());
        	PlayerList plyList = new PlayerList();
        	plyList.addPlayer(new Player(nameInser.getText(), listColor.remove(ran.nextInt(listColor.size()))));
        	
        	//write the name bottom the TextField
        	gbc.gridwidth = GridBagConstraints.REMAINDER;
        	JLabel lab = new JLabel((count +1) + ". " + nameInser.getText());
        	lab.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        	lab.setForeground(plyList.getColorIndex(count++));
        	playerPanel.add(lab ,gbc);
        	
        	nameInser.setText("");
        	if(listPlayer.size() >= NMAXPLAYER) {
        		bAddPlayer.setEnabled(false);
        		bAddPlayer.setBackground(Color.DARK_GRAY);
        		nameInser.setEnabled(false);
        	}
        	
        	if(listPlayer.size() >= 2) {
        		bStart.setEnabled(true);
        	}
        	
        	this.validate();
        	
        });
        
        gbc.weighty = 5;
        add(playerPanel, gbc);
        
        
        //panel with buttons
        JPanel buttons = new JPanel(new GridBagLayout());
        
        JButton bStart = createButton("start");
        bStart.setEnabled(false);
        JButton bSettings = createButton("settings");
        JButton bExit = createButton("exit");
        
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        buttons.add(bStart,gbc);
        buttons.add(bSettings,gbc);
        buttons.add(bExit,gbc);
        
        bStart.addActionListener(e -> {
        	frame.setVisible(false);
        	new TurnGUI();
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
        add(buttons, gbc);
        
        frame.add(this);
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
