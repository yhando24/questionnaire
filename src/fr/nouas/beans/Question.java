package fr.nouas.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Question {

	// bonjour question
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=150, nullable=false)
	private String question;
	
<<<<<<< HEAD

	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST,mappedBy="question")
	private List <Reponse> reponses;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
=======
	@OneToMany(mappedBy="question")
	private List <Reponse> reponses;
	
	@ManyToOne
>>>>>>> 0ba90beff02ed30e4fe03c010e4adf2215cb1f6e
	private Questionnaire questionnaire;

	public Question () {}

	public Question(int id, String question, List<Reponse> reponses, Questionnaire questionnaire) {
		super();
		this.id = id;
		this.question = question;
		this.reponses = reponses;
		this.questionnaire = questionnaire;
	}
	
	public Question(String question, List<Reponse> reponses, Questionnaire questionnaire) {
		super();
		this.question = question;
		this.reponses = reponses;
		this.questionnaire = questionnaire;
	}




	public int getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponse) {
		this.reponses = reponse;
	}
	public void addReponse(Reponse reponse) {
		this.reponses.add(reponse);
	}
}


