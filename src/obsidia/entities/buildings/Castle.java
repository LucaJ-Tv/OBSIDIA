package obsidia.entities.buildings;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class Castle extends AbstractCell{

	/*
	 * Entity Castle
	 */
	private static final int BALANCE = 0;
	private static final int DEFENCE = 4;
	public static final int COST = 0;
	
	public Castle(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getBalance() {
		return Castle.BALANCE;
	}

	@Override
	public int getDefence() {
		return Castle.DEFENCE;
	}

	@Override
	public int getCost() {
		return Castle.COST;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "castle.png");
	}
}
