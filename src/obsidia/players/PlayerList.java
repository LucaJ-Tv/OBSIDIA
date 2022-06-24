package obsidia.players;

import java.awt.Color;
import java.util.LinkedList;

/**
 * 
 * @author Tellarini Pietro
 * 
 * The class instantiates a static list of game players. 
 * This list memorizes the players and considers 
 * the first element of the list the player 
 * who is playing at that given moment
 *
 */
public class PlayerList {
	
	private static final LinkedList<Player> PLY = new LinkedList<>();
	
	/** 
	 * @param p it' a player @see Player.java
	 * Add the player into the list
	 */
	public void addPlayer(final Player p) {
		PLY.addLast(p);
	}

	/**
	 * @return Name of the first Player in list (head)
	 */
	public String getName() {
		return PLY.getFirst().getName();
	}
	
	/**
	 * @return Coins of the first Player in list (head)
	 */
	public int getCoins() {
		return PLY.getFirst().getCoins();
	}
	
	/**
	 * @return Color of the first Player in list (head)
	 */
	public Color getColor() {
		return PLY.getFirst().getColor();		
	}
	
	/**
	 * @param index position in the list
	 * @return Color of the first Player in list at index
	 */
	public Color getColorIndex(final int index) {
		return PLY.get(index).getColor();		
	}
	
	/**
	 * @param coins
	 * Set coins of the first Player in the list
	 */
	public void setCoins(final int coins) {
		PLY.getFirst().addCoind(coins);
	}
	
	/**
	 * @param coins
	 * Add coins of the first Player in the list
	 */
	public void addCoins(int idBalance) {
		PLY.getFirst().setCoins(idBalance);
	}
	
	/**
	 * Remove the first player and put it in the last position of the list
	 * @return the first player of the list
	 */
	public Player nextPlayer() {
		addPlayer(PLY.removeFirst());
		return PLY.getFirst();
	}
	
	/**
	 * @param name
	 * Remove the player with the given name
	 */
	public void removePlayer(final String name) {
		for (var i : PLY) {
			if(i.getName() == name) {
				PLY.remove(i);
			}
		}
	}
	/**
	 * Clear the list of the player
	 */
	public void removeAllPlayer() {
			PLY.removeAll(PLY);
	}
	
	/**
	 * @param index
	 * @return the name of the player in the given position of the list
	 */
	public String getNameIndex(final int index) {
		return PLY.get(index).getName();		
	}
	
	/**
	 * @return number of player of the list (list size)
	 */
	public int numberPlayer() {
		return PLY.size();
	}

}
