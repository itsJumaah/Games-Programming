
//Game made by Team Stormtroopers: Bilal Jumaah   - 12232659
//								   Andrew Creevey - 12236284
//							       Jordan Smith   - 12194358

public class Item extends Entity{
	
	protected boolean exists;
	
	public static final boolean DEFAULT_EXISTS = true;
	public static final int     DEFAULT_ITEM_WIDTH  = 20,
			  				    DEFAULT_ITEM_HEIGHT = 20;
	//the base class of pickable items
	public Item(float x, float y, int width, int height) {
		super(x, y, width, height);
		exists = DEFAULT_EXISTS;
	}
	//------- getter if the item still exists
	public boolean isExists() {
		return exists;
	}
	//setter for the item if it exists

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	//-------- updting the item
	@Override
	public void update(MainGame control, double dt) {
		// TODO Auto-generated method stub
		
	}
	//drawing the item
	@Override
	public void draw(GameEngine engine) {
		// TODO Auto-generated method stub
		
	}
	
	

}
