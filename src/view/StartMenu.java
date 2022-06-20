package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import obsidia.players.Player;
import obsidia.players.PlayerList;

public class StartMenu {

	
	public static void main(String[] args) {
		new StartMenu();
	}
	
	
	Frame frame = new Frame();
	List<String> listPlayer = new ArrayList<>();
	private int count = 0;
	private final int NMAXPLAYER = 5;
	private List<Color> listColor = new ArrayList<>();
	Random ran = new Random();
	
	public StartMenu() {
		//set Frame
		frame.add(new MenuPane());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
	}
	
	@SuppressWarnings("serial")
	public class MenuPane extends JPanel {

        public MenuPane() {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            //title
            JLabel label = new JLabel("OBSIDIA");
            label.setFont(new Font("Ink Free",Font.BOLD, 80));
            add(label, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            //panel which adds players
            JPanel playerPanel = new JPanel(new GridBagLayout());
            
            JButton bAddPlayer = createButton("addPlayer");
            playerPanel.add(bAddPlayer, gbc);
            
            JLabel insert = new JLabel("Inserisci nome");
            insert.setHorizontalAlignment(JLabel.CENTER);
            insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
            playerPanel.add(insert,gbc);
            
            JTextField nameInser = new JTextField(1);
            nameInser.setPreferredSize(new Dimension(10,20));
            playerPanel.add(nameInser, gbc);
            
            bAddPlayer.addActionListener(e -> {
            	
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

            	this.validate();
            	
            });

            gbc.weighty = 5;
            add(playerPanel, gbc);
            
            gbc.anchor = GridBagConstraints.SOUTH;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 2;
            
            //panel with buttons
            JPanel buttons = new JPanel(new GridBagLayout());
            
            JButton bStart = createButton("start");
            buttons.add(bStart,gbc);
            
            JButton bSettings = createButton("settings");
            buttons.add(bSettings,gbc);
            
            JButton bExit = createButton("exit");
            buttons.add(bExit,gbc);
            
            gbc.weighty = 5;
            add(buttons, gbc);
            
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
	
}
