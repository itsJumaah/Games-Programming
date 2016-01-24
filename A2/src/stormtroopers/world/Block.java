package stormtroopers.world;

import java.awt.Image;

import stormtroopers.GameEngine;
import stormtroopers.graphics.Assets;

public class Block {
	
   	private Assets asset;
	
	public static Block[] block;
	public static Block midGround, rightGround, underGround, leftGround;
	
	
	//WORLD
	protected Image texture;
	protected final int id;
	
	public static final int WIDTH = 32, HEIGHT = 32;

	public Block(GameEngine engine, Image texture, int id) {
		this.texture = texture;
		this.id = id;
		
		
		asset = new Assets(engine);
		
		block = new Block[256];
		
		leftGround  = new Ground(engine, asset.getLeftGround(),  0);
		rightGround = new Ground(engine, asset.getRightGround(), 1);
		midGround   = new Ground(engine, asset.getMidGround(),   2);
		underGround = new Ground(engine, asset.getUnderGround(), 3);
		
		block[id] = this;
		
	}
	
	public boolean isSolid() {
		return true;
	}
	
	public void update(double dt) {
		
	}
	
	public void draw(GameEngine engine, int x, int y) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(texture, x, y, WIDTH, HEIGHT);
		engine.restoreLastTransform();
	}
	
	public int getId() {
		return id;
	}
}
