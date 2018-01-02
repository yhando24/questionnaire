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
public class Questionnaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=150, nullable=false)
	private String name;

<<<<<<< HEAD
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST,mappedBy="questionnaire")
	private List <Question> questions;
=======
	@OneToMany(mappedBy="questionnaire")
	private List<Question> questions;
>>>>>>> 0ba90beff02ed30e4fe03c010e4adf2215cb1f6e
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Category category;

	public Questionnaire () {};
	
	public Questionnaire(int id, String name, List<Question> questions, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.questions = questions;
		this.category = category;
	}
	
	public Questionnaire(String nom, List<Question> questions, Category category) {
		super();
		this.name = name;
		this.questions = questions;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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
