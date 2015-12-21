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
	
	AudioClip beep, score;

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
		
		if(up1 && player1PositionY > 50) {
			player1PositionY -= 500 * dt; 
		}
		else if(down1 && player1PositionY < (height() - 50)) {
			player1PositionY += 500 * dt;
		}
		
		//player 2
		player2PositionX = width() - 6;
//		
//		if(up2 && player2PositionY > 50) {
//			player2PositionY -= 500 * dt; 
//		}
//		else if(down2 && player2PositionY < (height() - 50)) {
//			player2PositionY += 500 * dt;
//		}

	}

	// Function to draw the player1
	public void drawPlayer1() {
		// Set the color to white
		changeColor(green);
		
		// Save the current transform
		saveCurrentTransform();

		
		// to move the position to the center
		translate(player1PositionX - 3, player1PositionY - 50); 

		// Draw the actual spaceship
		drawLine(0,  0,  0,  100, 6);

		// Restore last transform to undo the rotate and translate transforms
		restoreLastTransform();
	}
	
	// Function to draw the player2
	public void drawPlayer2() {
		// Set the color to white
		changeColor(green);

		// Save the current transform
		saveCurrentTransform();

		// to move the position to the center
		translate(player2PositionX + 3, player2PositionY - 50);

		// Draw the actual spaceship
		//drawLine((width() - 5),  0,  (width() - 5),  50, 5);
		drawLine(0,  0,  0,  100, 6);

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
		drawLine( 9 ,  5,  (width() - 9),  5, 6);
		//draw the lower horizontal line
		drawLine( 9 ,  (height() - 5),  (width() - 9),  (height() - 5), 6);
		//draw the doted line in the middle
		for(int i =0; i < height(); i=i+30) {
			drawLine((width()/2), i, (width()/2), i+10, 6);
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
		
		ballPositionX = 250;
		ballPositionY = 250;

		ballVelocityX = 200;
		ballVelocityY = 200;
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
		if(ballPositionY <= (8 + ballRadius) || ballPositionY >= (height() - 8 - ballRadius)) {
			playAudio(beep);
			if(ballVelocityY > 0) {
				ballVelocityY = (ballVelocityY *-1);// -10;
			}
			else {
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
		
		beep  = loadAudio("beep.wav");
		score = loadAudio("score.wav");
		

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
		// AI
		//-------------------------------------------------------
		//if the ball in the AI square
		if(ballPositionX >= (width()/2)) {
			if (ballPositionY > player2PositionY) {
				player2PositionY += 2;
			}
			else {
				player2PositionY -= 2;
			}
		}
		//if the ball in the player square
		//goes to the center
		else {
			if (player2PositionY < (height()/2)) {
				player2PositionY += dt * 100;
			}
			else {
				player2PositionY -= dt * 100;
			}
		}
		
		//-------------------------------------------------------
		// Add code to check for collisions
		//-------------------------------------------------------
		
		
		if(ballPositionX <= (8 + ballRadius)) {
			if(ballPositionY <= (player1PositionY + 50) && ballPositionY >= (player1PositionY -50)) {
				// Collision!
				playAudio(beep);
				//------BALL HIT EDGE
				if(ballPositionY <= (player1PositionY + 50) && ballPositionY >= (player1PositionY + 30)) {
					//bottom edge
					if(ballVelocityY > 0) {
						ballVelocityY = (ballVelocityY    ) +10;
					}
					else {
						ballVelocityY = (ballVelocityY *-1) -10;
					}
				}
				else if(ballPositionY >= (player1PositionY - 50) && ballPositionY <= (player1PositionY - 30)) {
					//top edge
					if(ballVelocityY > 0) {
						ballVelocityY = (ballVelocityY *-1) -10;
					}
					else {
						ballVelocityY = (ballVelocityY    ) +10;
					}
				}
				
				//----Ball hit center
				
				if(ballVelocityX > 0) {
					ballVelocityX = (ballVelocityX *-1) -10;
				}
				else {
					ballVelocityX = (ballVelocityX *-1) +10;
				}
			}
			else {
				playAudio(score);
			}
		}
		
		else if(ballPositionX >= (width() - 8 - ballRadius)) {
			if(ballPositionY <= (player2PositionY + 50) && ballPositionY >= (player2PositionY -50)) {
				// Collision!
				playAudio(beep);
				//------BALL HIT EDGE
				if(ballPositionY <= (player2PositionY + 50) && ballPositionY >= (player2PositionY + 30)) {
					//bottom edge
					if(ballVelocityY > 0) {
						ballVelocityY = (ballVelocityY    ) +10;
					}
					else {
						ballVelocityY = (ballVelocityY *-1) -10;
					}
				}
				else if(ballPositionY >= (player2PositionY - 50) && ballPositionY <= (player2PositionY - 30)) {
					//top edge
					if(ballVelocityY > 0) {
						ballVelocityY = (ballVelocityY *-1) -10;
					}
					else {
						ballVelocityY = (ballVelocityY    ) +10;
					}
				}
				
				//----Ball hit center
				if(ballVelocityX > 0) {
					ballVelocityX = (ballVelocityX *-1) -10;
				}
				else {
					ballVelocityX = (ballVelocityX *-1) +10;
				}
			}
			else {
				playAudio(score);
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
			if(score1 == 10) {
				changeColor(white);
				drawText(85, 250, "YOU WON!", "Arial", 50);
			}
			else if (score2 == 10) {
				changeColor(red);
				drawText(85, 250, "GAME OVER!", "Arial", 50);
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