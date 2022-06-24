package logic;

import obsidia.map.UseMap;

public class TurnManager {
	
	UseMap map = new UseMap();
	
	public int mapWidth() {
		return map.getWidth();
	}
	
	public int mapHeight() {
		return map.getHeight();
	}
}
