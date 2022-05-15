package obsidia.entities.troops;

import obsidia.entities.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopThree extends AbstractCell implements Troop {

	private static final int COST = 10;
	private static final int BALANCE = -18;
	private static final int DEFENCE = 3;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopThree(String ownerID, Coordinates xy, int balance, int lvDefence) {
		super(ownerID, xy, TroopThree.BALANCE, TroopThree.DEFENCE);
	}

	@Override
	public int getCost() {
		return TroopThree.COST;
	}

	@Override
	public int getMaintenance() {
		return TroopThree.BALANCE;
	}

	@Override
	public int getDefenceLv() {
		return TroopThree.DEFENCE;
	}

	@Override
	public int getMovement() {
		return TroopThree.MOVEMENT;
	}

}
