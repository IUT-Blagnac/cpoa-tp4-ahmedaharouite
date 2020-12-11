package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;

public class ActionSupprimerCompte implements Action<Object>{
	
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

	@SuppressWarnings("resource")
	@Override
	public void execute(Object ag) throws Exception {
		System.out.print("Num compte -> ");
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		
		((AgenceBancaire) ag).removeCompte(numero);	
	}

}
