package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import engine.map.Map;
import engine.mobile.Souris;
import engine.mobile.Food;
import engine.mobile.Obstacle;
import engine.process.MobileElementManager;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		paintStrategy.paint(map, g2);

		for (Food food : manager.getF()) {
			paintStrategy.paint(food, g2);
		}
		for (Obstacle obstacle : manager.getO()) {
			paintStrategy.paint(obstacle, g);
		}

		for (Souris souris : manager.getS()) {
			paintStrategy.paint(souris, g2);
		}


		}
}
