package obsidia.entities.troops;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopThree extends AbstractCell implements Troops{

	public static final int COST = 10;
	private static final int BALANCE = -18;
	private static final int DEFENCE = 3;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	private static final int OFFENCE = 3;
	
	public TroopThree(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getCost() {
		return TroopThree.COST;
	}
	
	@Override
	public int getMovement() {
		return TroopThree.MOVEMENT;
	}

	@Override
	public int getOffence() {
		return TroopThree.OFFENCE;
	}

	@Override
	public int getBalance() {
		return TroopThree.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopThree.DEFENCE;
	}

	@Override
	public int getLevel() {
		return 3;
	}

}
