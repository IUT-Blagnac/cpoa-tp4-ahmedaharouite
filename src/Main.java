import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class Main {

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

		ArrayList <Action> listeActions = new ArrayList <Action>();

		listeActions.add(aL);
		listeActions.add(aCn);

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
					Main.tempo();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;	
			case "2" :
				try {
					aCn.execute(ag);
					Main.tempo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "q" :
				System.out.println("ByeBye");
				Main.tempo();
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
