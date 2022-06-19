package obsidia.map;

import java.util.HashMap;
import java.util.Map;

import obsidia.entities.buildings.Farm;
import obsidia.utilities.Coordinates;

public class UseMap {
	
	private static final Map<Coordinates, Cells> MAP = new HashMap<Coordinates, Cells>();
	
	public void addEntity(final Cells entity) {
		UseMap.MAP.put(entity.getCoordinates(), entity);
	}
	
	//TODO that's not completely correct, tecnically only troup colud change position so
	// the field position in Abstract cell shuld be final (but not for troop....)
	public void moveEntity(final Cells entity, Coordinates pos) {
		entity.setCoordinates(pos);
		UseMap.MAP.replace(pos, entity);
	}
	
	public int getDefence(final Coordinates xy) {
		return UseMap.MAP.get(xy).getDefence();
	}

	public String getOwner(final Coordinates xy) {
		return UseMap.MAP.get(xy).getOwner();
	}
	
	public Class<? extends Cells> getEntity(final Coordinates xy) {
		return UseMap.MAP.get(xy).getClass();
	}
	
	public int getBalance(final Coordinates xy) {
		return UseMap.MAP.get(xy).getBalance();
	}
	
	public int numberFarm(final String ID) {
		int num = 0;
		for ( final Cells i : UseMap.MAP.values() ) {
			if(i instanceof Farm) {
				num ++;
			}
		}
		return num;		
	}
	
	public int getIdBalance(final String ID){
		int balance = 0;
		for ( final var i : UseMap.MAP.values() ) {
			if(i.getOwner() == ID) {
				balance += i.getBalance();
			}
		}
		return balance;
	}

}
