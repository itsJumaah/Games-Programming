

import java.awt.Color;

public class GameState extends State {
	
	private Map map1, map2, map3;
	private HUD hud;
	
	public GameState(GameEngine engine) {

		hud = new HUD();

		map1 = new Map(engine, "res/map1.stmap");
		map2 = new Map(engine, "res/map2.stmap");
		map3 = new Map(engine, "res/map3.stmap");
	
	}

	@Override
	public void update(MainGame control, double dt) {
		if(!HUD.gameOver) {
			if(HUD.level == 1) {
				Map.loadMap("res/map1.stmap");
				map1.update(control, dt);
			}
			else if (HUD.level == 2) {
				Map.loadMap("res/map2.stmap");
				map2.update(control, dt);
			}
			else if (HUD.level == 3) {
				Map.loadMap("res/map3.stmap");
				map3.update(control, dt);
			}
			
			hud.update(control, dt);
		}
	}

	@Override
	public void draw(GameEngine engine) {
		
		if(!HUD.gameOver) {
			if(HUD.level == 1) {
				map1.draw(engine);
			}
			else if (HUD.level == 2) {
				map2.draw(engine);
			}
			else if (HUD.level == 3) {
				map3.draw(engine);
			}
			
			hud.draw(engine);
		}
		else {
			
			engine.changeBackgroundColor(engine.black);
			engine.changeColor(engine.red);
			engine.drawText(150, 256, "GAME OVER", "Arial", 40);
		}
		
	}

}
