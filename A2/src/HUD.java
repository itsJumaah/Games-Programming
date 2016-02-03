

public class HUD {
	
	public static boolean gameOver;
	public static int coins, level, death;
	private int score, delta, time, deathCost, startTime, coinValue;
	
	public HUD() {
		score = 0;
		coins = 0;
		time  = 0;
		level = 3;
		death = 0;
		startTime = 3000;
		deathCost = 1500;
		coinValue = 1000;
		gameOver = false;
		
	}
	
	public void update(GameEngine engine, double dt) {
		time++;
		delta = startTime - time - (death * deathCost);  //each coin worth 1000, max 3000 coins per map, and 3000 time per map
		score = (coins * coinValue) + delta;
		
		if(score <= 0) {
			gameOver = true;
		}
		else {
			gameOver = false;
		}
	}
	
	public void draw(GameEngine engine) {
		engine.changeColor(engine.white);
		engine.drawText(30, 500, "Level: " + Integer.toString(level), "Courier", 20);
		engine.drawText(150, 500, "Score: " + score, "Courier", 20);
		
	}

}
