package obsidia.entities.towers;

import obsidia.entities.EmptyCell;
import obsidia.utilities.Coordinates;

public class TowerTwo extends EmptyCell implements Tower{

	private static final int COST_LV2 = 25;
	private static final int BALANCE_LV2 = -6;
	private static final int DEFENCE_LV2 = 3;

	public TowerTwo(String ownerID, Coordinates xy) {
		super(ownerID, xy, TowerTwo.BALANCE_LV2, TowerTwo.DEFENCE_LV2);
	}
	
	@Override
	public int getCost() {
		return TowerTwo.COST_LV2;
	}

	@Override
	public int getMaintenance() {
		return TowerTwo.BALANCE_LV2;
	}

	@Override
	public int getDefenceLv() {
		return TowerTwo.DEFENCE_LV2;
	}
}
