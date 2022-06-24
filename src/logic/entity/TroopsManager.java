package logic.entity;

import java.util.Collections;
import java.util.Set;

import logic.ManagerImplementation;
import obsidia.entities.cells.FreeCell;
import obsidia.entities.troops.TroopFour;
import obsidia.entities.troops.TroopOne;
import obsidia.entities.troops.TroopThree;
import obsidia.entities.troops.TroopTwo;
import obsidia.entities.troops.Troops;
import obsidia.map.Cells;
import obsidia.utilities.Coordinates;

public class TroopsManager extends ManagerImplementation{
	
	private boolean isMyBuilding(Coordinates pos, Troops troop) {
		return troop.getOwner() == ManagerImplementation.map.getOwner(pos);
	}
	
	private boolean Stronger(Coordinates pos, Troops troop) {
		return troop.getOffence() >= ManagerImplementation.map.getDefence(pos);
	}
	
	private boolean inRange (Coordinates pos, Troops troop) {
		return (pos.distance(troop.getCoordinates()) <= troop.getMovement());
		
	}

	private boolean isConquerable(Coordinates pos, Troops troop) {
		return (Stronger(pos, troop) && inRange(pos, troop) && !isMyBuilding(pos, troop));
		
	}	
	
	private Set<Coordinates> allConquerable(Troops troop) {
		Set<Coordinates> cords = Collections.emptySet();
		for (Coordinates i : troop.getCoordinates().near(troop.getMovement(), 
			ManagerImplementation.map.getWidth(), 
			ManagerImplementation.map.getHeight())) {
			
			if(this.isConquerable(i, troop)) {
				cords.add(i);
			}
		}
		return cords;	
	}
	
	private void posConquest(Coordinates pos, Troops troop) {
		if (isConquerable(pos, troop)) {
			map.moveEntity(troop, pos);
			map.addEntity(new FreeCell(troop.getOwner(), troop.getCoordinates()));	
		}
	}
	
	private Troops newTroop(Cells oldEntity) {
		Troops troop = null;
		if (oldEntity instanceof FreeCell) {
			troop = new TroopOne(oldEntity.getOwner(), oldEntity.getCoordinates());
			
		} else if(oldEntity instanceof TroopOne) {
			troop = new TroopTwo(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopTwo) {
			troop = new TroopThree(oldEntity.getOwner(), oldEntity.getCoordinates());	
			
		} else if(oldEntity instanceof TroopThree) {
			troop = new TroopFour(oldEntity.getOwner(), oldEntity.getCoordinates());	
		} 
		return troop;
	}
	
	protected boolean isBuildableCell(Cells entity) {
		return (entity instanceof Troops || entity instanceof FreeCell);
	}
	
	
	

	@Override
	public boolean button() {
		return (isBuildableCell(super.oldEntity) && super.enoughCoins(newTroop(oldEntity)));
	}
	
	@Override
	public Set<Coordinates> borderActivate(){
		if(oldEntity instanceof Troops) {
			return allConquerable((Troops)super.oldEntity);
		}			
		return Collections.emptySet();	
	}
	
	@Override
	public void newEntity() {
		Cells tr = newTroop(super.oldEntity);
		ManagerImplementation.map.addEntity(tr);
		ManagerImplementation.ply.addCoins(-tr.getCost());
	}
	
	@Override
	public void moveTroop(Coordinates pos) {
		posConquest(pos, (Troops)super.oldEntity);
	}
}
