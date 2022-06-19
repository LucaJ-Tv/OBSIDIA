package obsidia.map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import obsidia.entities.buildings.Castle;
import obsidia.entities.cells.FreeCell;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public class DefaultMap {
	
	private static final int CASTLE = Character.getNumericValue('A');
	private static final int TERRAIN = Character.getNumericValue('0');
	private static final int GREY = Character.getNumericValue('x');
	
	final UseMap map = new UseMap();
	final PlayerList ply = new PlayerList();
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
		
		System.out.println(Character.getNumericValue('x'));
		System.out.println(Character.getNumericValue('1'));
		System.out.println(Character.isDigit('x'));
		System.out.println(Character.isDigit('1'));
		
	}
	
	private void createMap() {		
		
		for(int i = 0; i < dat.length; i++) {
			for (int j = 0; j< dat[i].length(); j++) {
				
				int entity = Character.getNumericValue(dat[0].charAt(j));
				
				if(entity >= DefaultMap.CASTLE && entity <= (DefaultMap.CASTLE + ply.numberPlayer())) {
					
					map.addEntity(new Castle(ply.getNameIndex(entity - CASTLE), new Coordinates(i,j)));			
					
				} else if(entity >= DefaultMap.TERRAIN && entity <= (DefaultMap.TERRAIN + ply.numberPlayer())){
					
					map.addEntity(new FreeCell(ply.getNameIndex(entity), new Coordinates(i,j))); 
					
				} else if (entity == DefaultMap.GREY){
					
					map.addEntity(new FreeCell(null, new Coordinates(i, j)));
				}
			}
		}
		
	}
	
	
	
	
}
