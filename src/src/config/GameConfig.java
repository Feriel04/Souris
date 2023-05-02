package config;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class GameConfig {
	public static final int WINDOW_WIDTH_ACCUEIL = 700;
	public static final int WINDOW_HEIGHT_ACCUEIL = 550;
	public static  int WINDOW_WIDTH = 500;
	public static  int WINDOW_HEIGHT = 550;
	
	public static final int BLOCK_SIZE = 40;
	
	public static  int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static  int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	
	public static final int GAME_SPEED = 400;


	public static int getLINE_COUNT() {
		return LINE_COUNT;
	}



	public static void setLINE_COUNT(int lINE_COUNT) {
		LINE_COUNT = lINE_COUNT;
	}



	public static int getCOLUMN_COUNT() {
		return COLUMN_COUNT;
	}



	public static void setCOLUMN_COUNT(int cOLUMN_COUNT) {
		COLUMN_COUNT = cOLUMN_COUNT;
	}
	
	
	

}

