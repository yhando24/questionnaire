package fr.nouas.main.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Question;
import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.Reponse;
import fr.nouas.beans.User;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class ValidQuestionnaire extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("questionnaire");
		System.out.println(idStr);
		if (idStr != null) {
			
				int id = Integer.parseInt(idStr);
				
				EntityManager em = JpaUtil.getEntityManager();
				EntityTransaction tr = em.getTransaction();
				
				
				
					Questionnaire questionnaire = em.find(Questionnaire.class, id);
					String nbQuestion = request.getParameter("nbQuestion");
					int iduser = Integer.parseInt(request.getParameter("user"));
					User user = em.find(User.class, iduser);
				
					System.out.println(nbQuestion);
					
					if (nbQuestion != null) {
						int intNbQuestion= Integer.parseInt(request.getParameter("nbQuestion"));
						Reponse [] reponses = new Reponse [intNbQuestion];
						System.out.println("question : ");
						for (int i = 0; i < intNbQuestion; i++ ) {
							 reponses[i] = new Reponse (
									 request.getParameter("reponseEleve"+(i+1)), 
									 em.find(Question.class, Integer.parseInt(request.getParameter("question"+(i+1)))));
							
							reponses[i].setUser(user);
							questionnaire.addUser(user);
							
								try {
									tr.begin();
									em.persist(reponses[i]);
									
							
									tr.commit();
								} catch (Exception e) {
									tr.rollback();
									e.printStackTrace();
								}
								
							
						}
						
							
							
						}
						
						
						
						
					
					
					
					
					
		
			}
		
			
		
		
		return true;
	}
}
			
	
	
		
			
		

		

