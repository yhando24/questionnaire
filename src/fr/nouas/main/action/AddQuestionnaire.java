package fr.nouas.main.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Category;
import fr.nouas.beans.Questionnaire;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;


public class AddQuestionnaire extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
		
					int id = Integer.parseInt(request.getParameter("idCategory"));
					
				
					EntityManager em = JpaUtil.getEntityManager();
					EntityTransaction tr = em.getTransaction();
				
					
					
					Category category = em.find(Category.class, id);
					

					Questionnaire questionnaire = new Questionnaire (
							request.getParameter("name_questionnaire"),
							request.getParameter("description_questionnaire"),
							category);
					
				
					boolean add = false;
					
				
					List <Questionnaire> questionnaires =  category.getQuestionnaires();
					for ( Questionnaire questionnairesCategory : questionnaires) {
						if(questionnairesCategory.getName() != questionnaire.getName() ||
							questionnairesCategory.getDescription() != questionnaire.getDescription() ) {
							add = true;
						}
						
					}
					if(add) 
					{
							category.addQuestionnaire(questionnaire);
							}
					
					tr.begin();
					em.persist(questionnaire);
					em.persist(category);
					tr.commit();
				
					
					
					return true;
				};
}
