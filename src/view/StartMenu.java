package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private final int NMAXPLAYER = 8;
	
	public StartMenu() {
		frame.add(new MenuPane());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public class MenuPane extends JPanel {

        public MenuPane() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            JLabel label = new JLabel("OBSIDIA");
            label.setFont(new Font("Ink Free",Font.BOLD, 80));
            add(label, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            JPanel playerPanel = new JPanel(new GridBagLayout());

            //centralPanel.add(playerPanel, GridBagConstraints.CENTER);
            JButton bAddPlayer = createButton("addPlayer");
            
            playerPanel.add(bAddPlayer, gbc);
            JLabel insert = new JLabel("Inserisci nome");
            insert.setHorizontalAlignment(JLabel.CENTER);
            insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
            playerPanel.add(insert,gbc);
            JTextField nameInser = new JTextField(1);
            nameInser.setPreferredSize(new Dimension(10,40));
            playerPanel.add(nameInser, gbc);
            
            bAddPlayer.addActionListener(e -> {
            	
            	listPlayer.add(nameInser.getText());
            	Random ran = new Random();
            	
            	PlayerList plyList = new PlayerList();
            	plyList.addPlayer(new Player(nameInser.getText(), new Color(ran.nextFloat(), ran.nextFloat(), ran.nextFloat())));
            	
            	gbc.gridwidth = GridBagConstraints.REMAINDER;
            	JLabel lab = new JLabel((count +1) + ". " + nameInser.getText());
            	lab.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
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
            
            JPanel buttons = new JPanel(new GridBagLayout());
            JButton bStart = createButton("start");
            JButton bSettings = createButton("settings");
            JButton bExit = createButton("exit");
            buttons.add(bStart,gbc);
            buttons.add(bSettings,gbc);
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
            	System.exit(0);
            });
            
        }
        
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
