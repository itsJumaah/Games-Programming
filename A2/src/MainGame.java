
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

import java.awt.event.KeyEvent;

public class MainGame extends GameEngine {

	
	public boolean up, down, left, right;
	
	private State gameState, menuState, instructionState;
	
	//--------------------
	//	INITIALIZE
	//--------------------
	public void init() {
		setWindowSize(512, 512);
		
		up = false;
		down = false;
		left = false;
		right = false;
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		instructionState = new InstructionsState(this);
	
		//State.setState(gameState);
		State.setState(menuState);
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
	@Override
	public void keyPressed(KeyEvent e) {
		if(State.getState() == gameState) {
			keyPressedGame(e);
		}
		else if(State.getState() == menuState) {
			keyPressedMenu(e);
		}
		else if(State.getState() == instructionState) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				State.setState(menuState);
			}
		}
		
		
	}
	// MENU BUTTONS
	public void keyPressedMenu(KeyEvent e) {
		// up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(MenuState.selectedOption > 0) {
				MenuState.selectedOption--;
			}
		}
		// down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(MenuState.selectedOption < 2) {
				MenuState.selectedOption++;
			}
		}
		//enter
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(MenuState.selectedOption == 0) {
				State.setState(gameState); // starts the game
			}
			else if(MenuState.selectedOption == 1) {
				State.setState(instructionState);
			}
			else {
				System.exit(0);
			}
		}
		
	}
	
	//------------
	//GAME BUTTONS
	public void keyPressedGame(KeyEvent e) {
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
		
	}
	// Called whenever a key is released
	@Override
	public void keyReleased(KeyEvent e) {
		keyReleasedGame(e);
	}
	public void keyReleasedGame(KeyEvent e) {
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
	}
}