import java.awt.event.*;


public class Assignment1 extends GameEngine {
	// Main Function
	public static void main(String args[]) {
		// Warning: Only call createGame in this function
		// Create a new A1
		createGame(new Assignment1(), 120);
	}

	//-------------------------------------------------------
	// Game
	//-------------------------------------------------------
	
	// Booleans to keep track of whether a key is pressed or not
	boolean up1, down1, up2, down2, gameOver;
	
	int score1, score2;
	String sscore1, sscore2;
	
	AudioClip beep;

	//-------------------------------------------------------
	// players
	//-------------------------------------------------------

	// player1 position
	double player1PositionX, player1PositionY;
	//player 2 position
	double player2PositionX, player2PositionY;


	// Code to update 'move' the spaceship
	public void updatePlayers(double dt) {
		//update player 1
		player1PositionX = 6;
		
		if(up1 && player1PositionY > 10) {
			player1PositionY -= 500 * dt; 
		}
		else if(down1 && player1PositionY < (height() - 50)) {
			player1PositionY += 500 * dt;
		}
		
		//player 2
		player2PositionX = width() -6;
		
		if(up2 && player2PositionY > 10) {
			player2PositionY -= 500 * dt; 
		}
		else if(down2 && player2PositionY < (height() - 50)) {
			player2PositionY += 500 * dt;
		}

	}

	// Function to draw the player1
	public void drawPlayer1() {
		// Set the color to white
		changeColor(green);
		
		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the ball
		translate(player1PositionX, player1PositionY);

		// Draw the actual spaceship
		drawLine(0,  0,  0,  100, 5);

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();
	}
	
	// Function to draw the player2
	public void drawPlayer2() {
		// Set the color to white
		changeColor(green);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the ball
		translate(player2PositionX, player2PositionY);

		// Draw the actual spaceship
		//drawLine((width() - 5),  0,  (width() - 5),  50, 5);
		drawLine(0,  0,  0,  100, 5);

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();
	}
	
	public void drawLines() {
		// Set the color to white
		changeColor(white);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the ball
		//translate(height(), width());

		// Draw upper horizonal line
		drawLine( 10 ,  5,  (width() - 10),  5, 5);
		//draw the lower horizontal line
		drawLine( 10 ,  (height() - 5),  (width() - 10),  (height() - 5), 5);
		//draw the doted line in the middle
		for(int i =0; i < height(); i=i+30) {
			drawLine((width()/2), i, (width()/2), i+10, 5);
		}
		
		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();
	}

	

	//-------------------------------------------------------
	// ball
	//-------------------------------------------------------

	// ball Position & Velocity
	double ballPositionX, ballPositionY;
	double ballVelocityX, ballVelocityY;

	// ball Radius
	double ballRadius;

	public void createBall() {
		// Generate a new ball
		
		ballPositionX = rand(400);
		ballPositionY = rand(400);

		ballVelocityX = 100;
		ballVelocityY = 100;
	}

	// Function to update 'move' the asteroid
	public void updateBall(double dt) {
		// Move the asteroid
		ballPositionX += ballVelocityX * dt;
		ballPositionY += ballVelocityY * dt;

		//if ball is out, then score
		if(ballPositionX <= 0) {
			score2++;
			createBall();
		}
		else if(ballPositionX >= width()) {
			score1++;
			createBall();
		}
		
		// If the ball hit the edge of the screen it bounce off and the speed increases
		if(ballPositionY <= 0 || ballPositionY >= height()) {
			if(ballVelocityY > 0) {
				playAudio(beep);
				ballVelocityY = (ballVelocityY *-1);// -10;
			}
			else {
				playAudio(beep);
				ballVelocityY = (ballVelocityY *-1);// +10;
			}
		}
	}

