package logic.turn;

import java.awt.Color;

import obsidia.entities.buildings.Farm;
import obsidia.map.DefaultMap;
import obsidia.map.GameMap;
import obsidia.players.Player;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class TurnManager implements Turn{
	
	private  GameMap map = new GameMap();
	private  PlayerList player = new PlayerList();
	private Coordinates coordinates;
	
	public TurnManager() {
		
	}
	
	//to do after every add of a Farm
	@Override
	public int getFarmCost() {
		return map.numberFarm(player.getName())*2 + Farm.COST;
	}
	
	//to do after every add of an entity
	@Override
	public void updateCoinsPlayer() {
		player.setCoins(player.getCoins() + map.getIdBalance(player.getName()));
	}

	@Override
	public void hit(Coordinates c) {
		this.coordinates = c;
	}
	
	@Override
	public Player playerNext() {
		return player.nextPlayer();
	}
	
	private boolean haveWinner() {
		return player.numberPlayer() == 1;
	}
	
	//call when a troop move in a cell where is a Castle
	@Override
	public void playerDefeated(String name) {
		//to chek that a player can't defeated himself
		if(this.player.getName() != name) {
			player.removePlayer(name);
		}
		
		if(haveWinner()) {
			//call end game
		}
	}
	
	
}
