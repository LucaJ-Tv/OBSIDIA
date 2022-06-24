package obsidia.map;

import java.util.HashMap;
import java.util.Map;

import obsidia.entities.buildings.Farm;
import obsidia.entities.cells.FreeCell;
import obsidia.utilities.Coordinates;

/**
 * 
 * @author Tellarini Pietro
 *
 * The class creates and manages the game map. 
 * The map is a hash map where the key is an integer 
 * while the value it's a Cell
 * @see Cells.java
 * @see Coordinates.java
 * 
 */
public class GameMap {
	
	private static Map<Integer, Cells> MAP = new HashMap<Integer, Cells>();
	private static int HEIGHT = 0;
	private static int WIDTH = 0;
	
	/** 
	 * @param height of the map (matrix)
	 * @param width of the map (matrix)
	 * Set dimension of the map	
	 */
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
	
	/**
	 * @param entity it's a Cells (troup, castle, tower, farm, FreeCell)
	 * Add an entity at the map with the given key
	 */
	public void addEntity(final Cells entity) {
		GameMap.MAP.put(entity.getCoordinates().getKey(), entity);
	}
	
	/**
	 * @param entity
	 * @param pos
	 * Change the position of the new entity 
	 * an puts it into the map
	 */
	public void moveEntity(final Cells entity, Coordinates pos) {
		entity.setCoordinates(pos);
		GameMap.MAP.replace(pos.getKey(), entity);
	}
	
	/**
	 * @param xy Coordinates
	 * @return Defence of the cell at given position
	 */
	public int getDefence(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey()).getDefence();
	}

	/**
	 * @param xy Coordinates
	 * @return name of Player's cell at given position
	 */
	public String getOwner(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey()).getOwner();
	}
	
	/**
	 * @param xy Coordinates
	 * @return The cell at given position
	 */
	public Cells getEntity(final Coordinates xy) {
		return GameMap.MAP.get(xy.getKey());
	}
	
	/**
	 * @param ID name of Player
	 * Remove all the cell of a player and replace them 
	 * with a FreeCell with no Owner
	 */
	public void removePlayer(final String ID) {
		for (var i : GameMap.MAP.values()) {
			if(i.getOwner() == ID) {
				GameMap.MAP.replace(i.getCoordinates().getKey(), new FreeCell("", i.getCoordinates()));
			}
		}
	}
	
	/**
	 * @param ID name of Player
	 * @return the number of farms of a Player built in the map
	 */
	public int numberFarm(final String ID) {
		int num = 0;
		for ( final Cells i : GameMap.MAP.values() ) {
			if(i instanceof Farm && i.getOwner() == ID) {
				num ++;
			}
		}
		return num;		
	}
	
	/**
	 * @param ID name of Player
	 * @return the balance of the Cells of a Player
	 */
	public int getIdBalance(final String ID){
		int balance = 0;
		for ( final var i : GameMap.MAP.values() ) {
			if(i.getOwner() == ID) {
				balance += i.getBalance();
			}
		}
		return balance;
	}
	
	/**
	 * Remove everything from the map (map clear)
	 */
	public void cleanMap() {
		MAP.clear();
	}

}
