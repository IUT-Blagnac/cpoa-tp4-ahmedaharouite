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

	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();

		Action aL = new ActionListeDesComptes("Afficher la liste des comptes", "1");
		Action aCn = new ActionVoirCompteNumero("Afficher un compte par son numero", "2");

		ArrayList <Action> listeActions = new ArrayList <Action>();

		listeActions.add(aL);
		listeActions.add(aCn);

		ActionListAgenceBancaire action = new ActionListAgenceBancaire("Liste agence bancaire", "1", "titre1", listeActions);

		try {
			action.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner lect = new Scanner(System.in);
		lect.useLocale(Locale.US);
		String choix;

		boolean continuer = true;
		while (continuer) {
			choix = lect.next();
			choix = choix.toLowerCase();
			
			switch (choix) {
			case "q" :
				System.out.println("ByeBye");
				ApplicationAgenceBancaire.tempo();
				continuer = false;
				break;
			case "1" :
				try {
					aL.execute(ag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;	
			case "2" :
				try {
					aCn.execute(ag);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default :
				System.out.println("Erreur de saisie ...");
				ApplicationAgenceBancaire.tempo();
				break;
			}
		}

	}
}
