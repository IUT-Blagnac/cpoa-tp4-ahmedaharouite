import java.util.ArrayList;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionAjouterCompte;
import application.action.ActionDeposerArgent;
import application.action.ActionListeDesComptes;
import application.action.ActionRetirerArgent;
import application.action.ActionSupprimerCompte;
import application.action.ActionVoirCompteNom;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class applicationBanqueActionGenerique {
	
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();		
		
		ArrayList<Action<Object>> menuGeneral = new ArrayList <Action<Object>>();
		Action<Object> aL = new ActionListeDesComptes("Afficher la liste des comptes", "1");
		Action<Object> aCn = new ActionVoirCompteNumero<Object>("Afficher un compte par son numero", "2");		
		Action<Object> aN = new ActionVoirCompteNom<Object>("Voir les comptes d'un Propriétaire (par son nom)", "3");
		menuGeneral.add(aL);
		menuGeneral.add(aCn);
		menuGeneral.add(aN);
		
		
		ArrayList<Action<Object>> menuOperations = new ArrayList <Action<Object>>();
		Action<Object> aD = new ActionDeposerArgent<Object>("Déposer de l'argent sur un compte", "1");
		Action<Object> aR = new ActionRetirerArgent<Object>("Retirer de l'argent sur un compte", "2");
		menuOperations.add(aD);
		menuOperations.add(aR);
		
		
		ArrayList<Action<Object>> menuGestion = new ArrayList <Action<Object>>();
		Action<Object> aA = new ActionAjouterCompte<Object>("Ajouter un compte", "1");
		Action<Object> aS = new ActionSupprimerCompte("Supprimer un compte", "2");
		menuGestion.add(aA);
		menuGestion.add(aS);
		
		ActionListAgenceBancaire<Object> menu1 = new ActionListAgenceBancaire<Object>("Menu Général", "1", "Menu Général", menuGeneral);
		ActionListAgenceBancaire<Object> menu2 = new ActionListAgenceBancaire<Object>("Menu opérations sur comptes", "4", "Menu opérations sur comptes", menuOperations);
		ActionListAgenceBancaire<Object> menu3 = new ActionListAgenceBancaire<Object>("Menu gestion des comptes", "5", "Menu gestion des comptes", menuGestion);
		
		menuGeneral.add(menu2);
		menuGeneral.add(menu3);

		

		try {
			menu1.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
