//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.util.concurrent.TimeUnit;

public class Player extends Creature {

	private Assets asset;
	private Animation walkL, walkR, ladderA, jumpR, jumpL;
	private GameEngine.AudioClip death, level, splash, winnerWinnerChickenDinner;
	public static int finalScore;
	
	private boolean right, left;
	//----
	
	public Player(GameEngine engine, float x, float y) {
	super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		//- the player bounds (hit box)
		bounds.x = 8;
		bounds.y = 5;
		bounds.width  = 16;
		bounds.height = 25;
		//---- sound initializing
		death = engine.loadAudio("res/death.wav");
		level = engine.loadAudio("res/level.wav");
		splash = engine.loadAudio("res/water.wav");
		winnerWinnerChickenDinner = engine.loadAudio("res/game.wav");
		//---- assets and animation initializing
		
		asset = new Assets(engine);
		
		walkL   = new Animation(160, asset.getWalkL(), engine);
		walkR   = new Animation(160, asset.getWalkR(), engine);
		ladderA = new Animation(160, asset.getLadderA(), engine);
		jumpR   = new Animation(160, asset.getJumpL(), engine);
		jumpL   = new Animation(160, asset.getJumpR(), engine);
		// -- player starts facing right
		left = false;
		right = true;
	}
	
	//------------
	//MOVEMENT
	//------------
	
	public void update(MainGame engine, double dt) {
		
		checkInputs(engine); //check the user keys input
		move(dt); // movement from the creature class
		//----- animation updates
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
		//------ If the player hit a spike and die
		if(dead) {
			
			engine.playAudio(death, 0.3f);
			
			try {
				TimeUnit.SECONDS.sleep(1); //stops the game for 1 second to give a feel for the death event ;)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//respawning
			x = Map.playerX;
			y = Map.playerY;
			HUD.death++;
			
		}
		
		// if the player reach the door to next level
		
		if(levelup) {
			engine.playAudio(level);
			HUD.level++;
		}
		
		// if the player hit the under water splash
		
		if(enterwater) {
			engine.playAudio(splash);
		}
		
		//if the player reach the chest in the final map
		
		if(reachedChest) {
			finalScore = HUD.score;
			engine.playAudio(winnerWinnerChickenDinner);
			HUD.level++;
		}
		
	}
	
	//---------
	//DRAWING
	//---------
	
	public void drawingAnimated(GameEngine engine, MainGame control) {
		//animation controller
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
