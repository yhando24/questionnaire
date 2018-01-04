package fr.nouas.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.nouas.pojo.utils.ActionManager;

@WebServlet(name="/FrontServlet",
		value= { "/home", "/mathematique", "/francais", "/addCategory", "/addQuestionnaire", "/questionnaire"}
		)
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_HOME = "/WEB-INF/index.jsp";
	private static final String PAGE_QUESTIONNAIRE ="/resources/fragments/questionnaire.jsp";
	
    public FrontServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionName = getActionName(request);
		boolean redirect = ActionManager.getAction(actionName).executeAction(request);
		System.out.println("action name : " + actionName);
		request.setAttribute("actionName", actionName);
		
			if(redirect) {
				
				getServletContext().getRequestDispatcher(PAGE_HOME).forward(request, response);

			}else { 
				switch(actionName)
				{
				case "questionnaire":
					getServletContext().getRequestDispatcher(PAGE_QUESTIONNAIRE).forward(request, response);
					break;
				default :
					response.sendRedirect(request.getContextPath() + "/home");
				}
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionName = getActionName(request);
		boolean redirect = ActionManager.getAction(actionName).executeAction(request);
		
		if (redirect) {
		
			response.sendRedirect(request.getContextPath() + "/home");
		} else {

			response.sendRedirect(request.getContextPath() + "/" + actionName);

		}
	}
	
	private String getActionName(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1); 
		return uri;
	}
	

}
