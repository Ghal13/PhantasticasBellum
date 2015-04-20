package GuDuWa;

import java.util.List;

import Controleur.Partie;
import IA.*;
import Model.Coup;
import Model.Joueur;
import Model.Personnage;

public class MonIA extends AbstractIA {
	private int aplha = 50;
	private int beta = -50;
	
	public MonIA(String nom) {
		super(nom);
	}

	@Override
	public Coup getCoup(Partie p) {
		
		
		
		
		alphaBeta(p, p.getJoueurActuel(), this.aplha, this.beta, true, 5);
		
		
		
		
		return null;
	}
	
	//TODO ici chaque joueur joue � tour de role. En r�alit� un joueur peut jouer deux fois il l'autre poss�de un personnage de moins.
	//TODO class� les fils dans l'ordre
	
	public int alphaBeta(Partie model, Joueur joueur, int alpha, int beta, boolean noeudMax, int profondeur) {
		Partie modelClone = model.clone();
		boolean partieFini = modelClone.estTerminee();
		
		if (profondeur == 0) {
			//Si profondeur max atteinte
			return heuristique_plateau(model);
		} else if (partieFini) {
			//Si la partie est termin�e
			
			modelClone.joueurSuivant();
			boolean partieGagne = modelClone.getJoueurActuel().estBattu();
			modelClone.joueurSuivant();
			
			boolean partiePerdu = modelClone.getJoueurActuel().estBattu();
			
			if (partieGagne) {
				//Termin�e et gagn�e => retourner la valeur maximum
				return this.aplha;
			} else if (partiePerdu) {
				//Termin�e et perdu => retourner la valeur minimum
				return this.beta;
			} else {
				//Termin�e et match nul => retourner la valeur moyenne
				return (this.beta + this.aplha) / 2;
			}
		} else {
			//Profondeur non atteinte et partie non termin�e
			Personnage personnageChoisi;
			List<Coup> listeAction;
			int alphaCourant;
			int betaCourant;
			
			if (noeudMax) {
				//A moi de jouer
				
				/*
				//Choisie un personnage parmis ceux disponible 
				personnageChoisi = choixPersonnage(modelClone.getJoueurActuel().getEquipe().);
				
				//R�cup�re toutes les actions possibles du personnage selectionn�
				listeAction = modelClone.getTousCoupsPersonnage(personnageChoisi);
				*/
				listeAction = modelClone.getTousCoups();
				
				//Ordonne les actions
				//ordonneActions(listeAction);
				
				//Elague la liste en fonction de la profondeur
				//elaguageActions(listeAction, profondeur);
				
				for(Coup action : listeAction) {
					//Applique l'action et passe au joueur suivant
					modelClone.appliquerCoup(action);
					model.joueurSuivant();
					
					//Noeud suivant
					alphaCourant = alphaBeta(modelClone, model.getJoueurActuel(), alpha, beta, !noeudMax, profondeur - 1);
					
					if (alphaCourant > alpha) {
						//Si un meilleur coups est trouv�
						alpha = alphaCourant;
					}
					//Coupure beta
					if (alpha >= beta) {
                    	return alpha;
                    }
				}
				
				return alpha;
			} else {
				//A l'adversaire de jouer
				
				//R�cup�re toutes les actions possibles des personnages adverses
				listeAction = modelClone.getTousCoups();
				
				//Elague la liste en fonction de la profondeur
				//elaguageActions(listeAction, profondeur);
				
				for(Coup action : listeAction) {
					//Applique l'action et passe au joueur suivant
					modelClone.appliquerCoup(action);
					model.joueurSuivant();
					
					//Noeud suivant
					betaCourant = alphaBeta(modelClone, model.getJoueurActuel(), alpha, beta, !noeudMax, profondeur - 1);
					
					if (betaCourant > alpha) {
						//Si meilleur coups trouv�
						beta = betaCourant;
					}
					//Coupure alpha
					if (beta <= alpha) {
	                	return beta;
					}
				}
				
				return beta;
			}
		}
	}
	
	/**
	 * Calcul l'heuristique de la partie (l'�value) pass� en param�tre et retourne la valeur calcul�
	 * @param maPartie partie � �valuer
	 * @return valeur du plateau
	 */
	private int heuristique_plateau(Partie maPartie) {
		
		//Thomas

	}
	/**
	 * Calcul l'heuristique de chaque coup (sa valeur), ordonne par ordre d�croissant et ne garde que les nbCoupRetour premiers
	 * @param listeCoup liste de coup � �valu�, ordonn� et �laguer
	 * @param nbCoupRetour nombre de coup conserv� apr�s �laguage
	 */
	private void ordonne_coup_puis_elague(List<Coup> listeCoup, int nbCoupRetour) {
		
		
		
	}

	/**
	 * Choisie et retourne le personnage le plus puissant dans la liste pass� en param�tre
	 * @param personnageEquipe liste de personnage
	 * @return personnage choisi
	 */
	private Personnage choix_personnage(List<Personnage> personnageEquipe) {
		Personnage persoChoisi = null;
		
		for (Personnage persoAutre : personnageEquipe) {
			if (persoChoisi == null
					|| facteur_puissance(persoAutre) < facteur_puissance(persoAutre)
					) {
				persoChoisi = persoAutre;
			}
		}
		
		return persoChoisi;
	}

	/**
	 * Calcul l'heuristique du coup (l'�value) pass� en param�tre et retourne la valeur calcul�
	 * @param monCoup coup � �valuer
	 * @return valeur du coup
	 */
	private int heuristique_coup(Coup monCoup) {
		

	}
	
	/**
	 * Calcul du facteur de puissance d'un personnage (importance de personnage en d�but de partie)
	 * @param monPerso personne � �valuer
	 * @return facteur de puissance
	 */
	private int facteur_puissance(Personnage monPerso) {
		
		//David
		
	}
}
