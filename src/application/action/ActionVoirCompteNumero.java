package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero<E> implements Action<Object> {

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

	@SuppressWarnings("resource")
	@Override
	public void execute(Object ag) throws Exception {
		System.out.print("Num compte -> ");
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		Compte c = ((AgenceBancaire) ag).getCompte(numero);
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
	}

}
