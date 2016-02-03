
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class InstructionsState extends State {
	
	private Assets asset;
	
	public InstructionsState(GameEngine engine) {
		asset = new Assets(engine);
	}

	@Override
	public void update(MainGame control, double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GameEngine engine) {
		engine.drawImage(asset.getInstPage(), 0, 0);
		
	}

}
