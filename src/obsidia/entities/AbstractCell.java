package obsidia.entities;

import obsidia.utilities.Coordinates;

public abstract class AbstractCell implements Cells{

	private final Coordinates xy;
	private final String ownerID;
	
	public AbstractCell(final String ownerID, final Coordinates xy) {
		this.ownerID = ownerID;
		this.xy = xy;
	}
	
	@Override
	public String getOwner() {
		return this.ownerID;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.xy;
	}
}
