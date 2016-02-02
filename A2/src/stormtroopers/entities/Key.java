package stormtroopers.entities;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.GameEngine.AudioClip;
import stormtroopers.graphics.Animation;
import stormtroopers.graphics.Assets;

public class Key extends Item{

	private Assets asset;
	//private Animation animate;
	private AudioClip pickup;
	
	public Key(GameEngine engine, float x, float y) {
		super(x, y, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
		
		asset = new Assets(engine);
		//animate = new Animation(2, asset.getCoin(), engine);
		pickup = engine.loadAudio("res/key.wav");
	}
	
	//------
	
	public void update(MainGame engine, Player player, double dt) {
		//animate.update(engine);
		if((x <= player.x + DEFAULT_ITEM_WIDTH && x >= player.x - DEFAULT_ITEM_WIDTH) 
				&& (y <= player.y + DEFAULT_ITEM_HEIGHT && y >= player.y - DEFAULT_ITEM_HEIGHT)) {
			setExists(false);
			//engine.playAudio(pickup);
			engine.playAudio(pickup);
			//this.equals(null);
			
			//coin get picked up
		}
	}
	
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(asset.getKey(), 0, 0, width, height);
		engine.restoreLastTransform();
	}

}