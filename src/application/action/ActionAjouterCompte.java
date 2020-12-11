package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionAjouterCompte<E> implements Action<Object>{
	
	private String message;
	private String code;
	
	public ActionAjouterCompte(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	@Override
	public String actionMessage() {
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}

	@SuppressWarnings("resource")
	public void execute(Object ag) throws Exception {
		System.out.print("Num compte -> ");
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		System.out.print("Nom du propiétaire -> ");
		String nom = lect.next();
		
		Compte c = new Compte(numero, nom);
		((AgenceBancaire) ag).addCompte(c);	
	}

	

}
