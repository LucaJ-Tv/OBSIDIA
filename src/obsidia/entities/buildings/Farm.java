package obsidia.entities.buildings;

import obsidia.utilities.Coordinates;

public class Farm extends AbstractCell{
	
	/*
	 * Concrete Class Farm
	 */

	public Farm(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	/*
	@Override
	public int getBalance() {
		return 6;
	}
	*/

	@Override
	public int getDefence() {
		return 0;
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBalace() {
		// TODO Auto-generated method stub
		return 0;
	}
}
