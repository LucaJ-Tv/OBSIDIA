package logic.troop;

import obsidia.entities.cells.FreeCell;
import obsidia.entities.troops.Troops;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TroopMovement {
	
	private final UseMap mp = new UseMap();
	
	private boolean Stronger(Coordinates pos, Troops troop) {
		return troop.getOffence() >= mp.getDefence(pos);
	}
	
	private boolean inRange (Coordinates pos, Troops troop) {
		return (pos.distance(troop.getCoordinates()) <= troop.getMovement());
		
	}

	public boolean isConquerable(Coordinates pos, Troops troop) {
		return (Stronger(pos, troop) && inRange(pos, troop));
		
	}
	
	public void posConquest(Coordinates pos, Troops troop) {
		if (isConquerable(pos, troop)) {
			
			mp.addEntity(new FreeCell(troop.getOwner(), troop.getCoordinates()));
			mp.moveEntity(troop, pos);
			
			
		}
	}
	
}
