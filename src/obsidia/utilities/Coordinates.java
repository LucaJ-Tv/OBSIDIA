package obsidia.utilities;

import java.util.Set;

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
	
	public int distance(final Coordinates other) {
		final int Dx = Math.abs(other.getX() - this.getX());
		final int Dy = Math.abs(other.getY() - this.getY());
		
		if (Dx >= Dy)
			return Dx;
		else
			return Dy;
	}
	
	public Coordinates[] near(final int distance, final int mapWidth, final int mapHeight) {
		
		Set<Integer> set = Set.of(0);
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
						(nx == this.x && ny == this.y)
					) {
					cords[ni++] = new Coordinates(nx, ny);
				}
			}
		}
		return cords;
	}
	
	
}
