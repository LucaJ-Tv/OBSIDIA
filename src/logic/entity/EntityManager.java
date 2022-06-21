package logic.entity;

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
	private final TroopsManager tp = new TroopsManager();
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
		//Chiamare GUI e Colorare bordo  celle accessibili
		Coordinates[] cors = tp.allConquerable((Troops)map.getEntity(pos));
		for(var i : cors) {
			//TODO COLORE BORDO IN POS i
		}
		GUI.setOnTroop(newTroop());
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
	
	public void towerOnPress() {
		//Attivare tower Button con livello Torre
		GUI.setOnTower(newTower());
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
	
	
	public void farmButton() {
		
	}
	
	private void cellOnPress(Coordinates pos) {
		//Attivare tower, troop, farm (solo se vicine)
	}
	
	
	
	
	
	private void troopOnRelease(Coordinates pos) {
		Coordinates[] cors = tp.allConquerable((Troops)map.getEntity(pos));
		for(var i : cors) {
			//TODO DISATTIVA COLORE BORDO IN POS i
		}
		
		if(!oldEntity.equals(pos)) {
			tp.posConquest(pos, (Troops)map.getEntity(pos));
		}
	}
	
	
}
