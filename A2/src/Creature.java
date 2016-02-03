public abstract class Creature extends Entity {

	
	
	protected int health;
	
	protected float speed;
	protected float xMove;
	protected float yMove;
	protected float jump;
	protected float gravity;
	protected float upwardSpeed;
	
	protected boolean onLadder, dead, levelup;
	
	public static final int   DEFAULT_HEALTH          = 10;
	public static final int   DEFAULT_CREATURE_WIDTH  = 32,
							  DEFAULT_CREATURE_HEIGHT = 32;
	
	public static final float DEFAULT_SPEED           = 150.0f;
	public static final float GRAVITY                 = 350.0f;
	public static final float JUMP_POWER	          = 800.0f;
	
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		
		health  = DEFAULT_HEALTH;
		speed   = DEFAULT_SPEED;
		jump    = -JUMP_POWER;
		gravity = GRAVITY;
		upwardSpeed = 0;
		onLadder = false;
		dead = false;
		levelup = false;
		
	}
	
	public void move(double dt) {
		
		if(isDoor((int)x/Block.WIDTH , (int)y/Block.HEIGHT) && isDoor((int)x / Block.WIDTH, (int) y / Block.HEIGHT)) {
			levelup = true;
		}
		else {
			levelup = false;
		}
		
		moveX(dt);
		moveY(dt);
		jump(dt);
		
		
	}
	
	public void moveX(double dt) {
		//-----Moving Right
		if(xMove > 0) {
			int tempX = (int) (x + (xMove * dt) + bounds.x + bounds.width) / Block.WIDTH;
			
			if(!collisionWithBlock(tempX, (int) (((y + bounds.y) / Block.HEIGHT) -100)) 
					&& !collisionWithBlock(tempX, (int) (((y + bounds.y + bounds.height) / Block.HEIGHT) -0.5))) {
				x += xMove * dt;
			}
			
			else {
				x = tempX * Block.WIDTH - bounds.x - bounds.width - 0.1f;
			}
		}
		//-----Moving left
		else if(xMove < 0) {
			int tempX = (int) (x + (xMove * dt) + bounds.x) / Block.WIDTH;
			
			//----
			if(!collisionWithBlock(tempX, (int) (((y + bounds.y) / Block.HEIGHT ) -100)) 
					&& !collisionWithBlock(tempX, (int) (((y + bounds.y + bounds.height) / Block.HEIGHT) -0.5))) {
				x += xMove * dt;
			}
			else {
				x = tempX * Block.WIDTH + Block.WIDTH - bounds.x + 0.1f;
			}
		}
	}
	
	public void moveY(double dt) {
		//----Going Up
		if(yMove < 0) {
			int tempY = (int) (y + (yMove * dt)+ bounds.y) / Block.HEIGHT; //top edge
			
			//---
			
			if(onLadder((int) (x + bounds.x) / Block.WIDTH, tempY)) {
				onLadder = true;
				if(!collisionWithBlock((int) (x + bounds.x) / Block.WIDTH, tempY ) 
						&& !collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.WIDTH, tempY)) {
					
					y += yMove * dt;
				}
				else {
					y = tempY * Block.HEIGHT + Block.HEIGHT - bounds.y + 0.1f;
				}
			}
		}
		//----Going Down
		if(yMove > 0) {
			int tempY = (int) (y + (yMove * dt) + bounds.y + bounds.height) / Block.HEIGHT; //bottom edge
			
			//--
			if(onLadder((int) (x + bounds.x) / Block.WIDTH, tempY)) {
				onLadder = true;
				if(!collisionWithBlock((int) (x + bounds.x) / Block.WIDTH, tempY) 
						&& !collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.WIDTH, tempY)) {
					y += yMove * dt;
				}
				else {
					y = tempY * Block.HEIGHT - bounds.y - bounds.height - 0.1f;
				}
			}
		}
	}
	
	public void jump(double dt) {
		//----- GRAVITY TO ENABLE JUMP
		
		int tempY = (int) (y + (yMove * dt) + bounds.y + bounds.height) / Block.HEIGHT; //bottom edge
		if(!collisionWithSpike((int) (x + bounds.x)  / Block.WIDTH , tempY) 
				&& !collisionWithSpike((int) (x + bounds.x + bounds.width) / Block.WIDTH, tempY)) {
			
			
		
			dead = false;
			
			if(!onLadder((int) (x + bounds.x)  / Block.WIDTH , tempY) 
					&& !onLadder((int) (x + bounds.x + bounds.width) / Block.WIDTH, tempY)) {
				onLadder = false;
				upwardSpeed += gravity * dt;
				y += upwardSpeed * dt;
	
				if(!collisionWithBlock((int) (x + bounds.x)  / Block.WIDTH , tempY) 
						&& !collisionWithBlock((int) (x + bounds.x + bounds.width) / Block.WIDTH, tempY)) {
	
					y += yMove * dt;
					
				}
				else {
					
					upwardSpeed = 0;
					y = tempY * Block.HEIGHT - bounds.height - bounds.y;
					
					
				}
			}
		}
		else {
			dead = true;
		}
	}
	//----------
	protected boolean collisionWithBlock(int x, int y) {
		return Map.getBlock(x, y).isSolid();
	}
	
	protected boolean collisionWithSpike(int x, int y) {
		return Map.getBlock(x, y).isKill();
	}
	
	protected boolean onLadder(int x, int y) {
		return Map.getBlock(x, y).isLadder();
	}
	
	protected boolean isDoor(int x, int y) {
		return Map.getBlock(x, y).isDoor();
	}
	
	//------------GETTERS AND SETTERS

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
