package logic;

import logic.game.*;
import obsidia.players.PlayerList;
import view.EndPanel;

public class TurnManager extends ViewManager{
	
	private  MapManager map = new MapManager();
	private  PlayerList ply = new PlayerList();
	
	//exit from the turn
	private void moveEnd() {
		clearFrame();
		new EndPanel(frame);
	}

	//call when a troop move in a cell where is a Castle or click exit
	public void playerDefeated(String name) {
		//to chek that a player can't defeated himself
		if(this.ply.getName() != name) {
			ply.removePlayer(name);
		}
		
		if(ply.numberPlayer() == 1) {
			moveEnd();
		}
	}
	
	/*
	//to do after every add of a Farm
	public int getFarmCost() {
		return map.numberFarm(ply.getName())*2 + Farm.COST;
	}
	*/
	
	//TODO: adjust the coni update if before or after
	/*
	//to do after every add of an entity
	public void updateCoinsPlayer() {
		ply.setCoins(ply.getCoins() + map.getIdBalance(ply.getName()));
	}
	
	
	public Player playerNext() {
		new PlayerManager().coinTurnUpdate();
		return ply.nextPlayer();
	}
	*/
	
	
}
