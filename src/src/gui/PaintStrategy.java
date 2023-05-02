package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import config.GameConfig;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Food;
import engine.mobile.Obstacle;
import engine.mobile.Souris;
import engine.process.SimulationUtility;



// mettre des images pour la bonne visualisation 
public class PaintStrategy {
    public void paint(Map map, Graphics g2) {
        int blockSize = GameConfig.BLOCK_SIZE;
        Block[][] blocks = map.getBlocks();

        for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
            for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
                Block block = blocks[lineIndex][columnIndex];
                
               
                if (map.getHerbe(lineIndex,columnIndex)==0) {
                	g2.drawImage(SimulationUtility.readImage("src/images/terrain/Herbe.png"),block.getColumn() * blockSize ,block.getLine() * blockSize  ,  blockSize,  blockSize, null);
                   
                 }
                else {
                	g2.drawImage(SimulationUtility.readImage("src/images/terrain/herbe.jpg"),block.getColumn() * blockSize ,block.getLine() * blockSize  ,  blockSize,  blockSize, null);
                
              
                }
            }
        }
    }
    // mettre des images pour bien voir la position des souris (pivoter)
public void paint(Souris souris, Graphics2D g2) {
        Block position = souris.getPosition();
        int blockSize = GameConfig.BLOCK_SIZE;

        int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
       
        if(souris.getFromage()>0) {
        	g2.drawImage(SimulationUtility.readImage("src/images/souris/"+souris.getCaracter()+souris.getApparence()+".png"),x,y ,  2*blockSize,  2*blockSize, null);
        }
        else {
        	g2.drawImage(SimulationUtility.readImage("src/images/souris/"+souris.getCaracter()+souris.getApparence()+".png"),x,y ,  blockSize,  blockSize, null);
        }
        
    }
public void paint(Food food, Graphics2D g2) {
    Block position = food.getPosition();
    int blockSize = GameConfig.BLOCK_SIZE;

    int y = position.getLine()* blockSize;
    int x = position.getColumn()* blockSize;
    g2.drawImage(SimulationUtility.readImage("src/images/terrain/cheese.png"),x,y,  blockSize,  blockSize, null);
    
}
public void paint(Obstacle obstacle, Graphics graphics) {
    Block position = obstacle.getPosition();
    int blockSize = GameConfig.BLOCK_SIZE;

    int y = position.getLine();
    int x = position.getColumn();

    graphics.setColor(Color.BLACK);
    graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);

}
}
