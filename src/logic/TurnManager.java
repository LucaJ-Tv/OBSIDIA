package logic;

import obsidia.map.GameMap;

public class TurnManager {
	
	GameMap map = new GameMap();
	
	public int mapWidth() {
		return map.getWidth();
	}
	
	public int mapHeight() {
		return map.getHeight();
	}
}
