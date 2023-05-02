package engine.mobile;

import engine.map.Block;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public abstract class MobileElement {
	private Block position;


	public MobileElement(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "MobileElement [position=" + position + "]";
	}
	

}
