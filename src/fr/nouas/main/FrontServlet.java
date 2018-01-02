package fr.nouas.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/FrontServlet",
		value= { "/home", "/mathematique", "/francais"}
		)
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_HOME = "/WEB-INF/index.jsp";
	
    public FrontServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(PAGE_HOME).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
