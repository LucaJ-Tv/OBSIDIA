package logic;

import view.Frame;
import view.StartPanel;

public class StartGame {

	private static Frame frame = new Frame();
	
	public static void main(String[] args) {
		new StartPanel(frame);
	}

}
