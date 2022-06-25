package obsidia.map;

import javax.swing.ImageIcon;

import obsidia.utilities.Coordinates;

/**
 * The interface provides the functions 
 * that the game map entities must have
 * 
 * @author Tellarini Pietro
 *
 */
public interface Cells {
	
	/**
	 * @return the cost or gain of a cell each turn
	 */
	public int getBalance();

	/**
	 * @return Defence level of a Cell
	 */
	public int getDefence();
	
	/**
	 * @return Start cost of a Cell
	 */
	public int getCost();
	
	/**
	 * @return name of  the owner Player
	 * @see Player.java
	 */
	public String getOwner();
	
	/**
	 * @return Coordinates of a Cell
	 * @see Coordinates.java
	 */
	public Coordinates getCoordinates();

	/**
	 * Update the Coordinate of a Cell
	 * @param pos new Coordinates to insert
	 */
	public void setCoordinates(Coordinates pos);
	
	/**
	 * @return ImageIcon of the cell
	 */
	public ImageIcon getIcon();
	
}
