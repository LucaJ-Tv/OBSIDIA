package obsidia.turn;

import java.util.List;

import obsidia.entities.buildings.Farm;
import obsidia.map.UseMap;
import obsidia.players.Player;
import obsidia.players.UsePlayer;
import obsidia.utilities.Coordinates;

public class TurnGame implements Turn{
	
	private final UseMap map = new UseMap();
	private final UsePlayer player = new UsePlayer();
	private Coordinates coordinates;
	private List<Coordinates> castlePosition = map.castleposition();
	
	//to do after every add of a Farm
	@Override
	public int getFarmCost() {
		return map.numberFarm(player.getName())*2 + Farm.getInizCost();
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
		return player.playerSize() == 1;
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
