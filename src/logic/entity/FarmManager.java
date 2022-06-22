package logic.entity;

import obsidia.entities.buildings.Castle;
import obsidia.entities.buildings.Farm;
import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.utilities.Coordinates;

public class FarmManager {
	
	private final UseMap map = new UseMap();
	
	private boolean isBuildable(Coordinates i) {
		return (map.getEntity(i) instanceof Castle || map.getEntity(i) instanceof Farm);
	}

	private boolean matchOwner(Coordinates pos, Coordinates i) {		
		return map.getOwner(i) == map.getOwner(pos);
	}

	protected boolean inRange(Coordinates pos) {
		Coordinates[] cord = pos.near(1, map.getWidth(), map.getHeight());
		
		for(var i : cord) {
			if(isBuildable(i) && matchOwner(pos, i)) {
				return true;
			}
		}
		return false;
	}

	protected Farm newFarm(Cells oldEntity) {
		return new Farm(oldEntity.getOwner(), oldEntity.getCoordinates());		
	}
}
