package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero implements Action {

	private String message;
	private String code;
	
	public ActionVoirCompteNumero(String message, String code) {
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
		Compte c = ag.getCompte(numero);
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
	}

}
