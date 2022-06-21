package logic.entity;

import obsidia.entities.cells.FreeCell;
import obsidia.entities.troops.Troops;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TroopsManager {
	
	private final UseMap mp = new UseMap();
	
	private boolean isMyBuilding(Coordinates pos, Troops troop) {
		return troop.getOwner() == mp.getOwner(pos);
	}
	
	private boolean Stronger(Coordinates pos, Troops troop) {
		return troop.getOffence() >= mp.getDefence(pos);
	}
	
	private boolean inRange (Coordinates pos, Troops troop) {
		return (pos.distance(troop.getCoordinates()) <= troop.getMovement());
		
	}

	private boolean isConquerable(Coordinates pos, Troops troop) {
		return (Stronger(pos, troop) && inRange(pos, troop) && !isMyBuilding(pos, troop));
		
	}
	
	public Coordinates[] allConquerable(Troops troop) {
		Coordinates[] cords = {null};
		int j = 0;
		for (Coordinates i : troop.getCoordinates().near(troop.getMovement(), mp.getWidth(), mp.getHeight())) {
			if(this.isConquerable(i, troop)) {
				cords[j++] = i;
			}
		}
		return cords;	
	}
	
	public void posConquest(Coordinates pos, Troops troop) {
		if (isConquerable(pos, troop)) {
			mp.moveEntity(troop, pos);
			mp.addEntity(new FreeCell(troop.getOwner(), troop.getCoordinates()));	
		}
	}
	
	
	
}
