
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class Key extends Item {

	private Assets asset;
	private GameEngine.AudioClip pickup;

	//---- Everything about the key entity
	public Key(GameEngine engine, float x, float y) {
		super(x, y, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
		
		asset = new Assets(engine);
		
		pickup = engine.loadAudio("res/key.wav");
		
		
	}
	
	//------ updating the key
	
	public void update(MainGame engine, Player player, double dt) {
		Map.closeDoor(); // the door is always closed
		
		if((x <= player.x + DEFAULT_ITEM_WIDTH && x >= player.x - DEFAULT_ITEM_WIDTH) 
				&& (y <= player.y + DEFAULT_ITEM_HEIGHT && y >= player.y - DEFAULT_ITEM_HEIGHT)) {
			setExists(false);
			engine.playAudio(pickup);
			
			Map.openDoor(); //unless the key is picked up
		}
	}
	//--- drawing the key
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(asset.getKey(), 0, 0, width, height);
		engine.restoreLastTransform();
	}

}