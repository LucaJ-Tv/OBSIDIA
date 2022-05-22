package obsidia.entities.buildings;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

public class Castle extends AbstractCell{

	/*
	 * Entity Castle
	 */
	private final int BALANCE = 0;
	private final int DEFENCE = 4;
	//private boolean isAlive = true;
	
	public Castle(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	/*
	public boolean isAlive() {
		return this.isAlive;
	}

	public void setAlive(final boolean isAlive) {
		this.isAlive = isAlive;
	}
	*/

	@Override
	public int getBalance() {
		return this.BALANCE;
	}

	@Override
	public int getDefence() {
		return this.DEFENCE;
	}
}
