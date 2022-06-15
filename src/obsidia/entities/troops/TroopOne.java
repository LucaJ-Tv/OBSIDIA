package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopOne extends AbstractCell {

	private static final int COST = 10;
	private static final int BALANCE = -2;
	private static final int DEFENCE = 1;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopOne(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	public static int getCost() {
		return TroopOne.COST;
	}

	public static int getMovement() {
		return TroopOne.MOVEMENT;
	}

	@Override
	public int getBalance() {
		return TroopOne.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopOne.DEFENCE;
	}
	

}
