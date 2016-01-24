package stormtroopers.world;

import stormtroopers.GameEngine;

public class Map {

	private int width, height;
	private int[][] blocks;
	
	
	public Map(String path) {
		loadMap(path);
	}
	
	public void update() {
		
	}
	
	public void draw(GameEngine engine) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
				getBlock(x, y).draw(engine, x, y);
				
			}
		}
	}
	
	public Block getBlock(int x, int y) {
		Block block = Block.block[blocks[x][y]];
		
		if(block == null) {
			return Block.leftGround;
		}
		
		else {
			return block;
		}
		
	}
	private void loadMap(String path) {
		width = 5;
		height = 5;
		blocks = new int[width][height];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				blocks[x][y] = 0;
			}
		}
	}
}
