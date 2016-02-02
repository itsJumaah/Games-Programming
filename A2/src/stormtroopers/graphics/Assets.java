package stormtroopers.graphics;

import java.awt.Image;

import stormtroopers.*;

public class Assets {
	
	private static final int WIDTH = 40, HEIGHT = 40;
	private static final int WWIDTH = 16, WHEIGHT = 16;
	private Image coinsheet, tilesheet;
	private Image entitiesheet, blocksheet;
	
	
	private Image[] coin;
	private Image ground, noGround;
	
	private Image floor, key, lock, watertop, darkspike, 
	lightspike, closedChest, brick, blank, topLadder,
	water, darkrock, lightrock, openedChest, woodenDoor,
	brownDoor, steelDoor, ladder, miniPlat, rope;
	
	private Image player;
	
	
	
	public Assets(GameEngine engine) {
		blocksheet = engine.loadImage("res/blocks.png");
		entitiesheet = engine.loadImage("res/entities.png");
		
		coinsheet = engine.loadImage("res/coin.png");
		//tilesheet = engine.loadImage("res/tile.png");
		
//		noGround  = engine.subImage(tilesheet, 0 * WWIDTH + 0, 0          , WWIDTH, WHEIGHT);
//		ground   = engine.subImage(tilesheet, 1 * WWIDTH + 1, 0          , WWIDTH, WHEIGHT);
		
		
		floor      = engine.subImage(blocksheet, 0 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		key        = engine.subImage(blocksheet, 1 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		lock       = engine.subImage(blocksheet, 2 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		watertop   = engine.subImage(blocksheet, 3 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		darkspike  = engine.subImage(blocksheet, 4 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		lightspike = engine.subImage(blocksheet, 5 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		closedChest= engine.subImage(blocksheet, 6 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		
		brick      = engine.subImage(blocksheet, 0 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		blank      = engine.subImage(blocksheet, 1 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		topLadder  = engine.subImage(blocksheet, 2 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		water      = engine.subImage(blocksheet, 3 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		darkrock   = engine.subImage(blocksheet, 4 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		lightrock  = engine.subImage(blocksheet, 5 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		openedChest= engine.subImage(blocksheet, 6 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		
		woodenDoor = engine.subImage(blocksheet, 0 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		brownDoor  = engine.subImage(blocksheet, 1 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		steelDoor  = engine.subImage(blocksheet, 2 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		ladder     = engine.subImage(blocksheet, 3 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		miniPlat   = engine.subImage(blocksheet, 4 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		rope       = engine.subImage(blocksheet, 6 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		
		
		//--------------
		
		player 		= engine.subImage(entitiesheet, 0 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		
		
		//----Coin
		coin = new Image[10];
		for(int i=0; i<10; i++) {
			coin[i] = engine.subImage(coinsheet, i*WIDTH, 0, WIDTH, HEIGHT);
		}
		
	}
	
	//------Player
	public Image getPlayer() {
		return player;
	}
	
	//------

	public Image[] getCoin() {
		return coin;
	}


	public Image getGround() {
		return ground;
	}


	public Image getNoGround() {
		return noGround;
	}

	public Image getCoinsheet() {
		return coinsheet;
	}

	public Image getTilesheet() {
		return tilesheet;
	}

	public Image getEntitiesheet() {
		return entitiesheet;
	}

	public Image getBlocksheet() {
		return blocksheet;
	}

	public Image getFloor() {
		return floor;
	}

	public Image getKey() {
		return key;
	}

	public Image getLock() {
		return lock;
	}

	public Image getWatertop() {
		return watertop;
	}

	public Image getDarkspike() {
		return darkspike;
	}

	public Image getLightspike() {
		return lightspike;
	}

	public Image getClosedChest() {
		return closedChest;
	}

	public Image getBrick() {
		return brick;
	}

	public Image getBlank() {
		return blank;
	}

	public Image getTopLadder() {
		return topLadder;
	}

	public Image getWater() {
		return water;
	}

	public Image getDarkrock() {
		return darkrock;
	}

	public Image getLightrock() {
		return lightrock;
	}

	public Image getOpenedChest() {
		return openedChest;
	}

	public Image getWoodenDoor() {
		return woodenDoor;
	}

	public Image getBrownDoor() {
		return brownDoor;
	}

	public Image getSteelDoor() {
		return steelDoor;
	}

	public Image getLadder() {
		return ladder;
	}

	public Image getMiniPlat() {
		return miniPlat;
	}

	public Image getRope() {
		return rope;
	}


}
