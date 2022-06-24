package obsidia.map;

import java.util.HashMap;
import java.util.Map;

import obsidia.entities.buildings.Farm;
import obsidia.entities.cells.FreeCell;
import obsidia.utilities.Coordinates;

public class GameMap {
	
	private static Map<Integer, Cells> MAP = new HashMap<Integer, Cells>();
	private static int HEIGHT = 0;
	private static int WIDTH = 0;
	
	public void setDimension(final int height, final int width) {
		GameMap.HEIGHT = height;
		GameMap.WIDTH = width;
	}
	
	public int getWidth() {
		return GameMap.WIDTH;
	}
	
	public int getHeight() {
		return GameMap.HEIGHT;
	}
	
	public void addEntity(final Cells entity) {
		GameMap.MAP.put(entity.getCoordinates().getKey(), entity);
	}
	
	//TODO that's not completely correct, tecnically only troup colud change position so
	// the field position in Abstract cell shuld be final (but not for troop....)
	public void moveEntity(final Cells entity, Coordinates pos) {
		entity.setCoordinates(pos);
		GameMap.MAP.replace(pos.getKey(), entity);
	}
	
	public int getDefence(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey()).getDefence();
	}

	public String getOwner(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey()).getOwner();
	}
	
	public Cells getEntity(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey());
	}
	
	public int getBalance(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey()).getBalance();
	}
	
	public void removePlayer(final String ID) {
		for (var i : GameMap.MAP.values()) {
			if(i.getOwner() == ID) {
				GameMap.MAP.replace(i.getCoordinates().getKey(), new FreeCell("", i.getCoordinates()));
			}
		}
	}
	
	public int numberFarm(final String ID) {
		int num = 0;
		for ( final Cells i : GameMap.MAP.values() ) {
			if(i instanceof Farm && i.getOwner() == ID) {
				num ++;
			}
		}
		return num;		
	}
	
	public int getIdBalance(final String ID){
		int balance = 0;
		for ( final var i : GameMap.MAP.values() ) {
			if(i.getOwner() == ID) {
				balance += i.getBalance();
			}
		}
		return balance;
	}
	
	public void cleanMap() {
		MAP.clear();
	}

}
