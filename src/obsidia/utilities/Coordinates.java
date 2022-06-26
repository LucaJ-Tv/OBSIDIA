package obsidia.utilities;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Tellarini Pietro
 * 
 * the class provides the positions of the cells in the map 
 * that mirror the positions in the graphical interface.
 * 
 */
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
	
	/**
	 * @return an Integer key used to access in the map (Hash map)
	 */
	public int getKey()	{
		return this.x*100+this.y;
	}
	
	/**
	 * @param p2 another Coordinate
	 * @return true if coordinates has the same values
	 */
	public boolean samePosition(Coordinates p2) {
		return this.getX() == p2.getX() && this.getY() == p2.getY();
	}
	
	/**
	 * @param other another Coordinate
	 * @return the distance between one Coordinate and given one
	 */
	public int distance(final Coordinates other) {
		final int Dx = Math.abs(other.getX() - this.getX());
		final int Dy = Math.abs(other.getY() - this.getY());
		
		if (Dx >= Dy)
			return Dx;
		else
			return Dy;
	}
	
	/**
	 * @param distance radius from Coordinate
	 * @param mapWidth width of the map
	 * @param mapHeight height of the map
	 * @return the coordinates near the coordinate at given distance in the map
	 */
	public Coordinates[] near(final int distance, final int mapWidth, final int mapHeight) {
		
		Set<Integer> set = new HashSet<>();
		Coordinates[] cords = {};
		int nx;
		int ny;
		int ni = 0;
		
		for(int i = 1; i < distance+1; i++) {
			set.add(i);
			set.add(-i);
		}
		
		for(int i : set) {
			nx = this.x + i;
			for(int j : set) {
				ny = this.y + j;
				if(		nx >= 0 &&
						nx < mapWidth &&
						ny >= 0 &&
						ny < mapHeight &&
						(nx != this.x && ny != this.y)
					) {
					cords[ni++] = new Coordinates(nx, ny);
				}
			}
		}
		return cords;
	}
	
	
}
