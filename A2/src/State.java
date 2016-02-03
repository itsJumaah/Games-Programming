
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public abstract class State {
	
	//------------
	//STATE CLASS
	//------------
	public abstract void update(MainGame control, double dt);
	
	public abstract void draw(GameEngine engine);
	
	//--------------
	//STATE MANAGER
	//--------------
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
}
