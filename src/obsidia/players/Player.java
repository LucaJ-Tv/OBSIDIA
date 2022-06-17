package obsidia.players;

import java.awt.Color;

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

	protected void setCoins(int coins) {
		this.coins = coins;
	}
	
	
}
