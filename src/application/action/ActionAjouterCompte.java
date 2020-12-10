package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ActionAjouterCompte implements Action{
	
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
	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		System.out.print("Num compte -> ");
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		System.out.print("Nom du propiétaire -> ");
		String nom = lect.next();
		
		Compte c = new Compte(numero, nom);
		ag.addCompte(c);	
	}

}
