package obsidia.entities.buildings;

public class Building {

	/**
	 * Abstract class Building
	 */
	private final int defenceLevel;
	private final int gain;
	
	public Building(final int defenceLevel, final int gain) {
		this.defenceLevel = defenceLevel;
		this.gain = gain;
	}
	
	public int getDefenceLevel() {
		return this.defenceLevel;
	}
	
	public int getGain() {
		return this.gain;
	}
}
