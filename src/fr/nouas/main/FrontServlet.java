package fr.nouas.main;

import java.io.IOException;

<<<<<<< HEAD
=======
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



>>>>>>> 1be068c5097978b8d41ec8efbf2ffa154b1c4fba
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FrontServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
