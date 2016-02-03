
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.awt.Image;


public class Assets {
	
	private static final int WIDTH = 40, HEIGHT = 40;
	private static final int WWIDTH = 16, WHEIGHT = 16;
	private Image entitiesheet, blocksheet, coinsheet;
	//-----
	
	private Image[] coin;
	
	private Image floor, key, lock, watertop, darkspike, 
	lightspike, closedChest, brick, blank, topLadder,
	water, darkrock, ladderWater, openedChest, woodenDoor,
	halfLadderWaterTop, steelDoor, ladder, miniPlat, ladderWaterTop;
	//----
	private Image standR, standL, death;
	private Image[] walkL, walkR, ladderA, jumpL, jumpR;
	
	//------
	private Image hud, mBG, exit, exitOver, inst, instOver, instPage, play, playOver, gameOver;
	
	//all the assets were loaded for future updates
	
	public Assets(GameEngine engine) {
		blocksheet = engine.loadImage("res/blocks.png");
		entitiesheet = engine.loadImage("res/entities.png");
		coinsheet = engine.loadImage("res/coin.png");
		//--- Hud and menu
		hud = engine.loadImage("res/menu.png");
		
		mBG = engine.loadImage("res/state/mBG.png");
		exit = engine.loadImage("res/state/exit.png");
		exitOver = engine.loadImage("res/state/exitOver.png");
		inst = engine.loadImage("res/state/mInst.png");
		instOver = engine.loadImage("res/state/mInstOver.png");
		instPage = engine.loadImage("res/state/mInstPage.png");
		play = engine.loadImage("res/state/mPlay.png");
		playOver = engine.loadImage("res/state/mPlayOver.png");
		gameOver = engine.loadImage("res/GameOver.png");
		
		// cropping the first row
		floor      = engine.subImage(blocksheet, 0 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		key        = engine.subImage(blocksheet, 1 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		lock       = engine.subImage(blocksheet, 2 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		watertop   = engine.subImage(blocksheet, 3 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		darkspike  = engine.subImage(blocksheet, 4 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		lightspike = engine.subImage(blocksheet, 5 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		closedChest= engine.subImage(blocksheet, 6 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		//cropping the second row
		brick      = engine.subImage(blocksheet, 0 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		blank      = engine.subImage(blocksheet, 1 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		topLadder  = engine.subImage(blocksheet, 2 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		water      = engine.subImage(blocksheet, 3 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		darkrock   = engine.subImage(blocksheet, 4 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		ladderWater= engine.subImage(blocksheet, 5 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		openedChest= engine.subImage(blocksheet, 6 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		//cropping the third row
		woodenDoor = engine.subImage(blocksheet, 0 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		halfLadderWaterTop = engine.subImage(blocksheet, 1 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		steelDoor  = engine.subImage(blocksheet, 2 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		ladder     = engine.subImage(blocksheet, 3 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		miniPlat   = engine.subImage(blocksheet, 4 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		ladderWaterTop     = engine.subImage(blocksheet, 6 * WWIDTH, 2 * WHEIGHT, WWIDTH, WHEIGHT);
		
		
		//-------------- cropping the player sheet
		
		standR = engine.subImage(entitiesheet, 0 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		standL = engine.subImage(entitiesheet, 0 * WWIDTH, 1 * WHEIGHT, WWIDTH, WHEIGHT);
		death  = engine.subImage(entitiesheet, 5 * WWIDTH, 0 * WHEIGHT, WWIDTH, WHEIGHT);
		
		//--
		//arrays for animation, 2 frames each
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
		
		//----Coin animation array
		coin = new Image[10];
		for(int i=0; i<10; i++) {
			coin[i] = engine.subImage(coinsheet, i*WIDTH, 0, WIDTH, HEIGHT);
		}
		
	}
	//--- GETTERS
	
	//----HUD
	public Image getHUD() {
		return hud;
	}
	
	public Image getGameOver() {
		return gameOver;
	}
	
	public Image getmBG() {
		return mBG;
	}

	public Image getExit() {
		return exit;
	}

	public Image getExitOver() {
		return exitOver;
	}

	public Image getInst() {
		return inst;
	}

	public Image getInstOver() {
		return instOver;
	}

	public Image getInstPage() {
		return instPage;
	}

	public Image getPlay() {
		return play;
	}

	public Image getPlayOver() {
		return playOver;
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
	
	public Image getKey() {
		return key;
	}
	
	//--- WORLD
	public Image getFloor() {
		return floor;
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

	public Image getLadderWater() {
		return ladderWater;
	}

	public Image getOpenedChest() {
		return openedChest;
	}

	public Image getWoodenDoor() {
		return woodenDoor;
	}

	public Image getHalfLadderWaterTop() {
		return halfLadderWaterTop;
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

	public Image getLadderWaterTop() {
		return ladderWaterTop;
	}


}
