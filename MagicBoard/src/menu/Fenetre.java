package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import draw.DrawPanel;

public class Fenetre extends JFrame implements ActionListener {

	
	JMenuBar bar = new JMenuBar();
	
	JMenu fichier = new JMenu("Fichier");
	JMenuItem effacer = new JMenuItem("Effacer");
	JMenuItem quitter = new JMenuItem("Quitter");
	
	JMenu edition = new JMenu("Edition");
	JMenu form = new JMenu("Forme du pointeur");
	
	ButtonGroup comboMorph = new ButtonGroup();
	JRadioButton rond = new JRadioButton("rond");
	JRadioButton carre = new JRadioButton("carre");
	
	JMenu color = new JMenu("Couleur du pointeur");
	
	ButtonGroup comboColor = new ButtonGroup();
	JRadioButton rouge = new JRadioButton("rouge");
	JRadioButton vert = new JRadioButton("vert");
	JRadioButton bleu = new JRadioButton("bleu");
	
	JToolBar toolBar = new JToolBar();
	Color fondBouton = Color.white;
	
	DrawPanel dp = new DrawPanel();

	
	private 
	JButton rondIco = new JButton(new ImageIcon("images/rond.jpg")),
			carreIco = new JButton(new ImageIcon("images/carre.jpg")),
			bleuIco = new JButton(new ImageIcon("images/bleu.jpg")),
			vertIco = new JButton(new ImageIcon("images/vert.jpg")),
			rougeIco = new JButton(new ImageIcon("images/rouge.jpg"));
	
	public void initMenu() {
		
		effacer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dp.effacer();
			}
			
		});
		
		fichier.add(effacer);
		fichier.addSeparator();
		fichier.add(quitter);



		edition.add(form);
		edition.addSeparator();
		edition.add(color);

		rond.addActionListener(this);
		carre.addActionListener(this);	
		rouge.addActionListener(this);
		vert.addActionListener(this);	
		bleu.addActionListener(this);
		
		// combo one choice
		comboMorph.add(rond);
		comboMorph.add(carre);
		
		// list of choice
		form.add(rond);
		form.add(carre);
		
		// combo one choice
		comboColor.add(bleu);
		comboColor.add(rouge);
		comboColor.add(vert);
		
		// list of choice
		color.add(bleu);
		color.add(rouge);
		color.add(vert);
		
		
		// quitter le programme
		this.quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// ajout mnemonique
		fichier.setMnemonic((int)'F');
		effacer.setAccelerator(KeyStroke.getKeyStroke('N'));
		quitter.setAccelerator(KeyStroke.getKeyStroke('W'));
		this.bar.add(fichier);
		

		edition.setMnemonic((int)'E');
		this.bar.add(edition);
		
		this.setJMenuBar(bar);
	}
	
	public void initToolBar() {
		
		rondIco.addActionListener(this);
		carreIco.addActionListener(this);
		rougeIco.addActionListener(this);
		vertIco.addActionListener(this);
		bleuIco.addActionListener(this);

		this.toolBar.add(rondIco);
		this.toolBar.add(carreIco);
		this.toolBar.addSeparator();
		this.toolBar.add(rougeIco);
		this.toolBar.add(vertIco);
		this.toolBar.add(bleuIco);
		
		
		
		this.add(toolBar, BorderLayout.NORTH);
		

	}

	public void initDraw() {
		dp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		this.addMouseMotionListener(dp);
		this.addMouseListener(dp);
		this.add(dp,BorderLayout.CENTER);
	}
	
	public Fenetre() {
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initMenu();
		initToolBar();
		initDraw();
		this.setVisible(true);
		go();
	}
	
	public void go() {
		while(true) {
			dp.repaint();
			 try {
			        Thread.sleep(10);
			      } catch (InterruptedException e) {
			        e.printStackTrace();
			      }
		}
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] colorMorph = {"rond","carre","rouge","bleu","vert"};
			
			for(String s : colorMorph) {
				if(e.getSource().toString().contains(s)) {
					switch(s) {
					case "rond":
						dp.setMorph(draw.Morph.ROND);break;
					case "carre":
						dp.setMorph(draw.Morph.CARRE);break;
					case "rouge":
						dp.setColor(Color.red);break;

					case "vert":
						dp.setColor(Color.green);break;

					case "bleu":
						dp.setColor(Color.blue);break;

					}
					
				}
			}
			
		}

	
	
	
	
}
