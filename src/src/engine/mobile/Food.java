package engine.mobile;

import engine.map.Block;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class Food extends MobileElement{
	private int etat;

	public Food(Block position) {
		super(position);
		etat=0;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Food [etat=" + etat + "]";
	}
	
	

}

