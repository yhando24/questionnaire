package fr.nouas.main.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;

import fr.nouas.beans.Category;
import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.User;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

@WrapToTest
public class CreatePdf extends Action {
	
	@Override
	public boolean executeAction(HttpServletRequest request) {
		int  questionnaireId = Integer.parseInt(request.getParameter("questionnaire"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int userId = Integer.parseInt(request.getParameter("user"));
		
		EntityManager em = JpaUtil.getEntityManager();
//		EntityTransaction tr = em.getTransaction();

		Questionnaire questionnaire = em.find(Questionnaire.class, questionnaireId);
		Category category = em.find(Category.class, categoryId);
		User user = em.find(User.class, userId);
		
		String DEST = "/Pdf/"+user.getlastname()+"_"+user.getfirstname()+"/"+category.getName()+"/"+questionnaire.getName()+"_"+user.getlastname()+"-"+user.getfirstname()+".pdf";
		File file = new File(DEST);
	     file.getParentFile().mkdirs();
	     try {
			FileWriter writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     CreatePdf newPdf = new CreatePdf(); 
	     newPdf.createPdf(DEST, request);
		
	     
    	
		return true;
	}

	private void createPdf(String dest, HttpServletRequest request) {
		int  questionnaireId = Integer.parseInt(request.getParameter("questionnaire"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int userId = Integer.parseInt(request.getParameter("user"));
		
		EntityManager em = JpaUtil.getEntityManager();
//		EntityTransaction tr = em.getTransaction();

		Questionnaire questionnaire = em.find(Questionnaire.class, questionnaireId);
		Category category = em.find(Category.class, categoryId);
		User user = em.find(User.class, userId);
		
		try {
			PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
			
			Document document = new Document(pdf);
			document.add(new Paragraph(user.getlastname()+" "+user.getfirstname()));
			document.add(new Paragraph(category.getName()+" "+questionnaire.getName()));
			document.add(new Paragraph(category.getName()+" "+questionnaire.getName()));
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
