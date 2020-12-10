package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ActionSupprimerCompte implements Action{
	
	private String message;
	private String code;
	
	public ActionSupprimerCompte(String message, String code) {
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

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		System.out.print("Num compte -> ");
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		
		ag.removeCompte(numero);	
	}

}
