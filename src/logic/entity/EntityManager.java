package logic.entity;

import obsidia.entities.buildings.Farm;
import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.*;
import obsidia.entities.troops.*;
import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;
import view.TurnGUI;

public class EntityManager {
	
	private final UseMap map = new UseMap();
	private final PlayerList ply = new PlayerList();
	private final TroopsManager trm = new TroopsManager();
	private final TowerManager twm = new TowerManager();
	private final FarmManager frm = new FarmManager();
	private final TurnGUI GUI = new TurnGUI();
	
	private Cells oldEntity;
	
	private boolean matchOwner(Coordinates pos) {
		if (map.getOwner(pos) == ply.getName()) {
			return true;
		} else {
			return false;
		}
	}	
	
	public void OnPress(Coordinates pos) {
		if(matchOwner(pos)) {
			
			this.oldEntity = map.getEntity(pos);

			if(this.oldEntity instanceof Towers) {
				towerOnPress();
			} else if(this.oldEntity instanceof Troops) {
				troopOnPress(pos);						
			} else if(this.oldEntity instanceof FreeCell) {
				cellOnPress(pos);
			}
		}
	}
		
	private void troopOnPress(Coordinates pos) {
		GUI.setBorder(true, trm.allConquerable((Troops)this.oldEntity));		
		GUI.setOnTroop(trm.newTroop(this.oldEntity));
	}
	
	private void towerOnPress() {
		GUI.setOnTower(twm.newTower(this.oldEntity));
	}
	
	private void cellOnPress(Coordinates pos) {
		
		GUI.setOnTroop(trm.newTroop(this.oldEntity));
		GUI.setOnTower(twm.newTower(this.oldEntity));
		
		if(frm.inRange(pos)) {
			GUI.setOnFarm(frm.newFarm(this.oldEntity));			
		}
	}
	
	public void OnRelease(Coordinates pos) {
		if (pos.samePosition(oldEntity.getCoordinates()) && oldEntity instanceof Troops) {
			troopOnRelease(pos);
		}
	}
	
	
	public void addFarm(Farm farm) {
		map.addEntity(farm);
	}
	
	public void addTroop(Troops troop) {
		map.addEntity(troop);
	}
	
	public void addTower(Towers tower) {
		map.addEntity(tower);
	}
	
	
	
	private void troopOnRelease(Coordinates pos) {
		
		GUI.setBorder(false, trm.allConquerable((Troops)oldEntity));
		
		
		if(!oldEntity.getCoordinates().equals(pos)) {
			trm.posConquest(pos, (Troops)map.getEntity(pos));
		}
	}
	
	
}
