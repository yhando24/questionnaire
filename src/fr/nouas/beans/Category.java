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
	private String couleur;

}
