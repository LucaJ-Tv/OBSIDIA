package obsidia.entities.buildings;

import obsidia.entities.AbstractCell;
import obsidia.utilities.Coordinates;

public class Farm extends AbstractCell{
	
	/*
	 * Entity Farm
	 */
	private final int BALANCE = 6;
	private final int DEFENCE = 0;
	//private final int COST = ;

	public Farm(String ownerID, Coordinates xy) {
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
