package fr.nouas.main.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.Reponse;
import fr.nouas.beans.User;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class ShowQuestionnaire extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("questionnaire"));
		String VersionSession = null;
		int idUser = Integer.parseInt(request.getSession().getAttribute("userid").toString());
  	   System.out.println( "id user : " + idUser);
//		String nextVersion= request.getParameter("nextVersion");
//		String checkVersion;
		if(request.getMethod().equals("POST")) {
			 String checkVersion= request.getParameter("checkVersion");
			  System.out.println( "checkVersion : " + checkVersion);
			  request.getSession().setAttribute("checkVersion", checkVersion);
		}
		
		try{
			 VersionSession = request.getSession().getAttribute("checkVersion").toString();
		}
		catch (Exception e) {
			System.out.println("premier passage");
		}
		
		   EntityManager em = JpaUtil.getEntityManager();
		   
		   Questionnaire questionnaire = em.find(Questionnaire.class, id);
		   
	     	request.setAttribute("questionnaire", questionnaire);
	     	
	     
//	     	VERIFICATION QUESTIONNAIRY DONE :
	     	Boolean DoneQuestionnary = false;

	     	try {
	     		
	     		
	     		
	    	 Query q, q1;
	    			
//	    	   Recuperation du nombre de version existante
	    		 q1 = em.createQuery("SELECT R FROM Reponse R Where user_id=:idUser AND questionnaire_id=:idquestionnaire"
	    		 		+ " AND version = (SELECT MAX(version) FROM Reponse WHERE user_id=:idUser AND questionnaire_id=:idquestionnaire )");
	    		   q1.setParameter("idUser", idUser); 
		    	   q1.setParameter("idquestionnaire", id); 
	    		 List <Reponse> Versionreponses = (List <Reponse>) q1.getResultList();
	    		 int SendVersion = 0;
	    		 for ( Reponse reponse : Versionreponses) {
	    			 System.out.println("DANS LES VERSIONS  " + reponse.getVersion() );	
	    			 if(reponse.getVersion() > SendVersion) {
	    				 SendVersion = reponse.getVersion();
	    			 }
	    		 }
	     		try {
	     			request.setAttribute("lastVersion", SendVersion);
	     			System.out.println("DANS LE MAUVAIS  " + SendVersion );	
	     		}
	     		catch (Exception e) {
	     			 System.out.println("DANS LE MAUVAIS CATCH pas de lastversion" );	
				}
	    	 
	    
	     	   
//	     	   Si l'utilisateur veux une version particuliere
	     	  if( VersionSession != null) {
	     		  q = em.createQuery("SELECT R FROM Reponse R Where user_id=:idUser AND questionnaire_id=:idquestionnaire AND version =:checkVersion");
	     		 q.setParameter("checkVersion", Integer.parseInt(VersionSession)); 
	     		 System.out.println("dans le versionSession pas egale nul" + Integer.parseInt(VersionSession));
	     	  }	// Si derniere version 
	     	  	else {
	      		  q = em.createQuery("SELECT R FROM Reponse R Where user_id=:idUser AND questionnaire_id=:idquestionnaire" + 
	      		  	 " AND version = (SELECT MAX(version) FROM Reponse WHERE user_id=:idUser AND questionnaire_id=:idquestionnaire )");
	      		 System.out.println("dans le versionSession  egale nul");
	     	  	}
	     	 System.out.println("idquesitionnaire " + id);
	     	System.out.println("iduser " + idUser);
	     	   q.setParameter("idUser", idUser); 
	    	   q.setParameter("idquestionnaire", id); 
	    	  
	    	   
	    	   List <Reponse> reponses = (List <Reponse>) q.getResultList();
	    	 
	    	   if(!reponses.isEmpty()) {
	    		   DoneQuestionnary = true;
	    		 System.out.println("jai bien le check reponse ? : "+ VersionSession + "et" + reponses.get(0).getVersion()); 	
	    	
	    		   request.setAttribute("reponses", reponses);
	    		   System.out.println("JE SUISUIS JSDIOS KSDQP XKPQSDKSPJ OHCI"); 
	    	   }
	    	   

	    	   
	     	}   
   	   
    	   catch (Exception e) {	
    		   System.out.println("DANS LE MAUVAIS CATCH " );			
			}	    	
	    	System.out.println("questionnaire fait? : " + DoneQuestionnary);
	    	 request.setAttribute("DoneQuestionnary", DoneQuestionnary);
	    	 
	    	 Boolean AddNewVersion = false;
//	    	CREATION NOUVELLE VERSION
    	  
	    	 String nextVersion= request.getParameter("nextVersion");
	    	 System.out.println("VERSION A CREER : " + nextVersion);
	    	 if( nextVersion != null) {
	    		 AddNewVersion = true;
 		 
	    	 }
	    	
	    	 System.out.println("Ajout de Version : " + AddNewVersion);
	    	 request.setAttribute("AddNewVersion", AddNewVersion);
	    
	    	
//	    	 RECUPERATION DES BONNES REPONSES 
	    	 if(DoneQuestionnary == true) {
	    		 Query q3 =  em.createQuery("SELECT R FROM Reponse R Where"
	    		 		+ " questionnaire_id=:idquestionnaire AND correct = true");
	    	
		    	   q3.setParameter("idquestionnaire", id); 
	    		 List <Reponse> bonneReponses = (List <Reponse>) q3.getResultList();
	    		 request.setAttribute("bonneReponses", bonneReponses);
	    		 System.out.println("LA PREMIERE REPONSE : " + bonneReponses.get(0).getReponse());
	    	 }
	    	 
//          RECUPERATION DES USERS DU QUESTIONNAIRE 
//	    	 Query q4 =  em.createQuery("SELECT U FROM User  U"
//	    	 			+ "	INNER JOIN questionnaires_users  qu WHERE qu.questionnaire_id =:idquestionnaire");
//	    	 q4.setParameter("idquestionnaire", id); 
//	    	 List <User> UsersQuestionnaire = (List <User>) q4.getResultList();
//	    	 request.setAttribute("UsersQuestionnaire", UsersQuestionnaire);
	    	 
    	   return false;
	}
}
           
       