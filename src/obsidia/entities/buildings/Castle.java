package obsidia.entities.buildings;

import obsidia.utilities.Coordinates;

public class Castle extends AbstractCell{

	/*
	 * Concrete Class Castle
	 */
	private boolean isAlive = true;
	
	public Castle(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	/*public Castle(String ownerID, Coordinates xy) {
		//super(ownerID, xy, 3, 5);
		this.isAlive = true;
	}*/
	
	public boolean isAlive() {
		return this.isAlive;
	}

	public void setAlive(final boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public int getBalance() {
		return 0;
	}

	@Override
	public int getDefence() {
		return 4;
	}
}
