package fr.nouas.main.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;



import fr.nouas.beans.Question;
import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.Reponse;
import fr.nouas.enums.TypeQuestion;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class AddQuestion extends Action {

	int idQuestionnaire = 0;

	@Override

	public boolean executeAction(HttpServletRequest request) {

		if (request.getMethod().equals("POST")) {
			
			String uri= "http://localhost:8081/questionnaire/questionnaire";
			final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

	        final FileDataBodyPart filePart = new FileDataBodyPart("image", new File("C://images/test.png"));
	        FormDataMultiPart multipart = new FormDataMultiPart();

	        multipart.bodyPart(filePart);

	        final WebTarget target = client.target(uri);

	        final Response response = target.request()
	                .post(Entity.entity(multipart, multipart.getMediaType()));

	        System.out.println(response);

	        try {
				multipart.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

			idQuestionnaire = Integer.parseInt(request.getParameter("questionnaire"));

			List<Reponse> reponses = new ArrayList();

			EntityManager em = JpaUtil.getEntityManager();

			EntityTransaction tr = em.getTransaction();

			Questionnaire questionnaire = em.find(Questionnaire.class, idQuestionnaire);

			System.out.println("je suis dans le post dadd question pour le questionnaire : " + questionnaire.getName());

			// pour les qcm faire le if

			if (request.getParameter("type").equals("QCM")) {

				System.out.println("c'est bien un QCM ! ");

				Reponse bonneReponse = new Reponse(request.getParameter("correctQcm"), true, null, questionnaire);

				Question question = new Question(

						request.getParameter("questionQcm"),

						TypeQuestion.valueOf(request.getParameter("type")),

						bonneReponse,

						reponses,

						questionnaire

				);

				bonneReponse.setQuestion(question);

				Reponse mauvaiseReponse1 = new Reponse(request.getParameter("notCorrectQcm1"), false, question,
						questionnaire);
				reponses.add(mauvaiseReponse1);

				Reponse mauvaiseReponse2 = new Reponse(request.getParameter("notCorrectQcm2"), false, question,
						questionnaire);
				reponses.add(mauvaiseReponse2);

				Collections.shuffle(reponses);

				tr.begin();

				em.persist(question);

				em.persist(bonneReponse);

				em.persist(mauvaiseReponse1);

				em.persist(mauvaiseReponse2);

				tr.commit();

			}

			if (request.getParameter("type").equals("QUESTION_SIMPLE")) {

				System.out.println("c'est bien une question simple ! ");

				Reponse bonneReponse = new Reponse(request.getParameter("reponse"), true, null, questionnaire);

				Question question = new Question(request.getParameter("questionSimple"),
						TypeQuestion.valueOf(request.getParameter("type")), bonneReponse, questionnaire);
				bonneReponse.setQuestion(question);
				System.out.println(request.getParameter("pourcentageNeed"));
				question.setPourcentageNeed(Integer.parseInt(request.getParameter("pourcentageNeed")));

				tr.begin();
				em.persist(question);
				em.persist(bonneReponse);
				tr.commit();

			}

			return false;

		}

		return false;

	}

}