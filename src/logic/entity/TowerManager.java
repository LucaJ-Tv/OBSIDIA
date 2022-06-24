package logic.entity;

import java.util.Collections;
import java.util.Set;

import logic.ManagerImplementation;
import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.TowerOne;
import obsidia.entities.towers.TowerTwo;
import obsidia.entities.towers.Towers;
import obsidia.map.Cells;
import obsidia.utilities.Coordinates;

public class TowerManager extends ManagerImplementation {

	protected Towers newTower(Cells oldEntity)	{
		Towers tower = null;
		if (oldEntity instanceof FreeCell) {
			tower = new TowerOne(oldEntity.getOwner(), oldEntity.getCoordinates());			
		} else if (oldEntity instanceof TowerOne) {
			tower = new TowerTwo(oldEntity.getOwner(), oldEntity.getCoordinates());	
		}
		return tower;
	}
	
	protected boolean isBuildableCell(Cells entity) {
		return (entity instanceof Towers || entity instanceof FreeCell);
		
	}
	
	@Override
	public boolean button(){
		return isBuildableCell(super.oldEntity) && super.enoughCoins(newTower(oldEntity));
	}
	
	@Override
	public void newEntity() {
		Cells tw = newTower(this.oldEntity);
		ManagerImplementation.map.addEntity(tw);
		ManagerImplementation.ply.addCoins(-tw.getCost());
	}

	@Override
	public Set<Coordinates> borderActivate() {
		return Collections.emptySet();
	}

	@Override
	public void moveTroop(Coordinates pos) {
	}
}
