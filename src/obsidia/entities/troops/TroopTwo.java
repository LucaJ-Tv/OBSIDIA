package obsidia.entities.troops;

import obsidia.entities.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopTwo extends AbstractCell implements Troop {

	private static final int COST = 5;
	private static final int BALANCE = -6;
	private static final int DEFENCE = 2;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopTwo(String ownerID, Coordinates xy, int balance, int lvDefence) {
		super(ownerID, xy, TroopTwo.BALANCE, TroopTwo.DEFENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		return TroopTwo.COST;
	}

	@Override
	public int getMaintenance() {
		return TroopTwo.BALANCE;
	}

	@Override
	public int getDefenceLv() {
		return TroopTwo.DEFENCE;
	}

	@Override
	public int getMovement() {
		return TroopTwo.MOVEMENT;
	}

}
