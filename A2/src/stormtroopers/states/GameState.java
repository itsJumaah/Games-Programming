package stormtroopers.states;

import stormtroopers.GameEngine;
import stormtroopers.MainGame;
import stormtroopers.world.Map;

public class GameState extends State {
	
	private Map map;
	
	public GameState(GameEngine engine) {

		map = new Map(engine, "res/map.stmap");
	
	}

	@Override
	public void update(MainGame control, double dt) {
		map.update(control, dt);
	}

	@Override
	public void draw(GameEngine engine) {
		map.draw(engine);
		
		
	}

}
