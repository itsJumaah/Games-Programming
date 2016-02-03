
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.awt.Image;

public class GameState extends State {
	
	private Map map1, map2, map3;
	private HUD hud;
	private Assets asset;
	private Image bg;
	// -- game state to decide which state the game is on
	public GameState(GameEngine engine) {

		asset = new Assets(engine);
		hud = new HUD();

		map1 = new Map(engine, "res/map1.stmap");
		map2 = new Map(engine, "res/map2.stmap");
		map3 = new Map(engine, "res/map3.stmap");
		
		bg = asset.getHUD();
	
	}

	//updating the state
	@Override
	public void update(MainGame control, double dt) {
		if(!HUD.gameOver) {
			if(HUD.level == 1) {
				Map.loadMap("res/map1.stmap");
				map1.update(control, dt);
			}
			if (HUD.level == 2) {
				Map.loadMap("res/map2.stmap");
				map2.update(control, dt);
			}
			if (HUD.level == 3) {
				Map.loadMap("res/map3.stmap");
				map3.update(control, dt);
			}
			
			hud.update(control, dt);
		}
	}
	//drawing the state
	@Override
	public void draw(GameEngine engine) {
		
		if(!HUD.gameOver && HUD.level != 4) {
			if(HUD.level == 1) {
				//Map.closeDoor();
				map1.draw(engine);
			}
			if (HUD.level == 2) {
				//Map.closeDoor();
				map2.draw(engine);
			}
			if (HUD.level == 3) {
				//Map.closeDoor();
				map3.draw(engine);
			}
			
			hud.draw(engine);
		}
		
		else if (HUD.level == 4) { //if the player win
			engine.drawImage(asset.getScore(), 0, 0);
			engine.changeColor(engine.yellow);
			engine.drawText(240, 270, Integer.toString(Player.finalScore), "Arial", 40);
			
		}
		else {
			//if the player lose
			engine.drawImage(asset.getGameOver(), 0, 0);
		}
		
	}

}
