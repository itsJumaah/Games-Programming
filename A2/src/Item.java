

public class Item extends Entity{
	
	protected boolean exists;
	
	public static final boolean DEFAULT_EXISTS = true;
	public static final int     DEFAULT_ITEM_WIDTH  = 20,
			  				    DEFAULT_ITEM_HEIGHT = 20;

	public Item(float x, float y, int width, int height) {
		super(x, y, width, height);
		exists = DEFAULT_EXISTS;
	}
//-------
	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
//--------
	@Override
	public void update(MainGame control, double dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GameEngine engine) {
		// TODO Auto-generated method stub
		
	}
	
	

}
