package application.actionlist;

import java.util.ArrayList;

import action.Action;
import action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire implements ActionList {

	private String message;
	private String code;
	private String title;
	private ArrayList <Action> listeActions;
	
	public ActionListAgenceBancaire(String message, String code, String title, ArrayList <Action> listeActions) {
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

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		for(int i=0; i<this.size(); i++) {
			System.out.println(listeActions.get(i).actionCode() + " - " + listeActions.get(i).actionMessage());
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

	@Override
	public boolean addAction(Action ac) {
		boolean bool = true;
		
		for(int i=0; i<this.size(); i++) {
			if(listeActions.get(i).equals(ac)) {
				bool = false;
			}
		}
		if (bool == false) {
		 listeActions.add(ac);
		}
		
		return bool;
	}

}
