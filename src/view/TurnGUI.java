package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.entity.EntityManager;
import obsidia.entities.buildings.Farm;
import obsidia.entities.towers.Towers;
import obsidia.entities.troops.Troops;
import obsidia.map.DefaultMap;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TurnGUI {

	private Frame turnFrame = new Frame();
	private final Map<JButton,Coordinates> cells = new HashMap<>();
	private EntityManager logicManager = new EntityManager();
	
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
	private JLabel money = new JLabel("10");
	private JLabel balanceLabel = new JLabel("BALANCE:");
	private JLabel balance = new JLabel("0");
	
	public TurnGUI() {
		UseMap map = new UseMap();
		new DefaultMap("Map2");
		
		turnFrame.add(new initPanel(map.getHeight(),map.getWidth()));
		turnFrame.setLocationRelativeTo(null);
		turnFrame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public class initPanel extends JPanel{
		
		public initPanel(int height, int width) {
			setLayout(new BorderLayout());
			southPanel.setBackground(Color.DARK_GRAY);

			mapPanel.setLayout(new GridLayout(height,width));
			
	        for (int i=0; i<height; i++){
	            for (int j=0; j<width; j++){
	                final JButton jb = new JButton(" X ");
	                jb.setBackground(Color.LIGHT_GRAY);
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
	        southPanel.add(troop);
	        southPanel.add(tower);
	        southPanel.add(farm);
	        southPanel.add(skip);
	        southPanel.add(exit);
	        southPanel.add(moneyLabel);
	        southPanel.add(money);
	        southPanel.add(balanceLabel);
	        southPanel.add(balance);
	        
	        add(mapPanel,BorderLayout.CENTER);
	        add(southPanel,BorderLayout.SOUTH);
		}
			
	}
	
	ActionListener actionL = e -> {
		var position = cells.get(e.getSource());
		this.logicManager.OnPress(position);
		updateButton();
	};
	
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


}
