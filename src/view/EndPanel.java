package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Manager;
import logic.ViewManager;

public class EndPanel {
	
	private final Frame frame ;
	private Manager logic;
	private ViewManager viewManager = new ViewManager();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public EndPanel(Frame frame) {
		this.frame = frame;
		setFrame();		
	}
	
	private void setFrame() {
		
		this.frame.setVisible(false);
		this.frame.getContentPane().removeAll();
		this.frame.setFrameLayout(new GridBagLayout());
		
		gbc.weighty = 1;
		
		addTitLabel();
		addWinPanel();
		addButPanel();
		
		this.frame.validate();
		this.frame.setVisible(true);
	}
	
	private void addTitLabel() {
		
		Label titLabel = new Label("OBSIDIA", 80);
        
		this.gbc.anchor = GridBagConstraints.NORTH;
		this.gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.frame.addComponent(titLabel, gbc);
	}
	
	
	private void addWinPanel() {
		
		JPanel winPanel = new JPanel();
		Label winLabel;

		winLabel = new Label(logic.winner(), 60);
		winPanel.add(winLabel);
		
		winLabel = new Label(" WIN!", 60);
		winPanel.add(winLabel);
		
		winPanel.setBackground(Color.yellow);
		
		this.gbc.anchor = GridBagConstraints.CENTER;
		this.gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.frame.addComponent(winPanel, gbc);
		
	}
	
	private void addButPanel() {

		JPanel butPanel = new JPanel();
	    Button but;
	     
	    but = new Button("Play Again", 40);
		butPanel.add(but);
		playAgainPerformer(but);
		
		but = new Button("New Game", 40);
		butPanel.add(but);
		newGamePerformer(but);
		
		but = new Button("Exit", 40);
		butPanel.add(but);
		exitPerformer(but);
		
		this.gbc.anchor = GridBagConstraints.SOUTH;
		frame.addComponent(butPanel, gbc);
		
	}
	
	private void playAgainPerformer(Button plyAgain) {
		plyAgain.addActionListener(e -> {
			this.viewManager.inizGame(false);
		});
	}
	
	private void newGamePerformer(Button newGame) {
		newGame.addActionListener(e ->{
			this.viewManager.inizGame(true);
		});
	}
	
	private void exitPerformer(Button exit) {
		exit.addActionListener(e ->{
			if(JOptionPane.showConfirmDialog(
        			frame,
        			"Are you sure to exit?",
        			"EXIT",
        			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        		this.viewManager.exitGame();
		});
	}
	

}
