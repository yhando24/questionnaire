package fr.nouas.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.nouas.main.action.AddQuestion;
import fr.nouas.pojo.utils.ActionManager;

@WebServlet(name="/FrontServlet",
		value= { "/home", "/mathematique", "/francais", "/addCategory", "/addQuestionnaire", "/questionnaire", "/addQuestion"}
		)
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_HOME = "/WEB-INF/index.jsp";
	private static final String PAGE_QUESTIONNAIRE ="/WEB-INF/questionnaire.jsp";
	
    public FrontServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String userName = request.getParameter("userName").trim();
//		if(userName == null || "".equals(userName)){
//			userName = "Guest";
//		}
//		
//		String greetings = "Hello " + userName;
		
//		response.setContentType("text/plain");
//		response.getWriter().write("toto");
		
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
				case "AddQuestion":
					getServletContext().getRequestDispatcher(PAGE_QUESTIONNAIRE).forward(request, response);
					break;
				default :
					response.sendRedirect(request.getContextPath() +"/home");
				}
			}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionName = getActionName(request);
		boolean redirect = ActionManager.getAction(actionName).executeAction(request);
		
		if (redirect) {
		
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			System.out.println("dans le switch: " + actionName);
			switch(actionName)
			{
			case "addQuestion":
				response.sendRedirect(request.getContextPath() +"/questionnaire?"+request.getQueryString());
				System.out.println("dans le case addquestion");
		
			
			}
		}
	}
	
	private String getActionName(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1); 
		return uri;
	}
	
	private int getQueryString(HttpServletRequest req) {
		int QueryString = Integer.parseInt(req.getQueryString());
		return QueryString;
	}

}
