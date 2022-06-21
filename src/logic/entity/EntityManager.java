package logic.entity;

import java.util.Set;

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
	TurnGUI GUI = new TurnGUI();
	private Cells oldEntity;
	
	public boolean matchOwner(Coordinates pos) {
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
		GUI.setBorder(true, trm.allConquerable((Troops)map.getEntity(pos)));		
		GUI.setOnTroop(newTroop());
	}
	
	private void towerOnPress() {
		GUI.setOnTower(newTower());
	}
	
	private void cellOnPress(Coordinates pos) {
		GUI.setOnTroop(newTroop());
		GUI.setOnTower(newTower());
		//TODO Attivare tower, troop, farm (solo se vicine)
		GUI.setOnFarm(newFarm());
	}
	
	private Troops newTroop() {
		Troops troop = null;
		if (oldEntity instanceof FreeCell) {
			troop = new TroopOne(oldEntity.getOwner(), oldEntity.getCoordinates());
			
		} else if(oldEntity instanceof TroopOne) {
			troop = new TroopTwo(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopTwo) {
			troop = new TroopThree(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopThree) {
			troop = new TroopFour(oldEntity.getOwner(), oldEntity.getCoordinates());	
		} 
		return troop;
	}
	
	private Towers newTower()	{
		Towers tower = null;
		if (oldEntity instanceof FreeCell) {
			tower = new TowerOne(oldEntity.getOwner(), oldEntity.getCoordinates());			
		} else if (oldEntity instanceof TowerOne) {
			tower = new TowerTwo(oldEntity.getOwner(), oldEntity.getCoordinates());	
		}
		return tower;
	}
	
	public void OnRelease(Coordinates pos) {
		if (pos.samePosition(oldEntity.getCoordinates()) && oldEntity instanceof Troops) {
			troopOnRelease(pos);
		}
	}
	
	private Farm newFarm() {
		return new Farm(oldEntity.getOwner(), oldEntity.getCoordinates());		
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
		
		//GUI.BorderOff(false, trm.allConquerable((Troops)map.getEntity(pos)));
		
		
		if(!oldEntity.getCoordinates().equals(pos)) {
			trm.posConquest(pos, (Troops)map.getEntity(pos));
		}
	}
	
	
}
