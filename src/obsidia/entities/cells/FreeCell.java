package obsidia.entities.cells;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class FreeCell extends AbstractCell{

	private static final int DEFAUL_BALANCE = 1;
	private static final int DEFAULT_DEFENCE = 0;
	private static final int DEFAULT_COST = 0;

	public FreeCell(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}

	@Override
	public int getBalance() {
		return FreeCell.DEFAUL_BALANCE;
	}

	@Override
	public int getDefence() {
		return FreeCell.DEFAULT_DEFENCE;
	}

	@Override
	public int getCost() {
		return FreeCell.DEFAULT_COST;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon("");
	}
}
