package obsidia.entities;

import obsidia.utilities.Coordinates;
import obsidia.map.GameMap;

public class EmptyCell implements Cells{

	private final Coordinates xy;
	private final String ownerID;
	private final int balance;
	private final int defence;
	
	public EmptyCell(final String ownerID, final Coordinates xy, final int balance, final int lvDefence) {
		this.balance = balance;
		this.ownerID = ownerID;
		this.xy = xy;
		this.defence = lvDefence;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}
	
	@Override
	public int getDefence() {
		return this.defence;
	}
	
	@Override
	public String getOwner() {
		return this.ownerID;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.xy;
	}
}
