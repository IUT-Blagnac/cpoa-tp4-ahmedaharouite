package application.actionlist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import application.AccesAgenceBancaire;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire<E> implements ActionList<Object> {

	private String message;
	private String code;
	private String title;
	private ArrayList <Action<E>> listeActions;

	public ActionListAgenceBancaire(String message, String code, String title, ArrayList<Action<E>> listeActions) {
		super();
		this.message = message;
		this.code = code;
		this.title = title;
		this.listeActions = listeActions;
	}

	@Override
	public String actionMessage() {
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}

	@SuppressWarnings({ "resource", "unused" })
	private int readResponse() {
		Scanner lect = new Scanner ( System.in );
		lect.useLocale(Locale.FRANCE);
		int choix = lect.nextInt();
		choix --;
		
		return choix;
	}

	public void printMenu() {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();
		System.out.println("--\r\n" + 
				ag.toString2() +"\r\n" + 
				title + "\r\n" + 
				"--\r\n" + 
				"  Choisir :\r\n"); 
		for (int i=0; i<this.size(); i++) {
			System.out.println("    " + listeActions.get(i).actionCode() + " - "+ listeActions.get(i).actionMessage());
		}
		System.out.println("\n    0 - Pour quitter ce menu\r\n" + "Votre choix ?");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(Object ag) throws Exception {
		//System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");

		while(true) {
			this.printMenu();
			int choice = this.readResponse();
			if(choice == -1) {
	            System.out.println("Fin de "+ message);
	            break;
	        }
			this.listeActions.get(choice).execute((E) ag);
		}
	}

	@Override
	public String listTitle() {
		return title;
	}

	@Override
	public int size() {
		return listeActions.size();
	}

	@SuppressWarnings("unchecked")
	public boolean addAction(Action<Object> ac) {
		boolean bool = true;

		for(int i=0; i<this.size(); i++) {
			if(listeActions.get(i).equals(ac)) {
				bool = false;
			}
		}

		if (bool == false) {
			listeActions.add((Action<E>) ac);
		}

		return bool;
	}

}
