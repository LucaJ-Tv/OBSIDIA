package logic.game;

import java.awt.Color;

import logic.ManagerImplementation;
import obsidia.players.Player;

public class PlayerManager extends ManagerImplementation{
	
	@Override
	public String namePlayer() {
		return ply.getName();
	}
	
	@Override
	public Color colorPlayer() {
		return ply.getColor();
	}
	
	@Override
	public void coinTurnUpdate() {
		ply.addCoins(map.getIdBalance(ply.getName()));
	}
	
	@Override
	public void addPlayer(String name, Color color) {
		ply.addPlayer(new Player(name , color));
	}
	
	public void nextPlayer() {
		ply.nextPlayer();
	}
	
	public boolean hasWinner() {
		return ply.numberPlayer() == 1;
	}

}
