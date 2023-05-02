package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;

import config.GameConfig;

import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;

import gui.instrument.ChartManager;


public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	private Dimension preferredSize = new Dimension(GameConfig.WINDOW_WIDTH,GameConfig.WINDOW_HEIGHT);

	private MobileElementManager manager;

	private GameDisplay dashboard;
	
	public int nbSouris;
	
	private MainGUI instance = this;
	
	private boolean stop = true;
	
	private JButton startButton = new JButton(" Start ");
	
	private JButton back = new JButton("Revenir à l'acceuil ");
	
	private int nbr=0; 
	
	private int nbr1=0;
	
	private int nbr2=0; 
	
	
	private int line_count = 0;
	
	private int column_count = 0;
	
	

	
	
	private JPanel statsPanel = new JPanel();
	
	
	private ChartPanel typeCountBar;




	public MainGUI(String title) {
		super(title);
		init();
	}
	
	public MainGUI(String title, int longueur, int largeur){
		super(title);
		this.line_count=longueur ;
		this.column_count = largeur;
		init();
	}
	
	public MainGUI(String title, int longueur, int largeur,int nb,int nb1,int nb2){
		super(title);
		this.line_count=longueur ;
		this.column_count = largeur;
		this.nbr=nb;
		this.nbr1=nb1;
		this.nbr2=nb2;
		init();
	}
	public MainGUI(String title,int nb,int nb1,int nb2){
		super(title);
		
		this.nbr=nb;
		this.nbr1=nb1;
		this.nbr2=nb2;
		init();
	}
	
	

	private void init() { 

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);
		
		
		if(line_count!=0 && column_count!=0 ) {
			
			GameConfig.setCOLUMN_COUNT(column_count);
			GameConfig.setLINE_COUNT(line_count);
		}
		
	
		map = GameBuilder.buildMap();
		
		if(nbr==0 && nbr1==0 && nbr2==0) {
			manager = GameBuilder.buildInitMobile(map);
		}else {
			manager = GameBuilder.buildInitMobile(map,nbr,nbr1,nbr2);
		}
		dashboard = new GameDisplay(map, manager);
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		
		startButton.addActionListener(new StartStopAction());
		contentPane.add(startButton,BorderLayout.SOUTH);
		
		back.addActionListener(new BackAction());
		contentPane.add(back,BorderLayout.NORTH);
	    
		

		dashboard.setPreferredSize(preferredSize);
		dashboard.setBackground(new Color(255,255,255));
		
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		globalLayout();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}



	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(GameConfig.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		
			manager.nextRound();
			dashboard.repaint();
			System.out.println(manager.getCharmanager().toString());
			
			typeCountBar.setChart(manager.getCharmanager().getTypeCountBar());
		}
		
		
	}
	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Start ");
			} else {
				stop = false;
				startButton.setText(" Pause ");
				Thread sourisThread = new Thread(instance);
				sourisThread.start();
			}
		}
			
	}
	    private class BackAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					stop=true;
					instance.dispose();
				
			
			}
	    }
	
		
			
	

	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
				
				
				break;
			case 'd':
				
				break;
			case 'm':
				
				break;
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
		
	}

	private void globalLayout() {
		
	

		

		
		typeCountBar = new ChartPanel(manager.getCharmanager().getTypeCountBar());
		

		
		statsPanel.add(typeCountBar);
		

		
	
		getContentPane().add(statsPanel,BorderLayout.EAST);

	
	}
	}