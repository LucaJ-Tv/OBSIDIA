package logic.entity;

import java.awt.Color;
import java.util.Collections;
import java.util.Set;

import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.*;
import obsidia.entities.troops.*;
import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.Player;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class EntityManager implements Manager{
	
	private final UseMap map = new UseMap();
	private final PlayerList ply = new PlayerList();
	private final TroopsManager troop = new TroopsManager();
	private final TowerManager tower = new TowerManager();
	private final FarmManager farm = new FarmManager();
	
	private Cells oldEntity;

	private boolean matchOwner(Coordinates pos) {
		if (map.getOwner(pos) == ply.getName()) {
			return true;
		} else {
			return false;
		}
	}	
	
	@Override
	public void insertPlayer(String name, Color color) {
		ply.addPlayer(new Player(name, color));
	}
	
	@Override
	public boolean setClickedPosition(Coordinates pos) {
		if(matchOwner(pos)) {
			this.oldEntity = map.getEntity(pos);
			return true;
		} else {
			this.oldEntity = null;
			return false;
		}
	}
	
	@Override
	public boolean buttonTroop() {
		return (this.oldEntity instanceof Troops || this.oldEntity instanceof FreeCell);
	}
	
	@Override
	public boolean buttonTower() {
		return (this.oldEntity instanceof Towers || this.oldEntity instanceof FreeCell);
	}
	
	@Override
	public boolean buttonFarm() {
		return (this.oldEntity instanceof FreeCell && farm.inRange(oldEntity.getCoordinates()));
	}
	
	@Override
	public Set<Coordinates> borderActivate(){
		if(oldEntity instanceof Troops) {
			return troop.allConquerable((Troops)this.oldEntity);
		}			
		return Collections.emptySet();	
	}
	
	@Override
	public void newTroop() {
		map.addEntity(troop.newTroop(this.oldEntity));
	}
	
	@Override
	public void newTower() {
		map.addEntity(tower.newTower(this.oldEntity));
	}
	
	@Override
	public void newFarm() {
		map.addEntity(farm.newFarm(this.oldEntity));
	}
	
	@Override
	public void moveTroop(Coordinates pos) {
		map.moveEntity(this.oldEntity, pos);
	}
	
	
}
