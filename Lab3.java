import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab3 extends GameEngine {
	// Main Function
	public static void main(String args[]) {
		// Warning: Only call createGame in this function
		// Create a new Lab3
		createGame(new Lab3());
	}

	//-------------------------------------------------------
	// Game
	//-------------------------------------------------------
	
	// Booleans to keep track of whether a key is pressed or not
	boolean left, right, up, attack;
	boolean gameOver;
	int score;
	String sscore;

	//-------------------------------------------------------
	// Spaceship
	//-------------------------------------------------------

	// Spaceship position & Velocity
	double spaceshipPositionX, spaceshipPositionY;
	double spaceshipVelocityX, spaceshipVelocityY;

	// Spaceship angle
	double spaceshipAngle;

	// Code to update 'move' the spaceship
	public void updateSpaceship(double dt) {
		if(up == true) {
			// Increase the velocity of the spaceship
			// as determined by the angle
			spaceshipVelocityX +=  sin(spaceshipAngle) * 250 * dt;
			spaceshipVelocityY += -cos(spaceshipAngle) * 250 * dt;
		}

		// If the user is holding down the left arrow key
		// Make the spaceship rotate anti-clockwise
		if(left == true) {
			spaceshipAngle -= 180 * dt;
		}

		// If the user is holding down the right arrow key
		// Make the spaceship rotate clockwise
		if(right == true) {
			spaceshipAngle += 180 * dt;
		}

		
	
		// Make the spaceship move forward
		spaceshipPositionX += spaceshipVelocityX * dt;
		spaceshipPositionY += spaceshipVelocityY * dt;

		//////////////////
		

		//warping back
		if(spaceshipPositionX >= 500) {
			spaceshipPositionX += spaceshipVelocityX * dt - 500;
		}
		else if(spaceshipPositionX <= 0) {
			spaceshipPositionX += spaceshipVelocityX * dt + 500;
		}


		if(spaceshipPositionY >= 500) {
			spaceshipPositionY += spaceshipVelocityY * dt - 500;
		}
		else if(spaceshipPositionY <= 0) {
			spaceshipPositionY += spaceshipVelocityY * dt + 500;
		}
		
	}

	// Function to draw the spaceship
	public void drawSpaceship() {
		// Set the color to white
		changeColor(green);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the asteroid
		translate(spaceshipPositionX, spaceshipPositionY);

		// Rotate the drawing context around the angle of the asteroid
		rotate(spaceshipAngle);

		// Draw the actual spaceship
		drawLine(-10,  10,  10,  10);
		drawLine( 10,  10,   0, -20);
		drawLine(  0, -20, -10,  10);

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();
	}

	//-------------------------------------------------------
	// Laser
	//-------------------------------------------------------

	// Laser position & Velocity
	double laserPositionX, laserPositionY;
	double laserVelocityX, laserVelocityY;

	// Laser Angle
	double laserAngle;

	// Laser active
	boolean laserActive = false;

	// Function to shoot a new laser
	public void fireLaser() {
		if(attack == true && laserActive == false) {
			// Set the laser position as the current spaceship position
			laserPositionX = spaceshipPositionX;
			laserPositionY = spaceshipPositionY;

			
			// And make it move in the same direction as the spaceship is facing
			laserVelocityX =  sin(spaceshipAngle) * 250;
			laserVelocityY = -cos(spaceshipAngle) * 250;
			
			// And face the same direction as the spaceship
			laserAngle = spaceshipAngle;

			// Set it to active
			laserActive = true;
		}
		
	}

	// Function to update 'move' the laser
	public void updateLaser(double dt) {
		// Update the laser
		fireLaser();
		laserPositionX += laserVelocityX * dt;
		laserPositionY += laserVelocityY * dt;

		if(laserPositionX >= 500 || laserPositionX <= 0 || laserPositionY >= 500 || laserPositionY <= 0) {
			laserActive = false;
		}

	}

	// Function to draw the laser
	public void drawLaser() {
		// Draw the laser
		
		// Set the color to white
		changeColor(red);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the asteroid
		translate(laserPositionX, laserPositionY);

		// Rotate the drawing context around the angle of the asteroid
		rotate(laserAngle);

		// Draw the actual spaceship
		drawLine(0,  0, 0,  5);

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();

	}

	//-------------------------------------------------------
	// Asteroid
	//-------------------------------------------------------

	// Asteroid Position & Velocity
	double asteroidPositionX, asteroidPositionY;
	double asteroidVelocityX, asteroidVelocityY;

	// Asteroid Radius
	double asteroidRadius;

	public void randomAsteroid() {
		// Generate a random asteroid
		asteroidPositionX = rand(500);
		asteroidPositionY = rand(500);

		asteroidVelocityX = -50 + rand(100);
		asteroidVelocityY = -50 + rand(100);
	}

	// Function to update 'move' the asteroid
	public void updateAsteroid(double dt) {
		// Update the asteroid


		asteroidPositionX += asteroidVelocityX * dt;
		asteroidPositionY += asteroidVelocityY * dt;

		//warping back
		if(asteroidPositionX >= 500) {
			asteroidPositionX += asteroidVelocityX * dt - 500;
		}
		else if(asteroidPositionX <= 0) {
			asteroidPositionX += asteroidVelocityX * dt + 500;
		}


		if(asteroidPositionY >= 500) {
			asteroidPositionY += asteroidVelocityY * dt - 500;
		}
		else if(asteroidPositionY <= 0) {
			asteroidPositionY += asteroidVelocityY * dt + 500;
		}
	}

	// Function to draw the asteroid
	public void drawAsteroid() {
// Set the color to white
		changeColor(white);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the asteroid
		translate(asteroidPositionX, asteroidPositionY);

		// Rotate the drawing context around the angle of the asteroid
		//rotate(spaceshipAngle);

		// Draw the actual spaceship
		// drawLine(0,  0,  10,  0);
		// drawLine(10,  0,  10,  -10);
		// drawLine(10,  -10,  0,  -10);
		// drawLine(0,  -10,  0,  0);

		drawText(0 , 0, "❄");

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();

		// Draw the asteroid
	}

	//-------------------------------------------------------
	// Game
	//-------------------------------------------------------

	public void init() {
		// Initialise game boolean
		gameOver = false;

		//scores
		score = 0;
		sscore = "0";

		// Initialise key booleans
		left   = false;
		right  = false;
		up     = false;
		attack = false;

		// Initialise Spaceship
		spaceshipPositionX = 250; spaceshipPositionY = 250;
		spaceshipVelocityX = 0;   spaceshipVelocityY = 0;
		spaceshipAngle = 0;

		// Initialise Laser
		laserPositionX = 0; laserPositionY = 0;
		laserVelocityX = 0; laserVelocityY = 0;
		laserAngle = 0;
		laserActive = false;
		
		// Initialise Asteroid
		asteroidPositionX = 0; asteroidPositionY = 0;
		asteroidVelocityX = 0; asteroidVelocityY = 0;
		asteroidRadius = 20;

		randomAsteroid();

	}

	// Updates the display
	public void update(double dt) {
		// If the game is over
		if(gameOver == true) {
			// Don't try to update anything.
			return;
		}

		// Update the spaceship
		updateSpaceship(dt);
		
		// Update the laser
		updateLaser(dt);

		// Update Asteroid
		updateAsteroid(dt);

		//-------------------------------------------------------
		// Add code to check for collisions
		//-------------------------------------------------------
		//laser and astroid
		if (distance(laserPositionX, laserPositionY, asteroidPositionX, asteroidPositionY) <= 20) {
			System.out.println("Hit");

			randomAsteroid();
			laserActive = false;

			score++;
		}

		//astroid and ship
		if (distance(spaceshipPositionX, spaceshipPositionY, asteroidPositionX, asteroidPositionY) <= 20) {
			System.out.println("Ded");
			gameOver = true;
		}

		sscore = Integer.toString(score);


	}

	// This gets called any time the Operating System
	// tells the program to paint itself
	public void paintComponent() {
		// Clear the background to black
		changeBackgroundColor(black);
		clearBackground(500, 500);
		changeColor(white);
		
		drawText(1, 20, "Score:", "Arial", 20);
		drawText(65, 20, sscore, "Arial", 20);

		// If the game is not over yet
		if(gameOver == false) {
			// Paint the Spaceship
			drawSpaceship();

			// Paint the Asteroid
			drawAsteroid();

			// Paint the laser (if it's active)
			
			drawLaser();
			
		} else {
			// If the game is over
			// Display GameOver text
			changeColor(white);
			drawText(85, 250, "GAME OVER!", "Arial", 50);
		}
	}

	// Called whenever a key is pressed
	public void keyPressed(KeyEvent e) {
		// The user pressed left arrow
		if(e.getKeyCode() == KeyEvent.VK_LEFT)  {
			left  = true;
		}
		// The user pressed right arrow
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		// The user pressed up arrow
		if(e.getKeyCode() == KeyEvent.VK_UP)    {
			up    = true;
		}

		// The user pressed space bar
		if(e.getKeyCode() == KeyEvent.VK_SPACE)    {
			attack = true;
		}
	}

	// Called whenever a key is released
	public void keyReleased(KeyEvent e) {
		// The user released left arrow
		if(e.getKeyCode() == KeyEvent.VK_LEFT)  {
			left  = false;
		}
		// The user released right arrow
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		// The user released up arrow
		if(e.getKeyCode() == KeyEvent.VK_UP)    {
			up    = false;
		}

		// The user released space bar
		if(e.getKeyCode() == KeyEvent.VK_SPACE)    {
			attack = false;
		}
	}
}