package obsidia.entities.troops;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

/**
 * 
 * The class determines a level 2 troop.
 * It extends the AbstractCells class and thus 
 * implements the Cells Interface and its methods 
 * not implemented by the abstract class.
 * @see Cells.java
 * @see Troops.java
 * 
 * @author Tellarini Pietro
 *
 */
public class TroopTwo extends AbstractCell implements Troops{

	public static final int COST = 5;
	private static final int BALANCE = -6;
	private static final int DEFENCE = 2;
	private static final int MOVEMENT = 4; //For a possible Troop that can move more than 4 cells
	private static final int OFFENCE = 2;
	
	public TroopTwo(String ownerID, Coordinates xy) {
		super(ownerID, xy);
	}
	
	@Override
	public int getCost() {
		return TroopTwo.COST;
	}

	@Override
	public int getMovement() {
		return TroopTwo.MOVEMENT;
	}

	@Override
	public int getOffence() {
		return TroopTwo.OFFENCE;
	}


	@Override
	public int getBalance() {
		return TroopTwo.BALANCE;
	}

	@Override
	public int getDefence() {
		return TroopTwo.DEFENCE;
	}

	@Override
	public int getLevel() {
		return 2;
	}
	
	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "troop2.png");
	}

}
