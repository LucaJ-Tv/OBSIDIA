package logic;

import java.awt.Color;
import java.util.Set;

import javax.swing.ImageIcon;

import obsidia.utilities.Coordinates;

public interface Manager {
	
	//TODO possibile aggiunta di icona
	public boolean setClickedPosition(Coordinates pos);

	// PLAYERS
	
	public void insertPlayer(String name, Color color);
	
	public void coinTurnUpdate();
	
	public void addPlayer(String name, Color color);
	
	public String winner();	

	
	//ENTITY
	
	public Set<Coordinates> borderActivate();

	public boolean button();
	
	
	public void moveTroop(Coordinates pos);
	
	public void newEntity();

	
	//MAP
	
	public void defaultMapLoad(String name);

	public String[] defaulMapGive();

	public ImageIcon iconCell(Coordinates pos);

	public void cleanMap();

	public int mapHeight();

	public int mapWidth();
	
}
