package gui.accueil;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import config.GameConfig;
import gui.MainGUI;


public class AcceuilGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;



	private final static Dimension preferredSize = new Dimension(GameConfig.WINDOW_WIDTH_ACCUEIL,GameConfig.WINDOW_HEIGHT_ACCUEIL);


	Container contentPane = getContentPane();
	
	
	private JPanel control = new JPanel();
	
	
	
	private JLabel titre = new JLabel("SOURIS");
	
	private static Font font = new Font(Font.SERIF, Font.PLAIN, 20);

	private JButton createDH = new JButton("start");
	
	
	
	private JButton help = new JButton("help");
	
	private static Color buttonColor = new Color(220, 118, 51  );
	
	private static Color controlColor = new Color(237, 187, 153);
	
	
	
	private int  longueur;
	private int largeur;
	private int  nbs=0;
	private int nbf=0;
	private int nbo=0;
	
	

	public AcceuilGUI(String title) {
		super(title);
		init();
		
		
	}

	private void init() {
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		control.setLayout(null);
		control.setPreferredSize(preferredSize);
		control.setBackground(controlColor);
		
		contentPane.add(control);
		
		
		// Affichage page pricipale
		
		titre.setFont(font);
		
		titre.setBounds(250, 20, 200, 80);
		control.add(titre);
		
		
		JLabel dim = new JLabel("choisir une dimension");
		dim.setBackground(controlColor);
		dim.setBounds(500, 80, 200, 30);
		control.add(dim);
		
		
		
		JTextField min = new JTextField();
		min.setText("0");
		min.setBounds(480, 120, 96, 19);
		control.add(min);
		
		
		JTextField max = new JTextField();
		max.setText("0");
		max.setBounds(580, 120, 96, 19);
		control.add(max);
		

		JLabel nbr = new JLabel("Nombre de Souris");
		nbr.setBackground(controlColor);
		nbr.setBounds(500, 150, 200, 30);
		control.add(nbr);
		
		
		
		JTextField nb= new JTextField();
		nb.setText("0");
		nb.setBounds(480, 180, 96, 19);
		control.add(nb);
		
		titre.setFont(font);
		
		titre.setBounds(250, 20, 200, 80);
		control.add(titre);
		
		
		JLabel nbr1 = new JLabel("Nombre de Nourriture");
		nbr1.setBackground(controlColor);
		nbr1.setBounds(500, 210, 200, 30);
		control.add(nbr1);
		
		
		
		JTextField nb1= new JTextField();
		nb1.setText("0");
		nb1.setBounds(480, 240, 96, 19);
		control.add(nb1);
		
		JLabel nbr2 = new JLabel("Nombre d'obstacle");
		nbr2.setBackground(controlColor);
		nbr2.setBounds(500, 260, 200, 30);
		control.add(nbr2);
		
		
		
		JTextField nb2= new JTextField();
		nb2.setText("0");
		nb2.setBounds(480, 290, 96, 19);
		control.add(nb2);
		
		
		
		
		createDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				longueur = Integer.valueOf(min.getText());
				largeur = Integer.valueOf(min.getText());
				nbs=Integer.valueOf(nb.getText());
				nbf=Integer.valueOf(nb1.getText());
				nbo=Integer.valueOf(nb2.getText());
				
			
				if(5 < longueur && longueur < 50  && 5 < largeur && largeur < 50 && (nbs!=0 || nbf!=0 || nbo!=0)){
					MainGUI gameMainGUI = new MainGUI("SOURIS",longueur,largeur,nbs,nbf,nbo);
					Thread gameThread = new Thread(gameMainGUI);
					gameThread.start();
				}
				
				else if(5 < longueur && longueur < 50  && 5 < largeur && largeur <  50 ) {
					
					
					MainGUI gameMainGUI = new MainGUI("SOURIS",longueur,largeur);

					Thread gameThread = new Thread(gameMainGUI);
					gameThread.start();	
				}
				else if(nbs!=0 && nbf!=0 && nbo!=0){
					MainGUI gameMainGUI = new MainGUI("SOURIS",nbs,nbf,nbo);
					Thread gameThread = new Thread(gameMainGUI);
					gameThread.start();
				}
				else {
				MainGUI gameMainGUI = new MainGUI("SOURIS");

				Thread gameThread = new Thread(gameMainGUI);
				gameThread.start();
				}
				
			}
		});
		createDH.setBounds(200, 105, 200, 50);
		createDH.setBackground(buttonColor);
		control.add(createDH);
	
		
		
		
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url_open ="https://rouasl.alwaysdata.net/sitesouris/";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		help.setBounds(200, 205, 200, 50);
		help.setBackground(buttonColor);
		control.add(help);
	
	
	
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	


	
	

}



