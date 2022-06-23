package logic;

import obsidia.map.UseMap;
import obsidia.players.PlayerList;
import view.Frame;
import view.StartPanel;

public class StartGame {
	
	private static Frame frame = new Frame();
	private static PlayerList ply = new PlayerList();
	private static UseMap map = new UseMap();
	
	public static void main(String[] args) {
		new StartGame(true);
	}
	
	public StartGame(boolean cleanPlayerList) {
		if(cleanPlayerList) {
			new StartPanel(frame);
			ply.removeAllPlayer();
		}
		map.cleanMap();
	}
	
}
