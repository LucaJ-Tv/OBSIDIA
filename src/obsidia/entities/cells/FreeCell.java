package obsidia.entities.cells;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class FreeCell extends AbstractCell{

	private static final int DEFAUL_BALANCE = 1;
	private static final int DEFAULT_DEFENCE = 0;

	public FreeCell(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}

	@Override
	public int getBalance() {
		return DEFAUL_BALANCE;
	}

	@Override
	public int getDefence() {
		return DEFAULT_DEFENCE;
	}
}
