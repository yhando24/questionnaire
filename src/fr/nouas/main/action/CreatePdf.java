package fr.nouas.main.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;


import fr.nouas.pojo.utils.Action;


public class CreatePdf extends Action {

	@Override
	public boolean executeAction(HttpServletRequest request) {
	
			 
		/** The target folder for the result. */
		final String ADDRESS = request.getParameter("url");
		System.out.println(ADDRESS);

		/** The path to the resulting PDF file. */
		String DEST = "/Pdf/test.pdf";
		
		/**
		 * The main method of this example.
		 *
		 * @param args no arguments are needed to run this example.
		 * @throws IOException Signals that an I/O exception has occurred.
		 */

		URL url;
		URL urlTemp;

		try {
			// get URL content
			url = new URL(ADDRESS);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;

			//save to this filename
			String fileName = "/Pdf/Temp/test.html";
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
	        File file = new File(DEST);
	        
	
	      file.getParentFile().mkdirs(); 
	      if (!file.exists()) {
	          try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      } 
	        try {
	        	String fileName = "file:///Pdf/Temp/test.html";
	        	urlTemp = new URL(fileName);
	        	System.out.println(urlTemp);
				new CreatePdf().createPdf(urlTemp, DEST);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 

	    /**
	     * Creates the PDF file.
	     *
	     * @param url the URL object for the web page
	     * @param dest the path to the resulting PDF
	     * @throws IOException Signals that an I/O exception has occurred.
	     */
	    
		
		
		
		return true;
	}
	
	public void createPdf(URL url, String dest) throws IOException {
		try {

			HtmlConverter.convertToPdf(url.openStream(), new FileOutputStream(dest));			
		} catch (Exception e) {
//=======
//			PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
//			
//			Document document = new Document(pdf);
//			document.add(new Paragraph(user.getlastname()+" "+user.getfirstname()));
//			document.add(new Paragraph(category.getName()+" "+questionnaire.getName()));
//			document.add(new Paragraph(category.getName()+" "+questionnaire.getName()));
//			document.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//>>>>>>> 73125d6
			e.printStackTrace();
		}
    }
}
