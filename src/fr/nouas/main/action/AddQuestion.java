package fr.nouas.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Question;
import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.Reponse;
import fr.nouas.enums.TypeQuestion;

import fr.nouas.pojo.utils.Action;

import fr.nouas.utils.JpaUtil;

public class AddQuestion extends Action {

	int idQuestionnaire = 0;

	@Override

	public boolean executeAction(HttpServletRequest request) {

		if (request.getMethod().equals("POST")) {

			idQuestionnaire = Integer.parseInt(request.getParameter("questionnaire"));

			List<Reponse> reponses = new ArrayList();

			EntityManager em = JpaUtil.getEntityManager();

			EntityTransaction tr = em.getTransaction();

			Questionnaire questionnaire = em.find(Questionnaire.class, idQuestionnaire);

			System.out.println("je suis dans le post dadd question pour le questionnaire : " + questionnaire.getName());

			// pour les qcm faire le if

			if (request.getParameter("type").equals("QCM")) {

				System.out.println("c'est bien un QCM ! ");

				Reponse bonneReponse = new Reponse(

						request.getParameter("correctQcm"),

						true,

						null);

				Question question = new Question(

						request.getParameter("questionQcm"),

						TypeQuestion.valueOf(request.getParameter("type")),

						bonneReponse,

						reponses,

						questionnaire

				);

				bonneReponse.setQuestion(question);

				Reponse mauvaiseReponse1 = new Reponse(

						request.getParameter("notCorrectQcm1"),

						false,

						question);

				reponses.add(mauvaiseReponse1);

				Reponse mauvaiseReponse2 = new Reponse(

						request.getParameter("notCorrectQcm2"),

						false,

						question);

				reponses.add(mauvaiseReponse2);

				Reponse mauvaiseReponse3 = new Reponse(

						request.getParameter("notCorrectQcm3"),

						false,

						question);

				reponses.add(mauvaiseReponse3);

				tr.begin();

				em.persist(question);

				em.persist(bonneReponse);

				em.persist(mauvaiseReponse1);

				em.persist(mauvaiseReponse2);

				em.persist(mauvaiseReponse3);

				tr.commit();

			}

			if (request.getParameter("type").equals("QUESTION_SIMPLE")) {

				System.out.println("c'est bien une question simple ! ");

				Reponse bonneReponse = new Reponse(

						request.getParameter("reponse"),

						true,

						null);

				Question question = new Question(

						request.getParameter("questionSimple"),

						TypeQuestion.valueOf(request.getParameter("type")),

						bonneReponse,

						questionnaire

				);

				bonneReponse.setQuestion(question);

				tr.begin();

				em.persist(question);

				em.persist(bonneReponse);

				tr.commit();

			}

			//

			// Questionnaire questionnaire = new Questionnaire (

			// request.getParameter("name_questionnaire"),

			// request.getParameter("description_questionnaire"),

			// category);

			//

			//

			// boolean add = false;

			//

			//

			// List <Questionnaire> questionnaires = category.getQuestionnaires();

			// for ( Questionnaire questionnairesCategory : questionnaires) {

			// if(questionnairesCategory.getName() != questionnaire.getName() ||

			// questionnairesCategory.getDescription() != questionnaire.getDescription() ) {

			// add = true;

			// }

			//

			// }

			// if(add)

			// {

			// category.addQuestionnaire(questionnaire);

			// }

			//

			// tr.begin();

			// em.persist(questionnaire);

			// em.persist(category);

			// tr.commit();

			//

			//

			//

			return false;

			// };

		}

		return false;

	}

}