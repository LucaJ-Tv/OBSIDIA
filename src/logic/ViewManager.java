package logic;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import obsidia.map.DefaultMap;
import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import view.Frame;
import view.StartPanel;
import view.TurnPanel;

public class ViewManager {
	
	private static Frame frame = new Frame();
	private static PlayerList ply = new PlayerList();
	private static UseMap map = new UseMap();
	
	private final List<Color> listColor = Arrays.asList(
		new Color(200,15,15),
		new Color(200,15,150),
		new Color(50,40,235),
		new Color(30,210,210),
		new Color(10,200,30),
		new Color(240,250,20),
		new Color(250,150,30)
		);
	
	public static void main(String[] args) {
		new ViewManager().inizGame(true);
	}
	
	public void inizGame(boolean cleanPlayerList) {
		//if you want restart with the same player pass cleanPlayerList = false
		if(cleanPlayerList) {
			clearFrame();
			Collections.shuffle(listColor);
			ply.removeAllPlayer();
			new StartPanel(frame);
		}else {
			moveTurn("Map2");
		}
		map.cleanMap();
	}
	
	//between a change screen clean the frame
	private void clearFrame() {
		frame.setVisible(false);
		frame.getContentPane().removeAll();
	}
	
	//StartPanel -> TurnPanel
	public void moveTurn(String map) {
		clearFrame();
		new DefaultMap(map);
		new TurnPanel(frame);
	}

	//exit from the game
	public void exit() {
		if(JOptionPane.showConfirmDialog(
    			frame,
    			"Are you sure to exit?",
    			"EXIT",
    			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
    		System.exit(0);
	}
	
	//return a color of listColor
	public Color getColor(int pos) throws NoSuchElementException{
		return listColor.get(pos);
	}
	
}
