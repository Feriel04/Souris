package engine.mobile;

import engine.map.Block;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class Souris extends MobileElement{
    private char caracter;
    private int fromage=0;
    private int apparence;
    private int etat=0;
    private int[] chance = {1,2,3,4,4,4};
    /*caracter:
     * A :Egoiste
     * B :Mutuelle
     * C:Réceptive
     * D :Nihiliste
     */

	
	public Souris(Block position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	public Souris(Block position,char caracter) {
		super(position);
		switch (caracter) {
		case 'A':
			this.caracter=caracter;
			chance= new int[]{1,2,3,1,1,4};
			break;
		case 'B':
			this.caracter=caracter;
			chance= new int[]{1,2,3,2,2,4};
					break;
		case 'C':
			this.caracter=caracter;
			chance= new int[]{1,2,3,3,3,4};
			break;
		case 'D':
			this.caracter=caracter;
			chance= new int[]{1,2,3,4,4,4};
			break;
		default:
			this.caracter='A';
			break;
		}
		this.caracter=caracter;
		this.apparence=0;
		
		// TODO Auto-generated constructor stub
	}
	
	
	public int getFromage() {
		return fromage;
	}
	public void increment() {
		fromage ++;
	}
	public void decrement() {
		fromage --;
	}
	public void setFromage(int fromage) {
		this.fromage = fromage;
	}
	public char getCaracter() {
		return caracter;
	}
	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}
	
	public int getApparence() {
		return apparence;
	}
	public void setApparence(int apparence) {
		this.apparence = apparence;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int[] getChance() {
		return chance;
	}
	public void setChance(int[] chance) {
		this.chance = chance;
	}
	@Override
	public String toString() {
		return "Souris [caracter=" + caracter + ", position=" + getPosition() + "]";
	}
	

	


}


