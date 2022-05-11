package obsidia.entities.buildings;

public class Castle extends Building{

	/*
	 * Concrete Class Castle
	 */
	private boolean isAlive;
	
	public Castle(final int defenceLevel, final int gain) {
		super(defenceLevel, gain);
		this.isAlive = true;
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}

	public void setAlive(final boolean isAlive) {
		this.isAlive = isAlive;
	}
}
