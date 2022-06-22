package logic.entity;

import obsidia.map.Cells;


public class CoinManager {
	
	protected boolean enoughCoins(Cells entity, int coin) {
		return coin > entity.getCost();
	}
	
}
