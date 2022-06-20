package obsidia.map;

import obsidia.utilities.Coordinates;

public interface Cells {
	
	public int getBalance();

	public int getDefence();
	
	public int getCost();
	
	public String getOwner();
	
	public Coordinates getCoordinates();

	public void setCoordinates(Coordinates pos);
	
}
