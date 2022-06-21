package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import obsidia.map.DefaultMap;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TurnGUI {

	private Frame turnFrame = new Frame();
	private final Map<JButton,Coordinates> cells = new HashMap<>();
	
	public TurnGUI() {
		UseMap map = new UseMap();
		new DefaultMap("Map2");
		
		turnFrame.add(new turnPane(map.getHeight(),map.getWidth()));
		turnFrame.setLocationRelativeTo(null);
		turnFrame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public class turnPane extends JPanel{
		
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
		
		public turnPane(int height, int width) {
			setLayout(new BorderLayout());
			southPanel.setBackground(Color.DARK_GRAY);

			mapPanel.setLayout(new GridLayout(height,width));
			
	        for (int i=0; i<height; i++){
	            for (int j=0; j<width; j++){
	                final JButton jb = new JButton(" X ");
	                jb.setBackground(Color.LIGHT_GRAY);
	                cells.put(jb, new Coordinates(i,j));
	                mapPanel.add(jb);
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
		
		public void setTroop(boolean b) {
			troop.setEnabled(b);
		}
		
		public void setTower(boolean b) {
			tower.setEnabled(b);
		}
		
		public void setFarm(boolean b) {
			farm.setEnabled(b);
		}
		
		public void setBorder() {
			//tower.setBorder();
		}
		
		public void updateBorder() {
			mapPanel.validate();
		}
		
		public void updateButton() {
			southPanel.validate();
		}
		
	}


}
