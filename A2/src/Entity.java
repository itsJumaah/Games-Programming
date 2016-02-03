

import java.awt.Rectangle;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width 	= width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
		
	}

	public abstract void update(MainGame control, double dt);
	
	public abstract void draw(GameEngine engine);
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
