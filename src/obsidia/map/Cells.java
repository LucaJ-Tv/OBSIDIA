package obsidia.map;

import obsidia.utilities.Coordinates;

public interface Cells {

	public int getBalance();

	public int getDefence();
		
	public String getOwner();
	
	public Coordinates getCoordinates();

	void setCoordinates(Coordinates pos);
	
}
