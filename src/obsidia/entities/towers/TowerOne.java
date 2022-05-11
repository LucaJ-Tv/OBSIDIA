package obsidia.entities.towers;

import obsidia.entities.EmptyCell;
import obsidia.utilities.Coordinates;

public class TowerOne extends EmptyCell implements Tower{

	private static final int COST_LV1 = 15;
	private static final int BALANCE_LV1 = -1;
	private static final int DEFENCE_LV1 = 2;
	
	public TowerOne(String ownerID, Coordinates xy) {
		super(ownerID, xy, TowerOne.BALANCE_LV1, TowerOne.DEFENCE_LV1);
	}

	@Override
	public int getCost() {
		return TowerOne.COST_LV1;
	}

	@Override
	public int getMaintenance() {
		return TowerOne.BALANCE_LV1;
	}

	@Override
	public int getDefenceLv() {
		return TowerOne.DEFENCE_LV1;
	}
	
	
}
