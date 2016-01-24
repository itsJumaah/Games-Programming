package stormtroopers.world;

import java.awt.Image;

import stormtroopers.GameEngine;

public class BackgroundEntity extends Block {

	public BackgroundEntity(GameEngine engine, Image texture, int id) {
		super(engine, texture, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
