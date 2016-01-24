package stormtroopers.world;

import java.awt.Image;

import stormtroopers.GameEngine;
import stormtroopers.graphics.Assets;

public class MakeBlock extends Block {
	
	private Assets asset;
	
	private static Block[] block;
	

	public static  Block leftGround, midGround, rightGround, underGround;

	public MakeBlock(GameEngine engine, Image texture, int id) {
		super(engine, texture, id);
		
		asset = new Assets(engine);
		
		setBlock(new MakeBlock[256]);
		leftGround  = new Ground(engine, asset.getLeftGround(),  0);
//		rightGround = new Ground(engine, asset.getRightGround(), 1);
//		midGround   = new Ground(engine, asset.getMidGround(),   2);
//		underGround = new Ground(engine, asset.getUnderGround(), 3);
		
		getBlock()[id] = this;
	}
	
	public Block getBlock(int blockID) {
		return block[blockID];
	}

	public static Block[] getBlock() {
		return block;
	}

	public void setBlock(Block[] block) {
		MakeBlock.block = block;
	}

}
