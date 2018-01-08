package fr.nouas.main.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Questionnaire;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class ShowQuestionnaire extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("questionnaire"));
		

		EntityManager em = JpaUtil.getEntityManager();
	
		
		
		Questionnaire questionnaire = em.find(Questionnaire.class, id);
		
		request.setAttribute("questionnaire", questionnaire);
	
		
		return false;
	}

}
