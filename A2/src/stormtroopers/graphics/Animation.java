package stormtroopers.graphics;

import java.awt.Image;
import stormtroopers.GameEngine;

public class Animation {
	
	private int speed, index;
	private Image[] frames;
	
	private long lastTime, timer;
	
	public Animation(int speed, Image[] frames, GameEngine engine) {
		this.speed = speed;
		this.frames = frames;
		
		index = 0;
		timer = 0;
		lastTime = engine.getTime();
		
	}
	
	
	public void update(GameEngine engine) {
		timer += engine.getTime() - lastTime;
		lastTime = engine.getTime();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
	
	public void setCurrentFrame(int index) {
		this.index = index;
	}
	
	public Image getCurrentFrame() {
		return frames[index];
		
	}

}
