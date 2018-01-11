package fr.nouas.main.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Question;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class DeleteQuestion extends Action {
	@Override
	public boolean executeAction(HttpServletRequest request) {
		
		String idStr = request.getParameter("question");
		System.out.println(idStr);
		if (idStr != null) {
			try {
				int id = Integer.parseInt(idStr);
				
				EntityManager em = JpaUtil.getEntityManager();
				EntityTransaction tr = em.getTransaction();
				
				
				try {
					Question question = em.find(Question.class, id);
					tr.begin();
					em.remove(question);
					tr.commit();
				} catch (Exception e) {
					tr.rollback();
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
