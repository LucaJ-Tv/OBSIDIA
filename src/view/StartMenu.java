package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StartMenu {

	
	public static void main(String[] args) {
		new StartMenu();
	}
	
	
	Frame frame = new Frame();
	List<String> listPlayer = new ArrayList<>();
	String strName = "";
	private int count = 1;
	private final int NMAXPLAYER = 2;
	
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
            
            JPanel playerPanel = new JPanel(new GridBagLayout());
            JButton bAddPlayer = createButton("addPlayer");
            playerPanel.add(bAddPlayer, gbc);
            JLabel insert = new JLabel("Inserisci nome");
            insert.setHorizontalAlignment(JLabel.CENTER);
            insert.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
            playerPanel.add(insert,gbc);
            JTextField nameInser = new JTextField(1);
            playerPanel.add(nameInser, gbc);
            JLabel labelPlayer = new JLabel();
            playerPanel.add(labelPlayer,gbc);
            
            bAddPlayer.addActionListener(e -> {
            	
            	listPlayer.add(nameInser.getText());
            	
            	//MODIFICA: aggiunta dei nomi in verticale e non orizzontale, altrimenti se 
            	strName += (count++ + ". " + listPlayer.get(count-2) + " ");
            	labelPlayer.setText(strName);
            	
            	nameInser.setText("");
            	if(listPlayer.size() >= NMAXPLAYER) {
            		bAddPlayer.setEnabled(false);
            		bAddPlayer.setBackground(Color.DARK_GRAY);
            		nameInser.setEnabled(false);
            	}
            	
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
