package logic.entity;

import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.Towers;
import obsidia.entities.troops.Troops;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class EntityManager {
	
	private final UseMap map = new UseMap();
	private final PlayerList ply = new PlayerList();
	
	public boolean matchOwner(Coordinates pos) {
		if (map.getOwner(pos) == ply.getName()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean[] whichButton(Coordinates pos) {
		
		boolean[] bools = {false, false, false};
		
		if(matchOwner(pos)) {

			if(map.getEntity(pos) instanceof Towers) {
				bools[0] = true; 							//Tower button on
			} else if(map.getEntity(pos) instanceof Troops) {
				bools[1] = true; 							//Troop button on
			} else if(map.getEntity(pos) instanceof FreeCell) {
				bools[0] = true;
				bools[1] = true;
				if(true /* Casa Limitrofa a case o Castelli*/) {
							bools[2] = true;						//Farm button on
				}
			}
		}
		return bools;
	}
	
	
	
}
