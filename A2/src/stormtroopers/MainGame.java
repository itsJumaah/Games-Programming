package stormtroopers;

import java.awt.event.KeyEvent;

import stormtroopers.states.GameState;
import stormtroopers.states.MenuState;
import stormtroopers.states.SettingsState;
import stormtroopers.states.State;



public class MainGame extends GameEngine{

	
	public boolean up, down, left, right, space;
	
	private State gameState, menuState, settingsState;
	
	//--------------------
	//	INITIALIZE
	//--------------------
	public void init() {
		setWindowSize(1280, 720);
		
		up = false;
		down = false;
		left = false;
		right = false;
		space = false;
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		settingsState = new SettingsState(this);
		
		State.setState(gameState);
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
	}
}