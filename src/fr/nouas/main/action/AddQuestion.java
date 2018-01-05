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

	@Override
	public boolean executeAction(HttpServletRequest request) {
		if(request.getMethod().equals("POST")) {
			
			int id = Integer.parseInt(request.getParameter("questionnaire_id"));

			
			List <Reponse> reponses = new ArrayList();
			Reponse bonneReponse = new Reponse(
					request.getParameter("Correct"),
					true,
					null);
			EntityManager em = JpaUtil.getEntityManager();
			EntityTransaction tr = em.getTransaction();
			
			Questionnaire questionnaire = em.find(Questionnaire.class, id);
			System.out.println("je suis dans le post dadd question pour le questionnaire : " + questionnaire.getName());
			
//			pour les qcm faire le if
			if(request.getParameter("type").equals("QCM")) {
				
			System.out.println("c'est bien un QCM ! ");
				
				
				
			Question question = new Question(
					request.getParameter("question"),
					TypeQuestion.valueOf(request.getParameter("type")),
					bonneReponse,	
					reponses,
					questionnaire	
			);
			bonneReponse.setQuestion(question);
			
			
			Reponse mauvaiseReponse1 = new Reponse(
					request.getParameter("NotCorrect"),
					false,
					question);
			reponses.add(mauvaiseReponse1);
		
			tr.begin();
			em.persist(question);
			em.persist(bonneReponse);
			em.persist(mauvaiseReponse1);
			tr.commit();
			
			return false;
			}
//
//			Questionnaire questionnaire = new Questionnaire (
//					request.getParameter("name_questionnaire"),
//					request.getParameter("description_questionnaire"),
//					category);
//			
//		
//			boolean add = false;
//			
//		
//			List <Questionnaire> questionnaires =  category.getQuestionnaires();
//			for ( Questionnaire questionnairesCategory : questionnaires) {
//				if(questionnairesCategory.getName() != questionnaire.getName() ||
//					questionnairesCategory.getDescription() != questionnaire.getDescription() ) {
//					add = true;
//				}
//				
//			}
//			if(add) 
//			{
//					category.addQuestionnaire(questionnaire);
//					}
//			
//			tr.begin();
//			em.persist(questionnaire);
//			em.persist(category);
//			tr.commit();
//		
//			
//			
		
//		};
}
		return false;
	} 
}
