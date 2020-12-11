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

public class Main2 {
	
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();		
		
		ArrayList <Action> menuGeneral = new ArrayList <Action>();
		Action aL = new ActionListeDesComptes("Afficher la liste des comptes", "1");
		Action aCn = new ActionVoirCompteNumero("Afficher un compte par son numero", "2");		
		Action aN = new ActionVoirCompteNom("Voir les comptes d'un Propriétaire (par son nom)", "3");
		menuGeneral.add(aL);
		menuGeneral.add(aCn);
		menuGeneral.add(aN);
		
		
		ArrayList <Action> menuOperations = new ArrayList <Action>();
		Action aD = new ActionDeposerArgent("Déposer de l'argent sur un compte", "1");
		Action aR = new ActionRetirerArgent("Retirer de l'argent sur un compte", "2");
		menuOperations.add(aD);
		menuOperations.add(aR);
		
		
		ArrayList <Action> menuGestion = new ArrayList <Action>();
		Action aA = new ActionAjouterCompte("Ajouter un compte", "1");
		Action aS = new ActionSupprimerCompte("Supprimer un compte", "2");
		menuGestion.add(aA);
		menuGestion.add(aS);
		
		ActionListAgenceBancaire menu1 = new ActionListAgenceBancaire("Menu Général", "1", "Menu Général", menuGeneral);
		ActionListAgenceBancaire menu2 = new ActionListAgenceBancaire("Menu opérations sur comptes", "4", "Menu opérations sur comptes", menuOperations);
		ActionListAgenceBancaire menu3 = new ActionListAgenceBancaire("Menu gestion des comptes", "5", "Menu gestion des comptes", menuGestion);
		
		menuGeneral.add(menu2);
		menuGeneral.add(menu3);

		

		try {
			menu1.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
