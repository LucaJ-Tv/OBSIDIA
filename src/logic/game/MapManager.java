package logic.game;

import logic.ManagerImplementation;
import obsidia.map.DefaultMap;

public class MapManager extends ManagerImplementation{

	public void loadMap() {
		new DefaultMap("Map1");
	}

}

