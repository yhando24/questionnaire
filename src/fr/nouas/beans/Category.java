package fr.nouas.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=90, nullable=false, unique=true)
	private String name;
	
	@OneToMany(mappedBy="category")
	@Column(length=90, nullable=true)
	private List <Questionnaire> questionnaires;
	
	@Column(length=90, nullable=true, unique=true)
	private String color;

	@Column(length=90, nullable=true)
	private String description;
	
	public Category () {};
	
	public Category(int id, String name, List<Questionnaire> questionnaires, String color, String description) {
		super();
		this.id = id;
		this.name = name;
		this.questionnaires = questionnaires;
		this.color = color;
		this.description = description;
	}
	
	public Category(String name, List<Questionnaire> questionnaires, String color, String description) {
		super();
		this.name = name;
		this.questionnaires = questionnaires;
		this.color = color;
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

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	public void addQuestionnaire(Questionnaire questionnaire) {
		this.questionnaires.add(questionnaire);
	}
	
	public String getColor() {
		return color;
	}

	public void setCoolor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
