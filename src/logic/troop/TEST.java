package logic.troop;

import obsidia.entities.buildings.Castle;
import obsidia.entities.buildings.Farm;
import obsidia.entities.troops.TroopOne;
import obsidia.entities.troops.Troops;
import obsidia.map.Cells;
import obsidia.map.DefaultMap;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class TEST {

	public static void main(String[] args) {
		new DefaultMap("Map2");
		UseMap map = new UseMap();
		for (int i = 0; i < map.getHeight(); i ++) {
			for (int j = 0; j < map.getWidth(); j++) {
				
				System.out.println(map.getOwner(new Coordinates(i, j)));
			}
		}
	}
	
}
