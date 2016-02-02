package stormtroopers.world;

import java.awt.Color;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.StormEngine;
import stormtroopers.entities.Coin;
import stormtroopers.entities.Key;
import stormtroopers.entities.Player;
import stormtroopers.graphics.Assets;

public class Map {

	
	private static int width;
	private static int height;
	private static int[][] blocks;
	
	//--- Block Class
	private static Block[] currentBlock;
	private static Assets asset;
	
	private static Block floor, lock, watertop, darkspike, 
	lightspike, closedChest, brick, blank, coinn,
	water, darkrock, lightrock, openedChest, woodenDoor,
	brownDoor, steelDoor, ladder, miniPlat, rope;
	
	//--- Player Class
	
	private Player player;
	private int playerX, playerY;
	
	private Key key;
	private Coin coin, coin1, coin2;
	private int coinX, coinY,
				coin1X, coin1Y,
				coin2X, coin2Y,
				keyX, keyY;
	
	
	//---
	
	public Map(GameEngine engine, String path) {
		
		mapSetup(engine);
		loadMap(path);
		
		player = new Player(engine, playerX, playerY);

		coin = new Coin(engine, coinX, coinY);
		coin1 = new Coin(engine, coin1X, coin1Y);
		coin2 = new Coin(engine, coin2X, coin2Y);
		
		key = new Key(engine, keyX, keyY);
		
		
	}
	//------
	public void update(MainGame control, double dt) {
		player.update(control, dt);
		
		if(coin.isExists()) {
			coin.update(control, player, dt);
		}
		if(coin1.isExists()) {
			coin1.update(control, player, dt);
		}
		if(coin2.isExists()) {
			coin2.update(control, player, dt);
		}
		
		if(key.isExists()) {
			key.update(control, player, dt);
		}
	}
	//--------
	public void draw(GameEngine engine) {
		
		drawMap(engine);
		
		player.draw(engine);
		
		if(coin.isExists()) {
			coin.draw(engine);
		}
		if(coin1.isExists()) {
			coin1.draw(engine);
		}
		if(coin2.isExists()) {
			coin2.draw(engine);
		}
		
		if(key.isExists()) {
			key.draw(engine);
		}
		
		
	}
	//---------
	private void drawMap(GameEngine engine) {
		engine.changeColor(Color.BLACK);
		engine.drawSolidRectangle(0, 0, 512, 512);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getBlock(x, y).draw(engine, x * Block.WIDTH/2 , y * Block.HEIGHT/2);
				
			}
		}
	}
	
	//---------
	public static Block getBlock(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return blank; //if outside the map to prevent errors
		}
		//----
		Block block = currentBlock[blocks[x][y]];
		
		if(block == null) {
			return blank;
		}
		
		else {
			return block;
		}
	}
	//------
	private void loadMap(String path) {
		String file = StormEngine.loadFileString(path);
		String[] numbers = file.split("\\s+"); //split on white space
		
		width 	= StormEngine.parseInt(numbers[0]);   //read the width from the file
		height  = StormEngine.parseInt(numbers[1]);  // height
		
		playerX = StormEngine.parseInt(numbers[2]);   //read the player position spawn
		playerY = StormEngine.parseInt(numbers[3]);
		
		//--
		
		coinX 	= StormEngine.parseInt(numbers[4]);
		coinY 	= StormEngine.parseInt(numbers[5]);
		coin1X 	= StormEngine.parseInt(numbers[6]);
		coin1Y 	= StormEngine.parseInt(numbers[7]);
		coin2X 	= StormEngine.parseInt(numbers[8]);
		coin2Y 	= StormEngine.parseInt(numbers[9]);
		keyX 	= StormEngine.parseInt(numbers[10]);
		keyY 	= StormEngine.parseInt(numbers[11]);
		
		//---
		
		blocks = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {//+4
				blocks[x][y] = StormEngine.parseInt(numbers[(x + y * width) + 12]);
			}
		}
	}
	//------
	private void mapSetup(GameEngine engine) {
		asset = new Assets(engine);
		currentBlock = new Block[256];
		//----------------
		floor       = new Block(engine, asset.getFloor()      , 1);
		currentBlock[1] = floor;
		lock        = new Block(engine, asset.getLock()       , 3);
		currentBlock[3] = lock;
		watertop    = new Block(engine, asset.getWatertop()   , 4);
		currentBlock[4] = watertop;
		darkspike   = new Block(engine, asset.getDarkspike()  , 5);
		currentBlock[5] = darkspike;
		lightspike  = new Block(engine, asset.getLightspike() , 6);
		currentBlock[6] = lightspike;
		closedChest = new Block(engine, asset.getClosedChest(), 7);
		currentBlock[7] = closedChest;
		brick		= new Block(engine, asset.getBrick()      , 8);
		currentBlock[8] = brick;
		blank       = new Block(engine, asset.getBlank()      , 9);
		currentBlock[9] = blank;
		coinn       = new Block(engine, asset.getTopLadder()  , 10);
		currentBlock[10] = coinn;
		water		= new Block(engine, asset.getWater()	  , 11);
		currentBlock[11] = water;
		darkrock	= new Block(engine, asset.getDarkrock()   , 12);
		currentBlock[12] = darkrock;
		lightrock	= new Block(engine, asset.getLightrock()  , 13);
		currentBlock[13] = lightrock;
		openedChest = new Block(engine, asset.getOpenedChest(), 14);
		currentBlock[14] = openedChest;
		woodenDoor  = new Block(engine, asset.getWoodenDoor() , 15);
		currentBlock[15] = woodenDoor;
		brownDoor   = new Block(engine, asset.getBrownDoor()  , 16);
		currentBlock[16] = brownDoor;
		steelDoor   = new Block(engine, asset.getSteelDoor()  , 17);
		currentBlock[17] = steelDoor;
		ladder      = new Block(engine, asset.getLadder()     , 18);
		currentBlock[18] = ladder;
		miniPlat    = new Block(engine, asset.getMiniPlat()   , 19);
		currentBlock[19] = miniPlat;
		rope        = new Block(engine, asset.getRope()       , 21);
		currentBlock[21] = rope;
	}
}
