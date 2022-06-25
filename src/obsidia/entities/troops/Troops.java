package obsidia.entities.troops;

import obsidia.map.Cells;

/**
 * 
 * The interface instantiates methods common to all troops.
 * It is also useful for distinguishing the various types of entities in the map.
 * 
 * @author Tellarini Pietro
 *
 */
public interface Troops extends Cells {
	
	/** 
	 * @return movement range of a troop in the map
	 */
	public int getMovement();
	
	/**
	 * @return attack level of a troop
	 */
	public int getOffence();
	
	/**
	 * @return Troop Level
	 */
	public int getLevel();
	
}
