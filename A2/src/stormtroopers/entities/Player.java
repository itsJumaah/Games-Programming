package stormtroopers.entities;

import java.awt.Color;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.graphics.Assets;


public class Player extends Creature {

	private Assets asset;
	//private Animation animCoin;
	
	
	public Player(GameEngine engine, float x, float y) {
	super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		asset = new Assets(engine);
		
		//animCoin = new Animation(2, asset.getCoin(), engine);
		
		bounds.x = 8;
		bounds.y = 5;
		bounds.width = 16;
		bounds.height = 25;
	}
	
	//------------
	//MOVEMENT
	//------------
	
	public void update(MainGame engine, double dt) {
		checkInputs(engine);
		move(dt);
		
		//animCoin.update(engine);
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
		engine.drawImage(asset.getPlayer(), 0, 0, width, height);
		
		engine.changeColor(Color.red);
		//engine.drawSolidRectangle((int) bounds.x, (int) bounds.y, bounds.width, bounds.height); //void public?
		
		

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
		
		//-------JUMP
		if (control.space) {
			if(midAir != true) {
				yMove = jump;
				midAir = true;
			}
		}
		//--------
	}
	
}
