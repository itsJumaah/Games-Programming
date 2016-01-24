package stormtroopers.entities;

public abstract class Creature extends Entity {

	protected int health;
	protected int platform;
	
	protected float speed;
	protected float xMove;
	protected float yMove;
	protected float jump;
	protected float gravity;
	protected float upwardSpeed;
	
	protected boolean midAir;
	
	public static final int   DEFAULT_HEALTH          = 10;
	public static final int   DEFAULT_CREATURE_WIDTH  = 32,
							  DEFAULT_CREATURE_HEIGHT = 32;
	
	public static final float DEFAULT_SPEED           = 120.0f;
	public static final float GRAVITY                 = 400;
	public static final float JUMP_POWER	          = -200;
	
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		
		health  = DEFAULT_HEALTH;
		speed   = DEFAULT_SPEED;
		jump    = JUMP_POWER;
		gravity = GRAVITY;
		
		platform = 600;
		midAir = false;
		upwardSpeed = 0;
		
	}
	
	public void move(double dt) {
		x += xMove * dt;
		y += yMove * dt;
		//----- GRAVITY TO ENABLE JUMP
		upwardSpeed += gravity * dt;
		y += upwardSpeed * dt;
		
		if(y > platform) {
			upwardSpeed = 0;
			midAir = false;
			y = platform;
		}
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
