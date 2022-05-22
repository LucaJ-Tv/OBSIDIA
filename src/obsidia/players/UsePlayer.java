package obsidia.players;

import java.awt.Color;
import java.util.LinkedList;

public class UsePlayer {
	
	private static final LinkedList<Player> PLY = new LinkedList<>();
	
	public static void addPlayer(final Player p) {
		PLY.addLast(p);
	}

	public String getName() {
		return PLY.getFirst().getName();
	}
	
	public int getCoins() {
		return PLY.getFirst().getCoins();
	}
	
	public Color getColor() {
		return PLY.getFirst().getColor();		
	}
	
	public void setCoins(final int coins) {
		PLY.getFirst().setCoins(coins);
	}
	
	public Player nextPlayer() {
		addPlayer(PLY.removeFirst());
		return PLY.getFirst();
	}
	
	public void removePlayer(final String name) {
		for (var i : PLY) {
			if(i.getName() == name) {
				PLY.remove(i);
			}
		}
	}
	
	public int playerSize() {
		return PLY.size();
	}
}
