package obsidia.entities.buildings;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class Farm extends AbstractCell{
	
	/*
	 * Entity Farm
	 */
	private final static int BALANCE = 6;
	private final static int DEFENCE = 0;
	public final static int COST = 12;

	public Farm(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getBalance() {
		return Farm.BALANCE;
	}
	@Override
	public int getDefence() {
		return Farm.DEFENCE;
	}
	
	@Override
	public int getCost() {
		return Farm.COST;
	}
	
}
