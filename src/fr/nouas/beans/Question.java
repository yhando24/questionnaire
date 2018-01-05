package fr.nouas.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(length=150, nullable=false)
	private String reponse;
	
	@OneToMany(mappedBy="question")
	private List <Reponse> reponses;
	
	@ManyToOne
	private Questionnaire questionnaire;
	
	@Column(length=20, nullable=false)
	private int version = 0;

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

	
	
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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


