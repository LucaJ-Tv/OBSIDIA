package obsidia.entities.troops;

import obsidia.entities.AbstractCell;
import obsidia.utilities.Coordinates;

public class TroopFour extends AbstractCell implements Troop {

	private static final int COST = 15;
	private static final int BALANCE = -36;
	private static final int DEFENCE = 4;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopFour(String ownerID, Coordinates xy, int balance, int lvDefence) {
		super(ownerID, xy, TroopFour.BALANCE, TroopFour.DEFENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		return TroopFour.COST;
	}

	@Override
	public int getMaintenance() {
		return TroopFour.BALANCE;
	}

	@Override
	public int getDefenceLv() {
		return TroopFour.DEFENCE;
	}

	@Override
	public int getMovement() {
		return TroopFour.MOVEMENT;
	}

}