	// Function to draw the asteroid
	public void drawBall() {
		// Set the color to white
		changeColor(white);

		// Save the current transform
		saveCurrentTransform();

		// ranslate to the position of the asteroid
		translate(ballPositionX, ballPositionY);

		drawSolidCircle(0, 0, ballRadius);

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
		score1  = 0;
		sscore1 = "0";
		
		score2  = 0;
		sscore2 = "0";

		// Initialise key booleans
		up1   = false;
		down1 = false;
		
		up2   = false;
		down2 = false;

		// Initialise players
		player1PositionX = 0; player1PositionY = 250;
		player2PositionX = 0; player2PositionY = 250;

		// Initialise ball
		ballPositionX = 0; ballPositionY = 0;
		ballVelocityX = 0; ballVelocityY = 0;
		
		ballRadius = 7;

		createBall();
		
		//Sound?!
		
		beep = loadAudio("beep.wav");
		

	}

	// Updates the display
	public void update(double dt) {
		// If the game is over
		if(gameOver == true) {
			// Don't try to update anything.
			return;
		}
		
		
		// Update the players
		updatePlayers(dt);

		// Update ball
		updateBall(dt);
		
		sscore1 = Integer.toString(score1);
		sscore2 = Integer.toString(score2);
		
		if(score1 == 10) {
			gameOver = true;
			
		} 
		else if (score2 == 10) {
			gameOver = true;
		}

		//-------------------------------------------------------
		// Add code to check for collisions
		//-------------------------------------------------------

		// Detect Collision between Spaceship and Asteroid
		if(distance(player1PositionX, player1PositionY, ballPositionX, ballPositionY) < 100) {
			// Collision!
			System.out.println("player 1 hit the ball");
			
			if(ballVelocityX >= 0) {
				playAudio(beep);
				ballVelocityX = (ballVelocityX *-1) -10;
			}
			else {
				playAudio(beep);
				ballVelocityX = (ballVelocityX *-1) +10;
			}
		
		}
		
		if(distance(player2PositionX, player2PositionY, ballPositionX, ballPositionY) < 100) {
			// Collision!
			System.out.println("player 2 hit the ball");
			
			if(ballVelocityX >= 0) {
				playAudio(beep);
				ballVelocityX = (ballVelocityX *-1) -10;
			}
			else {
				playAudio(beep);
				ballVelocityX = (ballVelocityX *-1) +10;
			}
			
		}
		

	}

	// This gets called any time the Operating System
	// tells the program to paint itself
	public void paintComponent() {
		// Clear the background to black
		changeBackgroundColor(black);
		clearBackground(500, 500);
		changeColor(white);
		
		//score1 left
		drawText(50, 50, sscore1, "Arial", 30);
		//score2 right
		drawText((width()-50), 50, sscore2, "Arial", 30);

		// If the game is not over yet
		if(gameOver == false) {
			//lines
			drawLines();
			
			// Paint the players
			drawPlayer1();
			drawPlayer2();
			// Paint the ball
			drawBall();

			
		} 
		else {
			// If the game is over
			// Display GameOver text
			changeColor(white);
			//drawText(85, 250, "GAME OVER!", "Arial", 50);
			if(score1 == 10) {
				drawText(75, 250, "PLAYER 1 WINS!", "Arial", 50);
			}
			else if (score2 == 10) {
				drawText(75, 250, "PLAYER 2 WINS!", "Arial", 50);
			}
		}
	}

	// Called whenever a key is pressed
	public void keyPressed(KeyEvent e) {
		// The user pressed w
		if(e.getKeyCode() == KeyEvent.VK_W)  {
			up1  = true;
		}
		// The user pressed s
		if(e.getKeyCode() == KeyEvent.VK_S) {
			down1 = true;
		}
		// The user pressed up
		if(e.getKeyCode() == KeyEvent.VK_UP)    {
			up2    = true;
		}

		// The user pressed down
		if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
			down2 = true;
		}
	}

	// Called whenever a key is released
	public void keyReleased(KeyEvent e) {
		// The user released w
		if(e.getKeyCode() == KeyEvent.VK_W)  {
			up1  = false;
		}
		// The user released s
		if(e.getKeyCode() == KeyEvent.VK_S) {
			down1 = false;
		}
		// The user released up
		if(e.getKeyCode() == KeyEvent.VK_UP)    {
			up2    = false;
		}

		// The user released down
		if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
			down2 = false;
		}
	}
}