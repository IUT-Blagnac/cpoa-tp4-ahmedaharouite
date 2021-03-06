package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ActionRetirerArgent<E> implements Action<Object>{
	
	private String message;
	private String code;
	
	public ActionRetirerArgent(String message, String code) {
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
		System.out.print("Montant à retirer -> ");
		double montant = lect.nextDouble();
		
		Compte c = ((AgenceBancaire) ag).getCompte(numero);
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retiré, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
		
	}

}
