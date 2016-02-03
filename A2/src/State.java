

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
