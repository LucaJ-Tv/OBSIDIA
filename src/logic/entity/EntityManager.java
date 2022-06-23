package logic.entity;

import java.awt.Color;
import java.util.Collections;
import java.util.Set;

import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.Player;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;
import obsidia.entities.troops.Troops;

public class EntityManager implements Manager{
	
	private final UseMap map = new UseMap();
	private final PlayerList ply = new PlayerList();
	private final TroopsManager troop = new TroopsManager();
	private final TowerManager tower = new TowerManager();
	private final FarmManager farm = new FarmManager();
	private final CoinManager coin = new CoinManager();
	
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
		return troop.isBuildableCell(oldEntity) && coin.enoughCoins(troop.newTroop(oldEntity));
	}
	
	@Override
	public boolean buttonTower() {
		return tower.isBuildableCell(oldEntity) && coin.enoughCoins(troop.newTroop(oldEntity));
	}
	
	@Override
	public boolean buttonFarm() {
		return farm.isBuildableCell(oldEntity) && coin.enoughCoins(farm.newFarm(oldEntity));
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
		Cells tr = troop.newTroop(this.oldEntity);
		map.addEntity(tr);
		ply.addCoins(-tr.getCost());
	}
	
	@Override
	public void newTower() {
		Cells tw = tower.newTower(this.oldEntity);
		map.addEntity(tw);
		ply.addCoins(-tw.getCost());
	}
	
	@Override
	public void newFarm() {
		Cells fr = tower.newTower(this.oldEntity);
		map.addEntity(fr);
		ply.addCoins(-fr.getCost());
	}
	
	@Override
	public void moveTroop(Coordinates pos) {
		troop.posConquest(pos, (Troops)this.oldEntity);
	}
	
	
}
