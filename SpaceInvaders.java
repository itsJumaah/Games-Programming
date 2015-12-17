import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class SpaceInvaders extends GameEngine {
	// Main Function
	public static void main(String args[]) {
		// Warning: Only call createGame in this function
		// Create a new SpaceInvaders
		createGame(new SpaceInvaders());
	}

	//-------------------------------------------------------
	// Game
	//-------------------------------------------------------

	// Keyboard
	boolean left, right;
	boolean gameOver;
	boolean win;

	//-------------------------------------------------------
	// Invaders
	//-------------------------------------------------------

	// Invader Variables
	double invaderX[], invaderY[];
	boolean invaderActive[];
	int invaderType[];
	Image invaderImages[];
	int numInvaders, maxInvaders;
	int invaderMode;
	double invaderDelay, invaderTimer;

	// Initialise Invader
	public void initInvaders() {
		// Initialise Invaders
		maxInvaders = 55;

		// Allocate Arrays
		invaderX = new double[maxInvaders];
		invaderY = new double[maxInvaders];
		invaderActive = new boolean[maxInvaders];
		invaderType = new int[maxInvaders];
		invaderImages = new Image[6];

		// Load Invader Images
		invaderImages[0] = loadImage("Images/Invader2.png");
		invaderImages[1] = loadImage("Images/Invader3.png");
		invaderImages[2] = loadImage("Images/Invader4.png");
		invaderImages[3] = loadImage("Images/Invader5.png");
		invaderImages[4] = loadImage("Images/Invader6.png");
		invaderImages[5] = loadImage("Images/Invader7.png");

		// Work out spacing
		double x_space = width()/12;
		double y_space = x_space-10;

		// Five Rows
		for(int y = 0; y < 5; y++) {
			// Eleven Invaders per row
			for(int x = 0; x < 11; x++) {
				// Set position
				invaderX[y*11 + x] = x_space   + x * x_space;
				invaderY[y*11 + x] = y_space/2 + y * y_space;

				// Set Invader to true
				invaderActive[y*11 + x] = true;

				// Set Invader Type
				if(y == 0) {
					// Top row is type 2
					invaderType[y*11 + x] = 2;
				} else if(y == 1 || y == 2) {
					// Next two rows are type 1
					invaderType[y*11 + x] = 1;
				} else {
					// Bottom two rows are type 0
					invaderType[y*11 + x] = 0;
				}
			}
		}

		// Invader move mode
		invaderMode = 0;

		// Invaders move once per second
		invaderDelay = 1.0;
		invaderTimer = 0.0;
	}

	// Update Invader
	public void updateInvaders(double dt) {
		// Increment Timer
		invaderTimer += dt;

		// If sufficient time has passed
		if(invaderTimer > invaderDelay) {
			// Decrement Timer
			invaderTimer -= invaderDelay;

			// Move invaders
			for(int i = 0; i < maxInvaders; i++) {
				// If invader is active
				if(invaderActive[i] == true) {
					// Move based on invader mode
					if(invaderMode == 0) {
						// Move Invader left
						invaderX[i] -= 5;
					} else if(invaderMode == 1) {
						// Move Invader down
						invaderY[i] += 5;
					} else if(invaderMode == 2) {
						// Move Invader right
						invaderX[i] += 5;
					} else if(invaderMode == 3) {
						// Move Invader right
						invaderX[i] += 5;
					} else if(invaderMode == 4) {
						// Move Invader down
						invaderY[i] += 5;
					} else if(invaderMode == 5) {
						// Move Invader left
						invaderX[i] -= 5;
					}
				}
			}

			// Increment mode
			invaderMode = (invaderMode + 1) % 6;

			// For all invaders
			for(int i = 0; i < maxInvaders; i++) {
				// Check if invader reaches the bottom
				if(invaderY[i] >= height()-10) {
					// Game Over - Lost
					gameOver = true;
					win = false;
				}
			}
		}

		// Check if all invaders are destroyed
		boolean destroyed = true;
		for(int i = 0; i < maxInvaders; i++) {
			// If invader is still alive
			if(invaderActive[i] == true) {
				// Not all destroyed
				destroyed = false;
				break;
			}
		}

		// If all invaders have been destroyed
		if(destroyed) {
			// Game is over
			gameOver = true;

			// Player has won
			win = true;
		}
	}

	// Draw Invader
	public void drawInvaders() {
		// Work out which frame to use
		int frame = ((int)(getTime()/1000.0)) % 2;

		// For all invaders
		for(int i = 0; i < maxInvaders; i++) {
			// If invader is active
			if(invaderActive[i] == true) {
				// Draw Invader as a white rectangle
				//changeColor(white);
				//drawSolidRectangle(invaderX[i]-10, invaderY[i]-7, 20, 14);

				// Draw Image
				drawImage(invaderImages[invaderType[i]*2 + frame], invaderX[i]-10, invaderY[i]-7, 20, 14);
			}
		}
	}
	//-------------------------------------------------------

	//-------------------------------------------------------
	// Cannon
	//-------------------------------------------------------

	// Cannon Variables
	double cannonX, cannonY;

	// Initialise Cannon
	public void initCannon() {
		cannonX = width()/2;
		cannonY = height()-6;
	}

	// Fire the Cannon
	public void fireCannon() {
		// Find an unfired shell
		for(int i = 0; i < maxShells; i++) {
			if(shellActive[i] == false) {
				// Start shell off at cannon position
				shellX[i] = cannonX;
				shellY[i] = cannonY;

				// Set shell to active
				shellActive[i] = true;

				break;
			}
		}
	}

	// Update Cannon
	public void updateCannon(double dt) {
		// Check left
		if(left) {
			// Move Cannon Left
			cannonX -= 100*dt;

			// Enforce Boundaries
			if(cannonX <= 15) {
				cannonX = 15;
			}
		}

		// Check right
		if(right) {
			// Move Cannon Right
			cannonX += 100*dt;

			// Enforce Boundaries
			if(cannonX >= width()-15) {
				cannonX = width()-15;
			}
		}
	}

	// Draw Cannon
	public void drawCannon() {
		// Draw Cannon as green rectangle
		changeColor(green);
		drawSolidRectangle(cannonX-15, cannonY-4, 30, 10);
		drawSolidRectangle(cannonX-13, cannonY-6, 26,  2);
		drawSolidRectangle(cannonX-2,  cannonY-12, 4,  6);
	}
	//-------------------------------------------------------

	//-------------------------------------------------------
	// Shells
	//-------------------------------------------------------

	// Shell Variables
	int maxShells;
	double shellX[], shellY[];
	boolean shellActive[];

	// Initialise Shells
	public void initShells() {
		// 3 Shells maximum
		maxShells = 3;

		// Allocate Arrays
		shellX = new double[maxShells];
		shellY = new double[maxShells];
		shellActive = new boolean[maxShells];

		// All shells inactive
		for(int i = 0; i < maxShells; i++) {
			shellActive[i] = false;
		}
	}

	// Update Shells
	public void updateShells(double dt) {
		// Update active shells
		for(int i = 0; i < maxShells; i++) {
			if(shellActive[i] == true) {
				// Move Shell
				shellY[i] += -250*dt;

				// Check if Shell has reached the top of the screen
				if(shellY[i] <= 0) {
					// Make shell inactive
					shellActive[i] = false;
				}
			}
		}
	}

	// Draw Shells
	public void drawShells() {
		// Draw active shells
		for(int i = 0; i < maxShells; i++) {
			if(shellActive[i] == true) {
				// Draw as a line
				drawSolidRectangle(shellX[i] - 2, shellY[i] - 5, 4, 10);
			}
		}
	}
	//-------------------------------------------------------

	// Initialise the game
	public void init() {
		// Initialise Window Size
		setWindowSize(500, 500);

		// Initialise Keyboard variables
		left = false;
		right = false;

		// Initialise Game Variables
		gameOver = false;
		win = false;

		// Initialise Invaders
		initInvaders();

		// Initialise Cannon
		initCannon();

		// Initialise Shells
		initShells();
	}

	// Updates the game
	public void update(double dt) {
		// If game is over
		if(gameOver) {
			// Don't update
			return;
		}

		// Update Invaders
		updateInvaders(dt);

		// Update Cannon
		updateCannon(dt);

		// Update Shells
		updateShells(dt);

		// For all invaders
		for(int i = 0; i < maxInvaders; i++) {
			// Check if invader is active
			if(invaderActive[i] == true) {
				// For all Shells
				for(int s = 0; s < maxShells; s++) {
					// Check if shell is active
					if(shellActive[s] == true) {
						// Check for a collision
						if(shellX[s] >= invaderX[i]-12 && shellX[s] <= invaderX[i]+12 &&
						   shellY[s] >= invaderY[i]-12 && shellY[s] <= invaderY[i]+12) {
							// Deactivate both
							shellActive[s] = false;
							invaderActive[i] = false;
						}
					}
				}
			}
		}
	}

	// This gets called any time the Operating System
	// tells the program to paint itself
	public void paintComponent() {
		// Clear the background to black
		changeBackgroundColor(black);
		clearBackground(500, 500);

		// Draw Invaders
		drawInvaders();

		// Draw Cannon
		drawCannon();

		// Draw Shells
		drawShells();

		// Check if game is over
		if(gameOver) {
			// Check if player won
			if(win) {
				// Draw Won
				changeColor(red);
				drawText(100, 100, "YOU WON!", "Arial", 50);
			} else {
				// Draw Lost
				changeColor(red);
				drawText(100, 100, "YOU LOST!", "Arial", 50);
			}
		}
	}

	// KeyPressed Event
	public void keyPressed(KeyEvent event) {
		// Left Arrow
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		// Right Arrow
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		// Space Button
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			// Fire Cannon
			fireCannon();
		}
	}

	// KeyReleased Event
	public void keyReleased(KeyEvent event) {
		// Left Arrow
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		// Right Arrow
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
	}
}