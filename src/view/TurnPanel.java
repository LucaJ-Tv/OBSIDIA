package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Manager;
import obsidia.map.DefaultMap;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TurnPanel {

	private final Map<JButton,Coordinates> cells = new HashMap<>();
	private Manager logicManager;
	//TODO: next take height and width
	UseMap map = new UseMap();
	
	//JPanel
	JPanel mapPanel = new JPanel();
	JPanel southPanel = new JPanel(new FlowLayout());
	
	//JButton
	private final JButton troop = new JButton("TROOP");
	private final JButton tower = new JButton("TOWER");
	private final JButton farm = new JButton("FARM");
	private final JButton skip = new JButton("SKIP PLAYER >>");
	private final JButton exit = new JButton("EXIT");
	
	//JLabel
	private JLabel moneyLabel = new JLabel("MONEY:");
	//TODO: get the money from the method in CoinManager
	private JLabel money = new JLabel("10");
	private JLabel balanceLabel = new JLabel("BALANCE:");
	//TODO: get the balance from the method in CoinManager
	private JLabel balance = new JLabel("0");
	
	public TurnPanel(Frame frame) {
		new DefaultMap("Map2");
		frame.setFrameLayout(new BorderLayout());
		frame.revalidate();

		southPanel.setBackground(Color.DARK_GRAY);

		mapPanel.setLayout(new GridLayout(map.getHeight(),map.getWidth()));
		
		ActionListener actionL = e -> {
			var position = cells.get(e.getSource());
			System.out.println(position);
		};
		
        for (int i=0; i<map.getHeight(); i++){
            for (int j=0; j<map.getWidth(); j++){
                final JButton jb = new JButton(" X ");
                jb.setBackground(Color.LIGHT_GRAY);
                jb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                cells.put(jb, new Coordinates(i,j));
                mapPanel.add(jb);
                jb.addActionListener(actionL);
            }
        }
        
        troop.setBackground(Color.WHITE);
        tower.setBackground(Color.WHITE);
        farm.setBackground(Color.WHITE);
        skip.setBackground(Color.WHITE);
        exit.setBackground(Color.WHITE);
        moneyLabel.setForeground(Color.WHITE);
        money.setForeground(Color.WHITE);
        balanceLabel.setForeground(Color.WHITE);
        balance.setForeground(Color.WHITE);
        //troop.setEnabled(false);
        //tower.setEnabled(false);
        //farm.setEnabled(false);
        southPanel.add(troop);
        southPanel.add(tower);
        southPanel.add(farm);
        southPanel.add(skip);
        southPanel.add(exit);
        southPanel.add(moneyLabel);
        southPanel.add(money);
        southPanel.add(balanceLabel);
        southPanel.add(balance);
        
        frame.addComponent(mapPanel,BorderLayout.CENTER);
        frame.addComponent(southPanel,BorderLayout.SOUTH);      
    	
    	frame.setVisible(true);
	}
		
}
	/*
	@SuppressWarnings("serial")
	public class initPanel extends JPanel{

	
	
	
	public void setOnTroop(Troops c) {
		troop.setEnabled(true);
		troop.setIcon(c.getIcon());
		
		troop.addActionListener(e -> {
			logicManager.addTroop(c);
			updateBorder();
		});
	}
	
	public void setOffTroop() {
		troop.setEnabled(false);
	}
	
	public void setOnTower(Towers c) {
		tower.setEnabled(true);
		tower.setIcon(c.getIcon());
		
		tower.addActionListener(e -> {
			logicManager.addTower(c);
			updateBorder();
		});
	}
	
	public void setOffTower() {
		tower.setEnabled(false);
	}
	
	public void setOnFarm(Farm c) {
		farm.setEnabled(true);
		farm.setIcon(c.getIcon());
		
		farm.addActionListener(e -> {
			logicManager.addFarm(c);
			updateBorder();
		});
	}
	
	public void setOffFarm() {
		farm.setEnabled(false);
	}
	
	public void setBorder(boolean b, Set<Coordinates> c) {
		//TODO: set border if b is true nelle coordinates del set
	}
	
	private void updateBorder() {
		mapPanel.validate();
	}
	
	private void updateButton() {
		southPanel.validate();
	}
	


}*/
