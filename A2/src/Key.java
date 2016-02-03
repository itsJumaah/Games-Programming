

public class Key extends Item{

	private Assets asset;
	private GameEngine.AudioClip pickup;
	
	public Key(GameEngine engine, float x, float y) {
		super(x, y, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
		
		asset = new Assets(engine);
		
		pickup = engine.loadAudio("res/key.wav");
	}
	
	//------
	
	public void update(MainGame engine, Player player, double dt) {
		
		if((x <= player.x + DEFAULT_ITEM_WIDTH && x >= player.x - DEFAULT_ITEM_WIDTH) 
				&& (y <= player.y + DEFAULT_ITEM_HEIGHT && y >= player.y - DEFAULT_ITEM_HEIGHT)) {
			setExists(false);
			engine.playAudio(pickup);
			
			Map.openDoor();
			//key get picked up
		}
	}
	
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(asset.getKey(), 0, 0, width, height);
		engine.restoreLastTransform();
	}

}