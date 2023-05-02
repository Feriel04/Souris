package engine.process;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import config.GameConfig;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Food;
import engine.mobile.Obstacle;
import engine.mobile.Souris;
import engine.mobile.Valide;
import gui.instrument.ChartManager;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author rouas,malek
 *
 */

public class MobileElementManager {
    private Map map;
    private int tour;
    private int is;
    private int nbSouris;
    private int nbFood;
    private int nbObstacle;
    private List<Souris> s = new ArrayList<Souris>();
    private List<Food> f = new ArrayList<Food>();
    private List<Obstacle> o = new ArrayList<Obstacle>();
    private List<Valide> v = new ArrayList<Valide>();
    private ChartManager charmanager = new ChartManager();

    public MobileElementManager(Map map) {
        this.map = map;
    }

    public void add(Souris souris) {
        s.add(souris);
    }
    public void add(Food food) {
        f.add(food);
    }
    public void add(Obstacle obstacle) {
        o.add(obstacle);
    }
    public void add(Valide valide) {
        v.add(valide);
    }
    public void nextRound() {
    	generate();
    	generateOneFood();
    	moveSouris();
    	removeFood();
    	mortSouris();
    }
  //generate with caractere ();
    public void generate() {
    	char[]  c = {'A','B','C','D'};
    	if(is<nbSouris) {
    	Block block = map.getBlock((GameConfig.LINE_COUNT - 1)/2, (GameConfig.COLUMN_COUNT - 1) / 2);
    	Souris souris =new Souris(block,c[is%4]);
    	charmanager.countType(souris.getCaracter()); 
    	s.add(souris);
		 
		 is++;
    	}
    }//generate obstacles();
    public void generateObstacle() {
    	for(int i=0;i<nbObstacle;i++) {
    	Block block = map.getBlock(getRandomNumber(0, GameConfig.LINE_COUNT-1),getRandomNumber(0,GameConfig.COLUMN_COUNT-1 ));
    	Obstacle obstacle =new Obstacle(block);
		 o.add(obstacle);
		 
    	}
    }
  //generateFood();
    public void generateFood() {
    	for(int i=0;i<nbFood;i++) {
    	Block block = map.getBlock(getRandomNumber(0, GameConfig.LINE_COUNT-1),getRandomNumber(0,GameConfig.COLUMN_COUNT-1 ));
    	Food food =new Food(block);
		 f.add(food);
		 
    	}
    }
    
