package stormtroopers.world;

import java.awt.Image;

import stormtroopers.GameEngine;

public class Block {
	
	//WORLD
	private final int id;
	private Image texture;
	private boolean solid, ladder;
	
	public static final int WIDTH = 32, HEIGHT = 32;

	public Block(GameEngine engine, Image texture, int id) {
		this.id = id;
		this.texture = texture;
		//---------
		if(id == 9) {
			solid = false;
		}
		else {
			solid = true;
		}
		//-----LADDER----
		if(id == 18 || id == 10) {
			solid  = false;
			ladder = true;
		}
		else {
			ladder = false;
		}
		//----------
		
		
	}
	


	public void update(double dt) {
		
	}
	
	public void draw(GameEngine engine, int x, int y) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(texture, x, y, WIDTH, HEIGHT);
		engine.restoreLastTransform();
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public boolean isLadder() {
		return ladder;
	}
	public int getId() {
		return id;
	}
}
