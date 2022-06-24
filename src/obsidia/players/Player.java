package obsidia.players;

import java.awt.Color;

/**
 * 
 * @author Tellarini Pietro
 * 
 * The class is used to store a player's information
 * All it's method are used only to provide information 
 * and set variable by PlayerList.class
 * @see PlayerList.java
 *
 */
public class Player{
	
	private static final int DEFAULT_COINS = 10;
	
	private final String name;
	private final Color color;
	private int coins;
	
	
	public Player(final String name, final Color color, final int startCoins) {
		this.name = name;
		this.color = color;
		this.coins = startCoins;	
	}
	
	/**
	 * 
	 * @param player
	 * @param color
	 * This constuctor will assign at variable conins the DEFAULT_COINS value = 10
	 * 
	 */
	public Player(final String player, final Color color) {
		this(player, color, Player.DEFAULT_COINS);
	}
	
	protected String getName() {
		return name;
	}
	
	protected Color getColor() {
		return color;
	}

	protected int getCoins() {
		return coins;
	}
	
	protected void addCoind(int coins) {
		this.coins += coins;
	}

	protected void setCoins(int coins) {
		this.coins = coins;
	}
	
	
}
