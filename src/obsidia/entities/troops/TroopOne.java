package obsidia.entities.troops;

import obsidia.entities.EmptyCell;
import obsidia.utilities.Coordinates;

public class TroopOne extends EmptyCell implements Troop {

	private static final int COST = 10;
	private static final int BALANCE = -2;
	private static final int DEFENCE = 1;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	
	public TroopOne(String ownerID, Coordinates xy) {
		super(ownerID, xy, TroopOne.BALANCE , TroopOne.DEFENCE);
	}
	
	@Override
	public int getCost() {
		return TroopOne.COST;
	}

	@Override
	public int getMaintenance() {
		return TroopOne.BALANCE;
	}

	@Override
	public int getDefenceLv() {
		return TroopOne.DEFENCE;
	}

	@Override
	public int getMovement() {
		return TroopOne.MOVEMENT;
	}

}
