package logic;

import java.awt.Color;
import java.util.Collections;
import java.util.Set;

import obsidia.map.Cells;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import obsidia.utilities.Coordinates;

public abstract class ManagerImplementation implements Manager{
	
	protected static final UseMap map = new UseMap();
	protected static final PlayerList ply = new PlayerList();;
	protected Cells oldEntity;
	

	private boolean matchOwner(Coordinates pos) {
		if (map.getOwner(pos) == ply.getName()) {
			return true;
		} else {
			return false;
		}
	}	
	
	protected boolean enoughCoins(Cells entity) {
		return ply.getCoins() >= entity.getCost();
	}
	
	@Override 
	public boolean setClickedPosition(Coordinates pos) {
		if(matchOwner(pos)) {
			this.oldEntity = map.getEntity(pos);
			return true;
		} else {
			this.oldEntity = null;
			return false;
		}
	}
	
	@Override
	public void insertPlayer(String name, Color color) {
		return ;
	}
	

	@Override
	public String winner() {
		return "Luca";//null; TODO
	}
	
	@Override
	public void coinTurnUpdate() {
		return ;
	}
	
	@Override
	public void addPlayer(String name, Color color) {
		return ;
	};
	
	@Override
	public void moveTroop(Coordinates pos) {
		return ;
	}
	
	@Override
	public Set<Coordinates> borderActivate(){			
		return Collections.emptySet();	
	}
	
	@Override
	public boolean button() {
		return false;
	};
	
	@Override
	public void newEntity() {
		return ;
	};
	
}
