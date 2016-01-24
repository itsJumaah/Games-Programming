package stormtroopers.entities;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.graphics.Animation;
import stormtroopers.graphics.Assets;


public class Player extends Creature {

	private Assets assets;
	private Animation animCoin;
	
	
	public Player(GameEngine engine, float x, float y) {
	super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		assets = new Assets(engine);
		
		animCoin = new Animation(2, assets.getCoin(), engine);
	}
	
	//------------
	//MOVEMENT
	//------------
	
	public void update(MainGame engine, double dt) {
		checkInputs(engine);
		move(dt);
		
		animCoin.update(engine);
	}
	
	//---------
	//DRAWING
	//---------
	
	public void draw(GameEngine engine) {
		// Save the current transform
		engine.saveCurrentTransform();

		// Translate to the position of the player
		engine.translate(x, y);
		
		//TRANSLATE FUNCTION ISNT PUBLIC IT JUST SAYS VOID NO VISIBLITY???

		// Draw the actual player
		//engine.drawImage(assets.player, 0, 0, SQUARE_SIZE, SQUARE_SIZE);
		//engine.drawImage(animCoin.getCurrentFrame(), 0, 0, width, height);
		engine.drawImage(assets.getLeftGround(), 0, 0, width, height);
		
		

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
		else if (control.down) {
			yMove = speed;
		}
		else if (control.left) {
			xMove = -speed;
		}
		else if (control.right) {
			xMove = speed;
		}
		
		//-------JUMP
		if (control.space) {
			if(midAir != true) {
				upwardSpeed = jump;
				midAir = true;
			}
		}
		//--------
	}
	
}
