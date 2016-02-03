

//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class MenuState extends State {
	
	//Main menu class
	GameEngine.AudioClip music;
	private Assets asset;
	public static int selectedOption;
	
	public MenuState(GameEngine engine) {
		selectedOption = 0;
		
		asset = new Assets(engine);
		music = engine.loadAudio("res/music.wav");
		engine.startAudioLoop(music, 0.3f);
	}

	@Override
	public void update(MainGame control, double dt) {
		
		
		
	}

	@Override
	public void draw(GameEngine engine) {
		engine.drawImage(asset.getmBG(), 0, 0);
		//play
		if(selectedOption == 0) {
			engine.drawImage(asset.getPlayOver(), 128, 252);
		}
		else {
			engine.drawImage(asset.getPlay(), 128, 252);
		}
		
		//----
		//instructions
		if(selectedOption == 1) {
			engine.drawImage(asset.getInstOver(), 128, 324);
		}
		else {
			engine.drawImage(asset.getInst(), 128, 324);
		}
		
		//----
		//exit
		if(selectedOption == 2) {
			engine.drawImage(asset.getExitOver(), 128, 396);
		}
			
		else {
			engine.drawImage(asset.getExit(), 128, 396);
		}
		
	}
	
	

}
