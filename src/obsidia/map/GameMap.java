package obsidia.map;

import java.util.HashMap;
import java.util.Map;

import obsidia.entities.Cells;
import obsidia.utilities.Coordinates;

public class GameMap {
	
	private final Map<Coordinates, Cells> GameMap = new HashMap<>();
	
	public void addEntity(final Cells entity) {
		GameMap.put(entity.getCoordinates(), entity);
	}
	
	public int getDefence(final Coordinates xy) {
		return GameMap.get(xy).getDefence();
	}

	public String getOwner(final Coordinates xy) {
		return GameMap.get(xy).getOwner();
	}
	
	public Class<? extends Cells> getEntity(final Coordinates xy) {
		return GameMap.get(xy).getClass();
	}
	
	public int getBalance(final Coordinates xy) {
		return GameMap.get(xy).getBalance();
	}
	
	public int getIdBalance(final String ID){
		int balance = 0;
		for ( final var i : GameMap.values() ) {
			if(i.getOwner() == ID) {
				balance += i.getBalance();
			}
		}
		return balance;
	}

}
