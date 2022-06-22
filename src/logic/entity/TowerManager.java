package logic.entity;

import obsidia.entities.cells.FreeCell;
import obsidia.entities.towers.TowerOne;
import obsidia.entities.towers.TowerTwo;
import obsidia.entities.towers.Towers;
import obsidia.map.Cells;

public class TowerManager {

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
}
