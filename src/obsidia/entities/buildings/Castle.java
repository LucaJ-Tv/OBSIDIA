package obsidia.entities.buildings;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class Castle extends AbstractCell{

	/*
	 * Entity Castle
	 */
	private final int BALANCE = 0;
	private final int DEFENCE = 4;
	
	public Castle(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getBalance() {
		return this.BALANCE;
	}

	@Override
	public int getDefence() {
		return this.DEFENCE;
	}
}
