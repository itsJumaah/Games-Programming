
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.awt.Image;

public class Animation {
	
	private int speed, index, num;
	private Image[] frames;
	
	private long lastTime, timer;
	
	public Animation(int speed, Image[] frames, GameEngine engine) {
		this.speed = speed;
		this.frames = frames;
		
		index = 0;
		timer = 0;
		num	  = 0;
		
		lastTime = engine.getTime();
		
	}
	
	//--- updating the variables
	public void update(GameEngine engine) {
		timer += engine.getTime() - lastTime;
		lastTime = engine.getTime();
		
		if(timer > speed) {
			num++;
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	//----GETTERS
	
	//---------
	public Image getLoopFrame() {
		return frames[index];
	}
	//---------
	public Image getAltFrame() {
		return frames[num];
	}
	//--------
	public int getFrameNum() {
		return num;
	}
	public void setFrameNum(int num) {
		this.num = num;
	}
	
}
