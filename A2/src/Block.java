//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.awt.Image;

public class Block {
	
	private final int id; //each block contain a unique ID
	private Image texture;
	private boolean solid, ladder, kill, next, splash, box; // to determine what kind of block it is
	
	public static final int WIDTH = 32, HEIGHT = 32; // block dimensions

	public Block(GameEngine engine, Image texture, int id) {
		this.id = id;
		this.texture = texture;
		checkID(id);
		
	}
	// -- check the block kind
	private void checkID(int id) {
		//--------- wall
		if(id == 9 || id == 15 || id == 11 || id == 4) {
			solid = false;
		}
		else {
			solid = true;
		}
		//-----LADDER----
		if(id == 18 || id == 10 || id == 21 || id == 16 || id == 13) {
			solid  = false;
			ladder = true;
		}
		else {
			ladder = false;
		}
		//----------spikes
		if(id == 5 || id == 6) {
			kill = true;
		}
		else {
			kill = false;
		}
		//----DOOR
		if(id == 15) {
			next = true;
		}
		else {
			next = false;
		}
		//-----water splash
		if(id == 4) {
			splash = true;
		}
		else {
			splash = false;
		}
		if(id == 14 || id == 7) {
			solid = false;
			box = true;
		}
		else {
			box = false;
		}
	}
	//-- Draw the block
	public void draw(GameEngine engine, int x, int y) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(texture, x, y, WIDTH, HEIGHT);
		engine.restoreLastTransform();
	}
	//-- block type getters
	public boolean isChest() {
		return box;
	}
	
	public boolean splash() {
		return splash;
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
	//-- id getter
	public int getId() {
		return id;
	}
}
