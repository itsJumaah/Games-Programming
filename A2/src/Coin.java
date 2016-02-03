
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class Coin extends Item{

	private Assets asset;
	private Animation animate;
	private GameEngine.AudioClip pickup;
	
	//-- everything about the coin item
	public Coin(GameEngine engine, float x, float y) {
		super(x, y, DEFAULT_ITEM_WIDTH, DEFAULT_ITEM_HEIGHT);
		
		asset = new Assets(engine);
		animate = new Animation(2, asset.getCoin(), engine);
		pickup = engine.loadAudio("res/coin.wav");
	}
	
	//------ updating the variables
	
	public void update(MainGame engine, Player player, double dt) {
		animate.update(engine); //updating animation
		if((x <= player.x + DEFAULT_ITEM_WIDTH && x >= player.x - DEFAULT_ITEM_WIDTH) 
				&& (y <= player.y + DEFAULT_ITEM_HEIGHT && y >= player.y - DEFAULT_ITEM_HEIGHT)) {
			setExists(false);
			
			engine.playAudio(pickup);
			HUD.coins++;
			
			//coin get picked up
		}
	}
	//----- drawing the coin animated
	public void draw(GameEngine engine) {
		engine.saveCurrentTransform();
		engine.translate(x, y);
		engine.drawImage(animate.getLoopFrame(), 0, 0, width, height);
		engine.restoreLastTransform();
	}

}
