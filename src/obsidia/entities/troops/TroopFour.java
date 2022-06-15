package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopFour extends AbstractCell {

	private static final int COST = 15;
	private static final int BALANCE = -36;
	private static final int DEFENCE = 4;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopFour(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	public static int getCost() {
		return TroopFour.COST;
	}

	public static int getMovement() {
		return TroopFour.MOVEMENT;
	}

	@Override
	public int getBalance() {
		return TroopFour.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopFour.DEFENCE;
	}

}