    public void generateOneFood() {

    	if(f.size()==0){
    		Block block = map.getBlock(getRandomNumber(0, GameConfig.LINE_COUNT-1),getRandomNumber(0,GameConfig.COLUMN_COUNT-1 ));
    		Food food =new Food(block);
    		f.add(food);
		 
    	}
    }
 
    	
    	// remove souris;
    private void moveSouris() {
        List<Souris> outOfBoundMissiles = new ArrayList<Souris>();

        for (int i=0;i<s.size();i++) {
            Block position = s.get(i).getPosition();
            int n=1;
            int[] chance = s.get(i).getChance(); 
            if(s.get(i).getFromage()>=2) {
            	n=chance[getRandomNumber(0, 5)];
            	
            	
            }
            else {
            	n=getRandomNumber(1, 4);
            }
           
           
           if(Obstacle(position)) {
        	   System.out.println(Obstacle(position));
            switch (n) {
  
            case 1:
            	
            	if (!map.isOnTop(position)) {
            			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
            			mange(newPosition,i);
            			accouplement(newPosition,s.get(i).getCaracter(),s.get(i).getFromage());
            			s.get(i).setApparence(1);
            			s.get(i).setPosition(newPosition);
            			
            			
            	}
            	 
            	break;

            case 2:
            	if (!map.isOnBottom(position)) {
			        Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			        mange(newPosition,i);
			        accouplement(newPosition,s.get(i).getCaracter(),s.get(i).getFromage());
			        s.get(i).setApparence(3);
			        s.get(i).setPosition(newPosition);
            	}
            	break;

		case 3:
		    if (!map.isOnLeftBorder(position)) {
		        Block newPosition = map.getBlock(position.getLine() , position.getColumn()-1);
		        mange(newPosition,i);
		        accouplement(newPosition,s.get(i).getCaracter(),s.get(i).getFromage());
		        s.get(i).setApparence(0);
		        s.get(i).setPosition(newPosition);
		        
		    }
		    break;
		case 4:
		    if (!map.isOnRightBorder(position)) {
		        Block newPosition = map.getBlock(position.getLine(), position.getColumn()+1);
		        mange(newPosition,i);
		        accouplement(newPosition,s.get(i).getCaracter(),s.get(i).getFromage());
		        s.get(i).setApparence(2);
		        s.get(i).setPosition(newPosition);
		    }
        break;

		default:
			break;
			
            }
           }
            }

        for (Souris souris : outOfBoundMissiles) {
            s.remove(souris);
        }
    }
    public void mange(Block position,int i) {
    	for (Food food : f) {
    		
            if(food.getPosition()==position) {
            	food.setEtat(1);
            	s.get(i).increment();
            	System.out.println(s.get(i).getFromage());
            	
            	
            }
         }	
    }
    public void removeFood() {

    	for (int i=0;i<f.size();i++) {
    		
               if(f.get(i).getEtat()==1) {
            	   f.remove(i);
               }
            }	
    }
    public void removeMouse() {

    	for (int i=0;i<s.size();i++) {
    		
               if(s.get(i).getEtat()==1) {
            	   charmanager.removeCountType(s.get(i).getCaracter());
            	   s.remove(i);
            	   
               }
            }	
    }
    public boolean Obstacle(Block position) {
    	boolean i=true;
    	for (Obstacle obstacle : o) {
    		
            if(obstacle.getPosition()==position) {
            	i=false;
            }
         }         
    	return i;
    };
    // donner naissance a des nouvelles souris;
    public void accouplement(Block position,char c1,int fromage) {
    	char c2;
    	if(fromage>0) {
    	for (int i=0;i<s.size();i++) {
    		
            if(s.get(i).getPosition()==position) {
            	c2=s.get(i).getCaracter();
            	if((c1=='A' && ((c2=='A') || (c2=='B'))) || (c1=='B' && (c2=='A') || (c2=='B'))||(c1=='C' && ((c2=='C') || (c2=='D'))) || (c1=='D' && (c2=='C') || (c2=='D'))) {
            		
            		if(getRandomNumber(0, 1)==0) {
            			s.get(i).decrement();
            			Block block = map.getBlock(0, 0);
            			Souris souris =new Souris(block,c1);
            			charmanager.countType(souris.getCaracter());
            			s.add(souris);
            		}
            		else {
            			s.get(i).decrement();
            			Block block = map.getBlock(0, 0);
            			Souris souris =new Souris(block,c2);
            			charmanager.countType(souris.getCaracter());
            			s.add(souris);
            		}
            		
            		
            	}
         	  
            }
         }	
	   
    	}
    }
    public void incrementTour() {
    	tour++;
    }
    public void mortSouris() {
    	if(tour<40) {
    		incrementTour();
    		removeMouse();
    		
    	}else {
    		for (int i=0;i<s.size();i++) {
        		
                if(s.get(i).getFromage()==0) {
             	   s.get(i).setEtat(1);
                }
             }	
    		tour=0;
    	} 
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Souris> getS() {
        return s;
    }

    public void setS(List<Souris> s) {
        this.s = s;
    }

    public List<Food> getF() {
        return f;
    }

    public void setF(List<Food> f) {
        this.f = f;
    }

    public List<Obstacle> getO() {
        return o;
    }

    public void setO(List<Obstacle> o) {
        this.o = o;
    }

    public List<Valide> getV() {
        return v;
    }

    public void setV(List<Valide> v) {
        this.v = v;
    }
    
    public int getNbSouris() {
		return nbSouris;
	}
	public void setNbSouris(int nbSouris) {
		this.nbSouris = nbSouris;
	}
	
	
	public int getNbFood() {
		return nbFood;
	}
	public void setNbFood(int nbFood) {
		this.nbFood = nbFood;
	}
	
	public int getNbObstacle() {
		return nbObstacle;
	}
	public void setNbObstacle(int nbObstacle) {
		this.nbObstacle = nbObstacle;
	}
	public int getIs() {
		return is;
	}
	public void setIs(int is) {
		this.is = is;
	}
	
	public int getTour() {
		return tour;
	}
	public void setTour(int tour) {
		this.tour = tour;
	}
	
	public ChartManager getCharmanager() {
		return charmanager;
	}
	public void setCharmanager(ChartManager charmanager) {
		this.charmanager = charmanager;
	}
	private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }

}