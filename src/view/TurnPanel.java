package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import logic.TurnManager;
import logic.Manager;
import logic.StartEndManager;
import logic.entity.*;
import logic.game.*;
import obsidia.utilities.Coordinates;

public class TurnPanel {

	private final Map<JButton,Coordinates> cells = new HashMap<>();
	private Frame frame = StartEndManager.frame;
	private TurnManager turnManager = new TurnManager();
	private FarmManager farmManager = new FarmManager();
	private TowerManager towerManager = new TowerManager();
	//TODO: is Troops or Troop
	private Manager troopManager = new TroopsManager();
	private PlayerManager playerManager = new PlayerManager();
	private MapManager mapManager = new MapManager();
	
	private JPanel mapPanel;
	private JPanel southPanel;
	private JButton troop;
	private JButton tower;
	private JButton farm;
	private JButton skip;
	private JButton exit;
	private JLabel namePlayer = new Label("", 35);
	private final int bDimension = 20;
	private final int lDimension = 20;
	//private Coordinates position;
	
	public TurnPanel() {
		
		frame.setFrameLayout(new BorderLayout());
        
        frame.addComponent(addMapPanel(),BorderLayout.CENTER);
        frame.addComponent(addSouthPanel(),BorderLayout.SOUTH);      
    	
    	frame.setVisible(true);
	}
	
	private JComponent addMapPanel() {
		
		//TODO: prende riga e colonna nulli
		mapPanel = new JPanel(new GridLayout(mapManager.mapHeight(),mapManager.mapWidth()));
		mapPanel.setBorder(new EmptyBorder(2,2,2,2));
		
		ActionListener actionL = e -> {
			System.out.println(e.getSource());
			
			
			//controlla se la posizione cliccata � del Player corrente
			if(this.mapManager.setClickedPosition(cells.get(e.getSource()))) {
				
				this.troop.setEnabled(this.troopManager.button());
				this.tower.setEnabled(this.towerManager.button());
				this.farm.setEnabled(this.farmManager.button());
				southPanel.validate();
				

				//setBorder(this.troopManager.borderActivate());
				
			}
		};
		
		//create and add button in the Map cells
        for (int i=0; i<mapManager.mapHeight(); i++){
            for (int j=0; j<mapManager.mapWidth(); j++){
                final JButton jb = new JButton();
                //TODO: non mostra i castelli
                if(this.mapManager.isEnableCell(new Coordinates(i,j))) {
                	jb.setVisible(false);
                }else {
                	jb.setIcon(new ImageIcon(
                			this.mapManager.iconCell(new Coordinates(i,j))
                			.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
                	jb.setBackground(this.mapManager.colorCell(new Coordinates(i,j)));
                	jb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                	jb.addActionListener(actionL);
                }
                mapPanel.add(jb);
                cells.put(jb, new Coordinates(i,j));
            }
        }
		
		return mapPanel;
	}
	
	private JComponent addSouthPanel() {
		
		southPanel = new JPanel(new FlowLayout());
		southPanel.setBackground(Color.DARK_GRAY);
		
		//JButton
		troop = new Button("TROOP", bDimension);
		tower = new Button("TOWER", bDimension);
		farm = new Button("FARM",bDimension);
		skip = new Button("SKIP PLAYER >>", bDimension);
		exit = new Button("END GAME", bDimension);
		
		//JLabel
		final JLabel moneyLabel = new Label("MONEY:", lDimension);
		JLabel money;
		final JLabel balanceLabel = new Label("BALANCE:", lDimension);
		JLabel balance;
		
		//TODO: get the money from the method in CoinManager
		money = new Label("5", lDimension);
		//TODO: get the balance from the method in CoinManager
		balance = new Label("0", lDimension);
        
		setNamePlayer();
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		troop.setBorder(border);
        tower.setBorder(border);
        farm.setBorder(border);
        skip.setBorder(border);
        exit.setBorder(border);
        moneyLabel.setForeground(Color.WHITE);
        money.setForeground(Color.WHITE);
        balanceLabel.setForeground(Color.WHITE);
        balance.setForeground(Color.WHITE);
        
        troop.setEnabled(false);
        tower.setEnabled(false);
        farm.setEnabled(false);
        
        southPanel.add(namePlayer);
        southPanel.add(Box.createHorizontalStrut(50));
        southPanel.add(troop);
        southPanel.add(tower);
        southPanel.add(farm);
        southPanel.add(skip);
        southPanel.add(exit);
        southPanel.add(Box.createHorizontalStrut(30));
        southPanel.add(moneyLabel);
        southPanel.add(money);
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(balanceLabel);
        southPanel.add(balance);
        
        troop.addActionListener(e -> {
			this.troopManager.newEntity();
			mapPanel.validate();
		});
        
        tower.addActionListener(e -> {
			this.towerManager.newEntity();
			mapPanel.validate();
		});
        
        farm.addActionListener(e -> {
			this.farmManager.newEntity();
			mapPanel.validate();
        	
		});
        
        skip.addActionListener(e -> {
        	this.playerManager.nextPlayer();
        	this.playerManager.coinTurnUpdate();
        	setNamePlayer();
        	
        });
        
        exit.addActionListener(e -> {
        	if(JOptionPane.showConfirmDialog(
        			frame,
        			"Quit the game ?",
        			"ENDGAME",
        			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        		this.turnManager.moveEnd();
        });
		
		return southPanel;
	}
	
	private void setNamePlayer() {
		namePlayer.setText(this.playerManager.namePlayer());
		namePlayer.setForeground(this.playerManager.colorPlayer());
	}
	
	public void setBorder(Set<Coordinates> c) {
		System.out.println(c.toString());
		this.cells.forEach((b,p) -> {
			b.setBorder( c.contains(p) ? 
					BorderFactory.createLineBorder(Color.RED, 5) :
					BorderFactory.createLineBorder(Color.BLACK, 1));
		});
		
		/*c.forEach(v -> this.cells.);*/
	}
}
