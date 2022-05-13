package obsidia.utilities;

public class Coordinates {
	private final int x;
	private final int y;
	
	public Coordinates(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "x: " + this.x  + "y: " + this.y;
	}
}
