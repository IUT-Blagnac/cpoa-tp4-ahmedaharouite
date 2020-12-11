package application.action;

import action.Action;
import banque.AgenceBancaire;

public class ActionListeDesComptes implements Action<Object> {

	private String message;
	private String code;
	
	public ActionListeDesComptes(String message, String code) {
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
	public void execute(Object ag) throws Exception {
		((AgenceBancaire) ag).afficher();
	}
}
