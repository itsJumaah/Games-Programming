package stormtroopers.states;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.entities.Player;
import stormtroopers.world.Block;
import stormtroopers.world.Map;

public class GameState extends State {
	
	private Player player;
	private Map map;
	private float x, y;
	
	public GameState(GameEngine engine) {
		x = 100f;
		y = 100f;
		player = new Player(engine, x, y);
		map = new Map("");
		
	
	}

	@Override
	public void update(MainGame control, double dt) {
		map.update();
		player.update(control, dt);
		
	}

	@Override
	public void draw(GameEngine engine) {
		map.draw(engine);
		player.draw(engine);
		
		
		
		
	}

}
