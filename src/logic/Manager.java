package logic;

import java.awt.Color;
import java.util.Set;

import obsidia.utilities.Coordinates;

public interface Manager {
	
	public void insertPlayer(String name, Color color);
	
	//TODO possibile aggiunta di icona
	public boolean setClickedPosition(Coordinates pos);
	
	public Set<Coordinates> borderActivate();

	public boolean button();
	
	
	public void moveTroop(Coordinates pos);
	
	public void newEntity();
	
	public String winner();	
	
	//public boolean enoughCoins(Cells entity);

	public void coinTurnUpdate();

	public void addPlayer(String name, Color color);
	
}
