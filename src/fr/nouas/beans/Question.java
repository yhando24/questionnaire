package fr.nouas.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Question {

	// bonjour
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=150, nullable=false)
	private String question;
	
	@Column(nullable=false)
	private List <String> reponses;

	public Question () {}
	public Question(String question, List<String> reponse) {		
		super();
		this.question = question;
		this.reponses = reponse;
	}
	
	public Question(int id, String question, List<String> reponse) {
			this.id = id;
			this.question = question;
			this.reponses = reponse;
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
	public List<String> getReponses() {
		return reponses;
	}
	public void setReponses(List<String> reponse) {
		this.reponses = reponse;
	}
	public void addReponse(String reponse) {
		this.reponses.add(reponse);
	}
}


