import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionDeposerArgent;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNom;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class Main2 {

	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}
	
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();

		Action aL = new ActionListeDesComptes("Afficher la liste des comptes", "1");
		Action aCn = new ActionVoirCompteNumero("Afficher un compte par son numero", "2");
		Action aN = new ActionVoirCompteNom("Voir les comptes d'un Propriétaire (par son nom)", "3");
		Action aD = new ActionDeposerArgent("Déposer de l'argent sur un compte", "4");
		Action aR = new ActionDeposerArgent("Retirer de l'argent sur un compte", "5");
		
		ArrayList <Action> listeActions = new ArrayList <Action>();

		listeActions.add(aL);
		listeActions.add(aCn);
		listeActions.add(aN);
		listeActions.add(aD);
		listeActions.add(aR);

		ActionListAgenceBancaire action = new ActionListAgenceBancaire("Liste agence bancaire", "1", "titre1", listeActions);

		

		Scanner lect = new Scanner(System.in);
		lect.useLocale(Locale.US);
		String choix;

		boolean continuer = true;
		while (continuer) {
			try {
				action.execute(ag);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			choix = lect.next();			

			switch (choix) {
			case "1" :
				try {
					aL.execute(ag);
					Main2.tempo();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;	
			case "2" :
				try {
					aCn.execute(ag);
					Main2.tempo(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "3" :
				try {
					aN.execute(ag);
					Main2.tempo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "4" :
				try {
					aD.execute(ag);
					Main2.tempo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "5" :
				try {
					aR.execute(ag);
					Main2.tempo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "q" :
				System.out.println("ByeBye");
				Main2.tempo();
				continuer = false;
				break;
			default :
				System.out.println("Erreur de saisie ...");
				ApplicationAgenceBancaire.tempo();
				break;
			}
		}

	}
}
