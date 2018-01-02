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
public class Questionnaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=150, nullable=false)
	private String nom;

	@OneToMany(mappedBy="questionnaire")
	private List <Question> questions;
	
	@ManyToOne
	private Category category;

	public Questionnaire () {};
	
	public Questionnaire(int id, String nom, List<Question> questions, Category category) {
		super();
		this.id = id;
		this.nom = nom;
		this.questions = questions;
		this.category = category;
	}
	
	public Questionnaire(String nom, List<Question> questions, Category category) {
		super();
		this.nom = nom;
		this.questions = questions;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		questions = questions;
	}
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
