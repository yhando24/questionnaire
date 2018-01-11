package fr.nouas.pojo.utils;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import fr.nouas.beans.Category;
import fr.nouas.utils.JpaUtil;

public class ShowCategorie extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("categorie"));
		EntityManager em = JpaUtil.getEntityManager();
		
		Category categorie = em.find(Category.class, id);
		request.setAttribute("categorie", categorie);
		return true;
	}

}
