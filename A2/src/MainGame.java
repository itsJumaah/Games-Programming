

import java.awt.event.KeyEvent;



public class MainGame extends GameEngine{

	
	public boolean up, down, left, right, space, x;
	
	private State gameState, menuState;
	
	//--------------------
	//	INITIALIZE
	//--------------------
	public void init() {
		setWindowSize(512, 512);
		
		up = false;
		down = false;
		left = false;
		right = false;
		space = false;
		x = false;
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
	
		State.setState(gameState);
		//State.setState(menuState);
	}
	//-----------------------
	//UPDATE VALUES AND DRAWS
	//-----------------------
	@Override
	public void update(double dt) {
		if(State.getState() != null) {
			State.getState().update(this, dt);
		}
		
	}

	@Override
	public void paintComponent() {
		
		if(State.getState() != null) {
			State.getState().draw(this);
		}
		
	}	
	
	//-------------------------------------------------------
	// Keyboard functions
	//-------------------------------------------------------

	// Called whenever a key is pressed
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			x = true;
		}
	}
	// Called whenever a key is released
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			x = false;
		}
	}
}