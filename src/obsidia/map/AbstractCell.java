package obsidia.map;

import java.nio.file.Path;

import obsidia.utilities.Coordinates;

public abstract class AbstractCell implements Cells {

	private Coordinates xy;
	private final String ownerID;
	public static final Path PATH = Path.of("data");
	
	public AbstractCell(final String ownerID, final Coordinates xy) {
		this.ownerID = ownerID;
		this.xy = xy;
		//UseMap.addEntity(this);
	}
	
	@Override
	public String getOwner() {
		return this.ownerID;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.xy;
	}
	
	@Override
	public void setCoordinates(Coordinates pos) {
		this.xy = pos;
	}
	
	
}
