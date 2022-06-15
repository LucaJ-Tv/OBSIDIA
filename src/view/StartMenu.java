package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class StartMenu {

	/*
	public static void main(String[] args) {
		new StartMenu();
	}
	*/
	
	int count = 1;
	Frame frame = new Frame();
	
	public StartMenu() {
		frame.add(new MenuPane());
		//frame.pack();
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
            
            JPanel playerButton = new JPanel(new GridBagLayout());
            JButton bAddPlayer = createButton("addPlayer");
            playerButton.add(bAddPlayer, gbc);
            JLabel insert = new JLabel("Inserisci nome");
            insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
            playerButton.add(insert,gbc);
            playerButton.add(new JTextArea(1,1), gbc);
            
            
            bAddPlayer.addActionListener(e -> {
            	//playerButton.add(new JLabel(count++ + "."));
            });

            gbc.weighty = 5;
            add(playerButton, gbc);
            
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
