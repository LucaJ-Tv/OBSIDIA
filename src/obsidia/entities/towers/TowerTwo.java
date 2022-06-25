package obsidia.entities.towers;

import java.io.File;

import javax.swing.ImageIcon;

import obsidia.map.AbstractCell;
import obsidia.utilities.Coordinates;

/**
 * 
 * The class determines a level 2 tower.
 * It extends the AbstractCells class and thus 
 * implements the Cells Interface and its methods 
 * not implemented by the abstract class.
 * @see Cells.java
 * @see Towers.java
 * 
 * @author Tellarini Pietro
 *
 */
public class TowerTwo extends AbstractCell implements Towers{

	public static final int COST_LV2 = 25;
	private static final int BALANCE_LV2 = -6;
	private static final int DEFENCE_LV2 = 3;

	public TowerTwo(String Player, Coordinates xy) {
		super(Player, xy);
	}
	
	@Override
	public int getCost() {
		return TowerTwo.COST_LV2;
	}
	
	@Override
	public int getBalance() {
		return TowerTwo.BALANCE_LV2;
	}
	
	@Override
	public int getDefence() {
		return TowerTwo.DEFENCE_LV2;
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(PATH + File.separator + "tower2.png");
	}
}
