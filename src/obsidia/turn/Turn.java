package obsidia.turn;

import obsidia.players.Player;
import obsidia.utilities.Coordinates;

public interface Turn {
	
	int getFarmCost();

	void updateCoinsPlayer();
	
	void hit(Coordinates c);
	
	Player playerNext();
	
	void playerDefeated(String name);

}
