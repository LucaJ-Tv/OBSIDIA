package logic.game;

import java.awt.Color;

import logic.ManagerImplementation;
import obsidia.players.Player;

public class PlayerManager extends ManagerImplementation{

	@Override
	public void insertPlayer(String name, Color color) {
		ply.addPlayer(new Player(name, color));
	}
	
	@Override
	public String winner() {
		return ply.getName();
	}
	
	@Override
	public void coinTurnUpdate() {
		ply.addCoins(map.getIdBalance(ply.getName()));
	}
	
	@Override
	public void addPlayer(String name, Color color) {
		ply.addPlayer(new Player(name , color));
	};

}
