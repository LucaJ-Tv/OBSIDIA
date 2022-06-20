package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopFour extends AbstractCell implements Troops{

	public static final int COST = 15;
	private static final int BALANCE = -36;
	private static final int DEFENCE = 4;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	private static final int OFFENCE = 4;
	
	public TroopFour(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getCost() {
		return TroopFour.COST;
	}

	@Override
	public int getMovement() {
		return TroopFour.MOVEMENT;
	}

	@Override
	public int getOffence() {
		return TroopFour.OFFENCE;
	}

	@Override
	public int getBalance() {
		return TroopFour.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopFour.DEFENCE;
	}

	@Override
	public int getLevel() {
		return 4;
	}

}
