package fr.nouas.pojo.utils;

import java.util.HashMap;
import java.util.Map;



public final class ActionManager  { //final pour que personne puisse la modifier et personne la prenne en heritage
		
	
		public static final String ACTION_HOME ="home";
	    public static final String ACTION_ADD = "add";
		public static final String ACTION_DELETE ="delete";
		public static final String ACTION_EDIT ="edit";
		public static final String ACTION_LIST_BOOKS ="books";
		public static final String ACTION_FIND_ID ="findbyid";
		public static final String ACTION_FIND_TITLE ="findbytitle";
		public static final String ACTION_FIND_AUTHOR ="findbyauthor";
		public static final String ACTION_ADD_AUTHOR ="addauthor";
		public static final String ACTION_SIGN_IN_ ="signin";
		public static final String ACTION_LOG_IN ="login";
		public static final String ACTION_LOG_OUT ="logout";

		
	private ActionManager() {} // pour la protger et quon puisse pas linstancier
	
	private static Map <String, Action> actions;// recoit le nom de laction (actionname)string et cree un action
	
	static {
		actions = new HashMap<String, Action>(); 
		actions.put(ACTION_HOME, new HomeAction());
	
	}
	public static Action getAction(String actionName) {   // c la que en fonction de laction (string) envoyer par la frontservlet on fait une action
		return actions.get(actionName);				// get permet de recuperer l'acion de la map grace a la cle
	}
}
