package obsidia.map;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import obsidia.entities.buildings.Castle;
import obsidia.entities.cells.FreeCell;
import obsidia.players.Player;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class DefaultMap {
	
	private static final int CASTLE = Character.getNumericValue('A');
	private static final int TERRAIN = Character.getNumericValue('0');
	private static final int GREY = Character.getNumericValue('x');
	
	private UseMap map = new UseMap();
	private PlayerList ply = new PlayerList();
	private String[] dat;
	
	public DefaultMap(final String fileName) {
		loadMap(fileName);
		createMap();
	}
	
	private void loadMap(String fileName) {
		
		Path path = Path.of("data" + File.separator + fileName);
		try {
			dat = Files.readString(path).split("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		map.setDimension(Integer.parseInt(dat[0]) , Integer.parseInt(dat[1]));
		
	}
	
	private void createMap() {		
		
		for(int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j< map.getWidth(); j++) {
				
				int entity =Character.getNumericValue(dat[i+2].charAt(j));
				
				if(entity >= DefaultMap.CASTLE && entity < (DefaultMap.CASTLE + ply.numberPlayer())) {
					
					map.addEntity(new Castle(ply.getNameIndex(entity - CASTLE), new Coordinates(i,j)));			
					
				} else if(entity >= DefaultMap.TERRAIN && entity < (DefaultMap.TERRAIN + ply.numberPlayer())){
					
					map.addEntity(new FreeCell(ply.getNameIndex(entity), new Coordinates(i,j))); 
					
				} else if(entity == DefaultMap.GREY) {
					map.addEntity(new FreeCell("NO", new Coordinates(i,j)));
				} else {					
					map.addEntity(new FreeCell(null, new Coordinates(i, j)));
				} 
			}
		}
		
	}
	
	
	
	
}
