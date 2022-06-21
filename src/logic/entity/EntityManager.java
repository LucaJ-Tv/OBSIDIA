package logic.entity;

import logic.troop.TroopMovement;
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
	private final TroopMovement tp = new TroopMovement();
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
		//GUI.setTroop(true, newTroop());
	}
	
	private Troops newTroop() {
		Troops Troop = null;
		if (oldEntity instanceof FreeCell) {
			Troop = new TroopOne(oldEntity.getOwner(), oldEntity.getCoordinates());
			
		} else if(oldEntity instanceof TroopOne) {
			Troop = new TroopTwo(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopTwo) {
			Troop = new TroopThree(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopThree) {
			Troop = new TroopFour(oldEntity.getOwner(), oldEntity.getCoordinates());	
		} 
		return Troop;
	}
	
	private void towerOnPress() {
		newTower();
		//Attivare tower Button con livello Torre
	}
	
	public void newTower()	{
		if (oldEntity instanceof FreeCell) {
			map.addEntity(new TowerOne(oldEntity.getOwner(), oldEntity.getCoordinates()));			
		} else if (oldEntity instanceof TowerOne) {
			map.addEntity(new TowerTwo(oldEntity.getOwner(), oldEntity.getCoordinates()));	
		}
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
