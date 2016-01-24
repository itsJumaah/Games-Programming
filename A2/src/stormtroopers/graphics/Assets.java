package stormtroopers.graphics;

import java.awt.Image;

import stormtroopers.*;

public class Assets {
	
	private static final int WIDTH = 40, HEIGHT = 40;
	private static final int WWIDTH = 16, WHEIGHT = 16;
	private Image coinsheet, tilesheet;
	
	
	private Image[] coin;
	private Image midGround, leftGround, rightGround, underGround;
	
	
	public Assets(GameEngine engine) {
		coinsheet = engine.loadImage("res/coin.png");
		tilesheet = engine.loadImage("res/tile.png");
		
		leftGround  = engine.subImage(tilesheet, 0 * WWIDTH + 0, 0          , WWIDTH, WHEIGHT);
		midGround   = engine.subImage(tilesheet, 1 * WWIDTH + 1, 0          , WWIDTH, WHEIGHT);
		rightGround = engine.subImage(tilesheet, 2 * WWIDTH + 2, 0          , WWIDTH, WHEIGHT);
		
		underGround = engine.subImage(tilesheet, 1 * WWIDTH + 1, WHEIGHT + 1, WWIDTH, WHEIGHT);
		
		
		
		//----Coin
		coin = new Image[10];
		for(int i=0; i<10; i++) {
			coin[i] = engine.subImage(coinsheet, i*WIDTH, 0, WIDTH, HEIGHT);
		}
		
	}


	public Image getCoinsheet() {
		return coinsheet;
	}


	public Image getTilesheet() {
		return tilesheet;
	}


	public Image[] getCoin() {
		return coin;
	}


	public Image getMidGround() {
		return midGround;
	}


	public Image getLeftGround() {
		return leftGround;
	}


	public Image getRightGround() {
		return rightGround;
	}


	public Image getUnderGround() {
		return underGround;
	}
	
	
}
