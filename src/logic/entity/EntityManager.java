package logic.entity;

import logic.troop.TroopMovement;
import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.*;
import obsidia.entities.troops.*;
import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class EntityManager {
	
	private final UseMap map = new UseMap();
	private final PlayerList ply = new PlayerList();
	private final TroopMovement tp = new TroopMovement();
	private Cells oldPos;
	
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
	
	
	
	public void OnPress(Coordinates pos) {
		if(matchOwner(pos)) {
			
			this.oldPos = map.getEntity(pos);

			if(this.oldPos instanceof Towers) {
				towerOnPress();
			} else if(this.oldPos instanceof Troops) {
				troopOnPress(pos);						
			} else if(this.oldPos instanceof FreeCell) {
				cellOnPress(pos);
			}
		}
	}
	
	public void OnRelease(Coordinates pos) {
		if (pos.samePosition(oldPos.getCoordinates()) && oldPos instanceof Troops) {
			troopOnRelease(pos);
		}
	}
	
	
	private void troopOnPress(Coordinates pos) {
		//Chiamare GUI e Colorare bordo  celle accessibili
		Coordinates[] cors = tp.allConquerable((Troops)map.getEntity(pos));
		for(var i : cors) {
			//TODO COLORE BORDO IN POS i
		}
		// TurnGUI.troopButton(Troops)
	}
	
	private void towerOnPress() {
		//Attivare tower Button con livello Torre
	}
	
	public void towerButton()	{
		if (oldPos instanceof FreeCell) {
			map.addEntity(new TowerOne(oldPos.getOwner(), oldPos.getCoordinates()));			
		} else if (oldPos instanceof TowerOne) {
			map.addEntity(new TowerTwo(oldPos.getOwner(), oldPos.getCoordinates()));	
		}
	}
	
	public void troopButton() {
		if (oldPos instanceof FreeCell) {
			map.addEntity(new TroopOne(oldPos.getOwner(), oldPos.getCoordinates()));	
			
		} else if(oldPos instanceof TroopOne) {
			map.addEntity(new TroopTwo(oldPos.getOwner(), oldPos.getCoordinates()));	
			
		} else if(oldPos instanceof TroopTwo) {
			map.addEntity(new TroopThree(oldPos.getOwner(), oldPos.getCoordinates()));	
			
		} else if(oldPos instanceof TroopThree) {
			map.addEntity(new TroopFour(oldPos.getOwner(), oldPos.getCoordinates()));	
		} 
	}
	
	private void cellOnPress(Coordinates pos) {
		//Attivare tower, troop, farm (solo se vicine)
	}
	
	
	
	
	
	private void troopOnRelease(Coordinates pos) {
		Coordinates[] cors = tp.allConquerable((Troops)map.getEntity(pos));
		for(var i : cors) {
			//TODO DISATTIVA COLORE BORDO IN POS i
		}
		
		if(!oldPos.equals(pos)) {
			tp.posConquest(pos, (Troops)map.getEntity(pos));
		}
	}
	
	
}
