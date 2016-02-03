
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class HUD {
	
	//This class basically control the score HUD
	// its also the score manager
	
	public static boolean gameOver;
	public static int coins, level, death, score;

	private int delta, time, deathCost, startTime, coinValue;
	

	public HUD() {
		score = 0;
		coins = 0;
		time  = 0;
		level = 1;
		death = 0;
		startTime = 500; //intial score
		deathCost = 700; //each death will have this much penalty
		coinValue = 500; //value of single coin
		gameOver = false;

	}
	//--- update the score
	public void update(GameEngine engine, double dt) {
		
		time++;
		delta = startTime - time - (death * deathCost);  //each coin worth 500, max 1500 coins per map, and 500 to start with
		score = (coins * coinValue) + delta;
		
		if(score <= 0) { //if score is 0 game over you lost
			gameOver = true;
		}
		else {
			gameOver = false;
		}
	}
	//---- draw the score hud
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.changeColor(engine.black);
		engine.drawSolidRectangle(30, 493, 255, 16);
		engine.changeColor(engine.white);
		engine.drawText(32, 508, "Level: " + Integer.toString(level), "Courier", 20);
		engine.drawText(152, 508, "Score: " + score, "Courier", 20);
		engine.restoreLastTransform();
		
	}

}
