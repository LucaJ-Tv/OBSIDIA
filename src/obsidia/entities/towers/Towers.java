package obsidia.entities.towers;

import obsidia.map.Cells;

/**
 * 
 * The interface instantiates methods common to all towers.
 * It is also useful for distinguishing the various types of entities in the map.
 * 
 * @author Tellarini Pietro
 *
 */
public interface Towers extends Cells {
	
	/**
	 * @return integer of tower's level
	 */
	public int getLevel();
	
}
