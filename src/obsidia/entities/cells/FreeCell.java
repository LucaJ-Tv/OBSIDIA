package obsidia.entities.cells;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

/**
 * 
 * The class determines a clean Cell in the map.
 * 
 * In the game FreeCell can represent 3 different entities based on the owner:
 * ownerID == null : the cell not exist in that posizion of the map
 * ownerID == "" (empty string) : the cell it's a free terrain and can be conquest
 * ownerID == player : the cell it's a player's terrain
 * 
 * It extends the AbstractCells class and thus 
 * implements the Cells Interface and its methods 
 * not implemented by the abstract class.
 * @see Cells.java
 * 
 * @author Tellarini Pietro
 *
 */
public class FreeCell extends AbstractCell{

	private static final int DEFAUL_BALANCE = 1;
	private static final int DEFAULT_DEFENCE = 0;
	private static final int DEFAULT_COST = 0;

	public FreeCell(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}

	@Override
	public int getBalance() {
		return FreeCell.DEFAUL_BALANCE;
	}

	@Override
	public int getDefence() {
		return FreeCell.DEFAULT_DEFENCE;
	}

	@Override
	public int getCost() {
		return FreeCell.DEFAULT_COST;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon("");
	}
}
