//package fr.nouas.main.action;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//
//import fr.nouas.pojo.utils.Action;
//
//public class CreatePdf extends Action {
//	@Override	
//	public boolean executeAction(HttpServletRequest request) {
//		//Creating a new document
//        PDDocument document = new PDDocument();
//        
//        //Creating a new page and adding it to the document
//        PDPage page = new PDPage();
//        document.addPage(page);
//        
//        PDFont font = PDType1Font.HELVETICA_BOLD_OBLIQUE;
//        
//        try
//        {
//            //ContentStream holds the content
//            PDPageContentStream contentStream = new PDPageContentStream(document,page);
//                        
//            //Set the starting offset for contentStream and font
//            contentStream.beginText();
//            contentStream.setFont(font, 14);
//            //Text offset
//            contentStream.newLineAtOffset(100, 500);
//           
//            //Display the mentioned text at the offset specified
//            contentStream.showText("PDF created using Apache PDFBox 2.0");
//            contentStream.endText();
//         
//            //Closing the contentStream
//            contentStream.close();
//            //Location for saving the pdf file
//            document.save("c://images//Hello.pdf");
//            //Closing the document
//            document.close();
//        }
//        catch(IOException ie)
//        {
//            ie.printStackTrace();
//        }
//			return true;
//		
//	}
//}
