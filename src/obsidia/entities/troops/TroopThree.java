package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopThree extends AbstractCell {

	private static final int COST = 10;
	private static final int BALANCE = -18;
	private static final int DEFENCE = 3;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopThree(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	public static int getCost() {
		return TroopThree.COST;
	}

	public static int getMovement() {
		return TroopThree.MOVEMENT;
	}

	@Override
	public int getBalance() {
		return TroopThree.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopThree.DEFENCE;
	}

}
