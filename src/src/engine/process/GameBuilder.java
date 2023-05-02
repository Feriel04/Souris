package engine.process;

import config.GameConfig;
import engine.map.Map;


/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfig.LINE_COUNT, GameConfig.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeSouris(map, manager);
		
		return manager;
	}
	
	public static MobileElementManager buildInitMobile(Map map,int nb,int nb1,int nb2) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeSouris(map, manager,nb,nb1,nb2);
		
		return manager;
	}
// initialisation par defaut
	private static void intializeSouris(Map map, MobileElementManager manager) {
		
		manager.setTour(100);
		manager.setIs(0);
		manager.setNbSouris(10);
		manager.setNbFood(10);
		manager.generateFood();
		manager.setNbObstacle(4);
		manager.generateObstacle();
				
	}
	//initialisation une fois specifier par l'utilisateur
	
private static void intializeSouris(Map map, MobileElementManager manager,int nb,int nb1,int nb2) {
		
		manager.setTour(100);
		manager.setIs(0);
		manager.setNbSouris(nb);
		manager.setNbFood(nb1);
		manager.generateFood();
		manager.setNbObstacle(nb2);
		manager.generateObstacle();
				
	}

}
