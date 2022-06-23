package logic.entity;

import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import obsidia.entities.buildings.Farm;

public class CoinManager {
	
	private final PlayerList ply = new PlayerList();
	private final UseMap map = new UseMap();
	private final FarmManager farm = new FarmManager();
	
	protected boolean enoughCoins(Cells entity) {
		if (entity instanceof Farm) {
			return ply.getCoins() >= farm.getCost(ply.getName());
		} else {
			return ply.getCoins() >= entity.getCost();			
		}
	}
	
	protected void coinTurnUpdate() {
		ply.addCoins(map.getIdBalance(ply.getName()));
	}
	
	
}
