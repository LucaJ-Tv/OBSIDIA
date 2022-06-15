package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopTwo extends AbstractCell {

	private static final int COST = 5;
	private static final int BALANCE = -6;
	private static final int DEFENCE = 2;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopTwo(String ownerID, Coordinates xy, int balance, int lvDefence) {
		super(ownerID, xy);
	}
	
	public static int getCost() {
		return TroopTwo.COST;
	}

	public static int getMovement() {
		return TroopTwo.MOVEMENT;
	}

	@Override
	public int getBalance() {
		return TroopTwo.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopTwo.DEFENCE;
	}

}
