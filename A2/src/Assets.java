

import java.awt.Image;


public class Assets {
	
	private static final int WIDTH = 40, HEIGHT = 40;
	private static final int WWIDTH = 16, WHEIGHT = 16;
	private Image entitiesheet, blocksheet, coinsheet;
	
	
	private Image[] coin;
	
	private Image floor, key, lock, watertop, darkspike, 
	lightspike, closedChest, brick, blank, topLadder,
	water, darkrock, lightrock, openedChest, woodenDoor,
	brownDoor, steelDoor, ladder, miniPlat, rope;
	
	private Image standR, standL, death;
	private Image[] walkL, walkR, ladderA, jumpL, jumpR;
	
	
	
	public Assets(GameEngine engine) {
		blocksheet = engine.loadImage("res/blocks.png");
		entitiesheet = engine.loadImage("res/entities.png");
		
		coinsheet = engine.loadImage("res/coin.png");
		
		
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
		
		standR = engine.subImage(entitiesheet, 0 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		standL = engine.subImage(entitiesheet, 0 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		death  = engine.subImage(entitiesheet, 5 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		
		//--
		
		walkL = new Image[2];
		walkR = new Image[2];
		ladderA = new Image[2];
		jumpL = new Image[2];
		jumpR = new Image[2];
		
		for(int i = 0; i < 2; i++) {
			walkL[i]   = engine.subImage(entitiesheet, i * WWIDTH + (1 * WWIDTH)   , 1 * WHEIGHT, WWIDTH, WHEIGHT);
			walkR[i]   = engine.subImage(entitiesheet, i * WWIDTH + (1 * WWIDTH)   , 0 * WHEIGHT, WWIDTH, WHEIGHT);
			ladderA[i] = engine.subImage(entitiesheet,     WWIDTH + (2 * WWIDTH) -2, i * WHEIGHT, WWIDTH, WHEIGHT);
			jumpL[i]   = engine.subImage(entitiesheet, i * WWIDTH 				   , 0 * WHEIGHT, WWIDTH, WHEIGHT);
			jumpR[i]   = engine.subImage(entitiesheet, i * WWIDTH                  , 1 * WHEIGHT, WWIDTH, WHEIGHT);
		}
		
		//----Coin
		coin = new Image[10];
		for(int i=0; i<10; i++) {
			coin[i] = engine.subImage(coinsheet, i*WIDTH, 0, WIDTH, HEIGHT);
		}
		
	}
	
	//------Player
	public Image getStandR() {
		return standR;
	}
	public Image getStandL() {
		return standL;
	}
	public Image getDeath() {
		return death;
	}

	public Image[] getJumpL() {
		return jumpL;
	}
	
	public Image[] getJumpR() {
		return jumpR;
	}

	public Image[] getWalkL() {
		return walkL;
	}
	
	public Image[] getWalkR() {
		return walkR;
	}
	
	public Image[] getLadderA() {
		return ladderA;
	}

//----- Entity
	public Image[] getCoin() {
		return coin;
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
