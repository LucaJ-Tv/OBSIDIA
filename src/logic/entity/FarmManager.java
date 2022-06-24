package logic.entity;

import java.util.Collections;
import java.util.Set;

import logic.ManagerImplementation;
import obsidia.entities.buildings.Castle;
import obsidia.entities.buildings.Farm;
import obsidia.entities.cells.FreeCell;
import obsidia.map.Cells;
import obsidia.utilities.Coordinates;

public class FarmManager extends ManagerImplementation{
	
	private boolean isBuildable(Coordinates i) {
		return (map.getEntity(i) instanceof Castle || map.getEntity(i) instanceof Farm);
	}

	private boolean matchOwner(Coordinates pos, Coordinates i) {		
		return map.getOwner(i) == map.getOwner(pos);
	}

	private boolean inRange(Coordinates pos) {
		Coordinates[] cord = pos.near(1, map.getWidth(), map.getHeight());
		
		for(var i : cord) {
			if(isBuildable(i) && matchOwner(pos, i)) {
				return true;
			}
		}
		return false;
	}

	private Farm newFarm(Cells oldEntity) {
		return new Farm(oldEntity.getOwner(), oldEntity.getCoordinates());		
	}
	
	private boolean isBuildableCell(Cells entity) {
		return (entity instanceof FreeCell && inRange(entity.getCoordinates()));
	}
	
	private int getCost(String player) {
		return map.numberFarm(player)*5 + Farm.COST;
	}
	
	@Override
	protected boolean enoughCoins(Cells entity) {
		return ManagerImplementation.ply.getCoins() >= this.getCost(ManagerImplementation.ply.getName());
	}
	
	@Override
	public boolean button() {
		return isBuildableCell(super.oldEntity) && this.enoughCoins(newFarm(oldEntity));
	}
	
	@Override
	public void newEntity() {
		Cells fr = newFarm(super.oldEntity);
		ManagerImplementation.map.addEntity(fr);
		ManagerImplementation.ply.addCoins(-fr.getCost());
	}

	@Override
	public Set<Coordinates> borderActivate() {
		return Collections.emptySet();
	}
	
}
