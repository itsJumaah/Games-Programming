

import java.awt.Image;

public class Block {
	
	//WORLD
	private final int id;
	private Image texture;
	private boolean solid, ladder, kill, next;
	
	public static final int WIDTH = 32, HEIGHT = 32;

	public Block(GameEngine engine, Image texture, int id) {
		this.id = id;
		this.texture = texture;
		//---------
		if(id == 9 || id == 15) {
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
		if(id == 5 || id == 6) {
			kill = true;
		}
		else {
			kill = false;
		}
		//----
		if(id == 15) {
			next = true;
		}
		else {
			next = false;
		}
		
	}
	


	public void update(double dt) {
		
	}
	
	public void draw(GameEngine engine, int x, int y) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(texture, x, y, WIDTH, HEIGHT);
		engine.restoreLastTransform();
	}
	
	public boolean isKill() {
		return kill;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public boolean isLadder() {
		return ladder;
	}
	
	public boolean isDoor() {
		return next;
	}
	public int getId() {
		return id;
	}
}
