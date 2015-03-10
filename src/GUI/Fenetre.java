package GUI;

import java.util.*;

import javax.swing.*;

import Controleur.*;

/**
 * Classe interface qui gere la fenetre generale
 * @author Warlot/Gasquez
 */
public class Fenetre  extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private GestionnairePartie maPartie;
	private ControleurFenetre controleur;
	
	/**
	 * Constructeur
	 * @param maPartie la partie
	 */
	public Fenetre(GestionnairePartie maPartie){
		super("PhantasticasBellum");
		setLocale(Locale.FRENCH);
		
		this.maPartie = maPartie;
		this.controleur = new ControleurFenetre(this);
		
		controleur.initVue();
		this.setIconImage(new ImageIcon(this.getClass().getResource("/images/logo.png")).getImage());
		
		this.setSize(850, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		this.setResizable(false);
	}
        
        /**
	 * Constructeur par d�faut
	 * <b> Attention :</b> La partie associ�e � la fen�tre doit �tre d�finie plus tard
	 */
	public Fenetre(){
		super("PhantasticasBellum");
		setLocale(Locale.FRENCH);
		
		this.setIconImage(new ImageIcon(this.getClass().getResource("/images/logo.png")).getImage());
		
		this.setSize(850, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		this.setResizable(false);
	}
	
	/**
	 * Permet de changer de vue
	 * @param panelNew nouveau panel a ajouter
	 */
	public void naviguer(JPanel panelNew){
		this.getContentPane().removeAll();
		this.getContentPane().revalidate();
		this.getContentPane().add(panelNew);
	}


	/**
	 * Retourne la partie en cours
	 * @return objet Partie
	 */
	public GestionnairePartie getMaPartie() {
		return maPartie;
	}
	
	/**
	 * Retourne le controleur de la fenetre principale
	 * @return objet ControleurFenetre
	 */
	public ControleurFenetre getControleur() {
		return controleur;
	}
        
        /**
         * D�finit la partie associ�e � la fen�tre courante
         * @param maPartie La partie � associer
         */
        public void setPartie(GestionnairePartie maPartie) {
            this.maPartie = maPartie;
            this.controleur = new ControleurFenetre(this);
		
            controleur.initVue();
        }
}
