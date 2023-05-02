package test;

import gui.MainGUI;
import gui.accueil.AcceuilGUI;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class TestGame {
	
	public static void main(String[] args) {

		AcceuilGUI gameMainGUI = new AcceuilGUI("SOURIS");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
