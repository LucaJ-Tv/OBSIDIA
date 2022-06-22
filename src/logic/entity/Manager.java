package logic.entity;

import java.awt.Color;
import java.util.Set;

import obsidia.utilities.Coordinates;

public interface Manager {
	
	public void insertPlayer(String name, Color color);
	
	//TODO possibile aggiunta di icona
	public boolean setClickedPosition(Coordinates pos);
	

	public boolean buttonTroop();
	
	public boolean buttonTower();
	
	public boolean buttonFarm();
	
	public Set<Coordinates> borderActivate();
	
	
	public void newTroop();
	
	public void newTower();
	
	public void newFarm();
	
	public void moveTroop(Coordinates pos);
	
	
	
	
	
}
