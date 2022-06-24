package logic.game;

import javax.swing.ImageIcon;

import logic.ManagerImplementation;
import obsidia.map.DefaultMap;
import obsidia.utilities.Coordinates;

public class MapManager extends ManagerImplementation{
	
	DefaultMap def = new DefaultMap();

	@Override
	public void defaultMapLoad(String file) {
		def.setMap(file);
		def.loadMap();
		def.createMap();
	}

	@Override
	public String[] defaulMapGive() {
		return def.listMap();
	}
	
	@Override
	public void cleanMap() {
		ManagerImplementation.map
		.cleanMap();
	}	
	
	@Override
	public ImageIcon iconCell(Coordinates pos) {
		return 	ManagerImplementation.map
				.getEntity(pos)
				.getIcon();
	}
	
	@Override
	public int mapWidth() {
		return ManagerImplementation.map.getWidth();
	}
	
	@Override
	public int mapHeight() {
		return ManagerImplementation.map.getHeight();
	}
	
}

