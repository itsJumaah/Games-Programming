import java.util.concurrent.TimeUnit;


public class Player extends Creature {

	private Assets asset;
	private Animation walkL, walkR, ladderA, jumpR, jumpL;
	//private AudioClip death;
	private GameEngine.AudioClip death, level;
	
	private boolean right, left;
	
	
	public Player(GameEngine engine, float x, float y) {
	super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 8;
		bounds.y = 5;
		bounds.width = 16;
		bounds.height = 25;
		
		death = engine.loadAudio("res/death.wav");
		level = engine.loadAudio("res/level.wav");
		
		
		asset = new Assets(engine);
		
		walkL = new Animation(200, asset.getWalkL(), engine);
		walkR = new Animation(200, asset.getWalkR(), engine);
		ladderA = new Animation(200, asset.getLadderA(), engine);
		jumpR = new Animation(200, asset.getJumpL(), engine);
		jumpL = new Animation(200, asset.getJumpR(), engine);
		
		left = false;
		right = true;
	}
	
	//------------
	//MOVEMENT
	//------------
	
	public void update(MainGame engine, double dt) {
		
		checkInputs(engine);
		move(dt);
		if(engine.up || engine.down) {
			if(onLadder) {
				ladderA.update(engine);
			}
			else if(right) {
				jumpR.update(engine);
			}
			else if(left) {
				jumpL.update(engine);
			}
		}
		
		if(engine.left) {
			walkL.update(engine);
		}
		if(engine.right) {
			walkR.update(engine);
		}
		
		if(dead) {
			
			engine.playAudio(death, 0.3f);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//respawning
			x = Map.playerX;
			y = Map.playerY;
			HUD.death++;
			
		}
		
		if(levelup) {
			engine.playAudio(level);
			HUD.level++;
			
		}
		
	}
	
	//---------
	//DRAWING
	//---------
	
	public void drawingAnimated(GameEngine engine, MainGame control) {
		if(control.left) {
			left = true;
			right = false;
			engine.drawImage(walkL.getLoopFrame(), 0, 0, width, height);
		}
		else if(control.right) {
			left = false;
			right = true;
			engine.drawImage(walkR.getLoopFrame(), 0, 0, width, height);
		}
		else if(control.down && onLadder) {
			engine.drawImage(ladderA.getLoopFrame(), 0, 0, width, height);
		}
		else if(control.up && onLadder) {
			engine.drawImage(ladderA.getLoopFrame(), 0, 0, width, height);
		}
		else if(control.up && right && !onLadder) {
			engine.drawImage(jumpR.getLoopFrame(), 0, 0, width, height);
		}
		else if(control.up && left && !onLadder) {
			engine.drawImage(jumpL.getLoopFrame(), 0, 0, width, height);
			
		}
		else if(right){
			engine.drawImage(asset.getStandR(), 0, 0, width, height);
		}
		else if(left) {
			engine.drawImage(asset.getStandL(), 0, 0, width, height);
		}
	}
	
	//----
	public void draw(GameEngine engine) {
		// Save the current transform
		engine.saveCurrentTransform();

		// Translate to the position of the player
		engine.translate(x, y);
		if(dead) {
			engine.drawImage(asset.getDeath(), 0, 0, width, height);
			
		}
		else {
			drawingAnimated(engine, (MainGame) engine);
		}
		// Restore last transform to undo the rotate and translate transforms
		engine.restoreLastTransform();
	}
	//----------------
	//KEYBOARD MANAGER
	//----------------
	private void checkInputs(MainGame control) {

		xMove = 0;
		yMove = 0;
		
		if(control.up) {
			yMove = -speed;
		}
		if (control.down) {
			yMove = speed;
		}
		if (control.left) {
			xMove = -speed;
		}
		if (control.right) {
			xMove = speed;
		}
		
	}
	
}
