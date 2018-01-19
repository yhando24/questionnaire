package fr.nouas.main.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import fr.nouas.beans.Question;
import fr.nouas.beans.Questionnaire;
import fr.nouas.beans.Reponse;
import fr.nouas.enums.TypeQuestion;
import fr.nouas.pojo.utils.Action;
import fr.nouas.utils.JpaUtil;

public class AddQuestion extends Action {
	
	private static final String CHAMP_type = "type";
	private static final String CHAMP_QUESTIONQQCM     = "questionQcm";
    private static final String CHAMP_correctQcm = "correctQcm";
    private static final String CHAMP_notCorrectQcm1 = "notCorrectQcm1";
    private static final String CHAMP_notCorrectQcm2 = "notCorrectQcm2";
    private static final String CHAMP_questionSimple    = "questionSimple";
    private static final String CHAMP_reponse = "reponse";
    
    
    private static final int    TAILLE_TAMPON     = 10240;                        // 10 ko

    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
	int idQuestionnaire = 0;

	@Override
	public boolean executeAction(HttpServletRequest request) {
		
		if (request.getMethod().equals("POST")) {

			idQuestionnaire = Integer.parseInt(request.getParameter("questionnaire"));

			List<Reponse> reponses = new ArrayList();

			EntityManager em = JpaUtil.getEntityManager();
			EntityTransaction tr = em.getTransaction();

			Questionnaire questionnaire = em.find(Questionnaire.class, idQuestionnaire);
			System.out.println("je suis dans le post dadd question pour le questionnaire : " + questionnaire.getName());

//			// pour les qcm faire le if
//			if (request.getParameter("type").equals("QCM")) {
//
//				System.out.println("c'est bien un QCM ! ");
//
//				Reponse bonneReponse = new Reponse(request.getParameter("correctQcm"), true, null, questionnaire);
//
//				Question question = new Question(
//						request.getParameter("questionQcm"), TypeQuestion.valueOf(request.getParameter("type")),
//						bonneReponse, reponses, questionnaire);
//				bonneReponse.setQuestion(question);
//
//				Reponse mauvaiseReponse1 = new Reponse(request.getParameter("notCorrectQcm1"), false, question, questionnaire);
//				reponses.add(mauvaiseReponse1);
//
//				Reponse mauvaiseReponse2 = new Reponse(request.getParameter("notCorrectQcm2"), false, question, questionnaire);
//				reponses.add(mauvaiseReponse2);
//
//				Collections.shuffle(reponses);
//
//				tr.begin();
//				em.persist(question);
//				em.persist(bonneReponse);
//				em.persist(mauvaiseReponse1);
//				em.persist(mauvaiseReponse2);
//		
//				tr.commit();
//
//			}
//			if (request.getParameter("type").equals("QUESTION_SIMPLE")) {
//
//				System.out.println("c'est bien une question simple ! ");
//
//				Reponse bonneReponse = new Reponse(request.getParameter("reponse"), true, null, questionnaire);
//
//				Question question = new Question(request.getParameter("questionSimple"),
//						TypeQuestion.valueOf(request.getParameter("type")), bonneReponse, questionnaire);
//				bonneReponse.setQuestion(question);
//				System.out.println(request.getParameter("pourcentageNeed"));
//				question.setPourcentageNeed(Integer.parseInt(request.getParameter("pourcentageNeed")));
//
//				tr.begin();
//				em.persist(question);
//				em.persist(bonneReponse);
//				tr.commit();
//
//			}
//			
//			return false;
//
//		
//		}

	
			Question question = new Question ();
			String type = getValeurChamp( request, CHAMP_type );
			
			
			
			
			if (type.equals("QCM")) {

			
				String questionQcm = getValeurChamp( request, CHAMP_QUESTIONQQCM );
				String correctQcm = getValeurChamp( request, CHAMP_correctQcm );
				String notCorrectQcm1 = getValeurChamp( request, notCorrectQcm1 );
				String notCorrectQcm2 = getValeurChamp( request, notCorrectQcm2 );

				System.out.println(type + "LE TYPE");	
				Reponse bonneReponse = new Reponse(request.getParameter("correctQcm"), true, null, questionnaire);

				 question = new Question(
						request.getParameter("questionQcm"), TypeQuestion.valueOf(request.getParameter("type")),
						bonneReponse, reponses, questionnaire);
				bonneReponse.setQuestion(question);

				Reponse mauvaiseReponse1 = new Reponse(request.getParameter("notCorrectQcm1"), false, question, questionnaire);
				reponses.add(mauvaiseReponse1);

				Reponse mauvaiseReponse2 = new Reponse(request.getParameter("notCorrectQcm2"), false, question, questionnaire);
				reponses.add(mauvaiseReponse2);

				Collections.shuffle(reponses);

				tr.begin();
				em.persist(question);
				em.persist(bonneReponse);
				em.persist(mauvaiseReponse1);
				em.persist(mauvaiseReponse2);
		
				tr.commit();

			}
			if (type.equals("QUESTION_SIMPLE")) {

				System.out.println("c'est bien une question simple ! ");

				Reponse bonneReponse = new Reponse(request.getParameter("reponse"), true, null, questionnaire);

				 question = new Question(request.getParameter("questionSimple"),
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
	
	
	
					return false;					}
	
	
	
	
	
//	METHODE UTILITAIRES
	
	
	
	
	
	/*
     * Valide la description saisie.
     */
    private void validationDescription( String description ) throws Exception {
        if ( description != null ) {
            if ( description.length() < 15 ) {
                throw new Exception( "La phrase de description du fichier doit contenir au moins 15 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une phrase de description du fichier." );
        }
    }

    /*
     * Valide le fichier envoyé.
     */
    private void validationFichier( String nomFichier, InputStream contenuFichier ) throws Exception {
        if ( nomFichier == null || contenuFichier == null ) {
            throw new Exception( "Merci de sélectionner un fichier à envoyer." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    /*
     * Méthode utilitaire qui a pour unique but d'analyser l'en-tête
     * "content-disposition", et de vérifier si le paramètre "filename" y est
     * présent. Si oui, alors le champ traité est de type File et la méthode
     * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
     * la méthode retourne null.
     */
    private static String getNomFichier( Part part ) {
        /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est présent, alors renvoi de sa valeur,
                 * c'est-à-dire du nom de fichier sans guillemets.
                 */
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }

    /*
     * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
     * sur le disque, dans le répertoire donné et avec le nom donné.
     */
    private void ecrireFichier( InputStream contenu, String nomFichier, String chemin ) throws Exception {
        /* Prépare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( contenu, TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
                    TAILLE_TAMPON );

            /*
             * Lit le fichier reçu et écrit son contenu dans un fichier sur le
             * disque.
             */
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur = 0;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
