//package fr.nouas.main.action;
//
//import java.awt.print.Book;
//import java.util.ArrayList;
//
//import javax.persistence.EntityManager;
//import javax.persistence.RollbackException;
//import javax.servlet.http.HttpServletRequest;
//
//import fr.nouas.beans.Question;
//import fr.nouas.pojo.utils.Action;
//import fr.nouas.utils.JpaUtil;
//import fr.youcef.model.beans.Author;
//import fr.youcef.model.utils.Country;
//
//public class AddQuestion extends Action {
//
//	@Override
//	public boolean executeAction(HttpServletRequest request) {
//		if(request.getMethod().equals("POST")) {
//			
//			
////			creation du book a partir des paramatres de la request
//		
//			Question question = new Question(
//					request.getParameter("question"),
//					request.getParameter("reponse")
//					re
//				
//			);
//			
//			// gestion de la disponibilite et du boolean en base de donnée
//		
//			
//			
//			// ajout dun auteur au livre obtenu a partir des paramatres de la requetes
//			
//			Author author = new Author(
//					request.getParameter("author-firstname"),
//					request.getParameter("author-lastname"),
//					Country.AFRIQUE);
//			book.addAuthor(author);
//			// insertion du livre en base de données
//			
//			
//			// connection a la base de donnée, recuperation de l EMF grace a jpa util. la creation de EMF est faite au lancement de lappli7
//			// grace a un ecouteur devenement	
//			
//			EntityManager em = JpaUtil.getEntityManager();	
//			
//		
//
//		try{
//			em.getTransaction().begin();
//			em.persist(book);
//		
//			em.getTransaction().commit();
//		} catch (RollbackException e) {
//			em.getTransaction().rollback();
//		}
//		em.close();
//		
//		 return true;
//		}
//			return false;
//		} 
//	}
//
//}
