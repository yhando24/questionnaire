package fr.nouas.main.action;



import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import javax.servlet.http.HttpServletRequest;



import fr.nouas.beans.Question;
<<<<<<< HEAD

=======
import fr.nouas.beans.Questionnaire;
>>>>>>> a822c522b5184c8c12009c51495d3bdd51f1d953
import fr.nouas.pojo.utils.Action;

import fr.nouas.utils.JpaUtil;



public class DeleteQuestion extends Action {

	@Override

	public boolean executeAction(HttpServletRequest request) {

<<<<<<< HEAD
		

		String idStr = request.getParameter("id");

		System.out.println(idStr);

		if (idStr != null) {

			try {

				int id = Integer.parseInt(idStr);

				

=======
		String idStr = request.getParameter("question");
		String idque = request.getParameter("questionnaire");
		System.out.println(idStr);
		if (idStr != null && idque != null) {
			try {
				int idquestion = Integer.parseInt(idStr);
				int idquestionnaire = Integer.parseInt(idque);
>>>>>>> a822c522b5184c8c12009c51495d3bdd51f1d953
				EntityManager em = JpaUtil.getEntityManager();

				EntityTransaction tr = em.getTransaction();

				

				

				try {
<<<<<<< HEAD

					Question question = em.find(Question.class, id);

					tr.begin();

					em.remove(question);

=======
					Question question = em.find(Question.class, idquestion);
					Questionnaire questionnaire = em.find(Questionnaire.class, idquestionnaire);
					questionnaire.deleteQuestion(question);
					question.setQuestionnaire(null);
					tr.begin();
					em.persist(questionnaire);
					em.persist(question);
>>>>>>> a822c522b5184c8c12009c51495d3bdd51f1d953
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