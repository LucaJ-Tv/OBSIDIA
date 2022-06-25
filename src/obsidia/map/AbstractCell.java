package obsidia.map;

import java.nio.file.Path;

import obsidia.utilities.Coordinates;

/**
 * The abstract class provides the implementation of the same methods 
 * for all the Cells of the map and keeps the relative fields of the 
 * owner and of the position
 * 
 * @author Tellarini Pietro
 *
 */
public abstract class AbstractCell implements Cells {

	private Coordinates xy;
	private final String ownerID;
	public static final Path PATH = Path.of("data");
	
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
	
	@Override
	public void setCoordinates(Coordinates pos) {
		this.xy = pos;
	}
	
	
}
