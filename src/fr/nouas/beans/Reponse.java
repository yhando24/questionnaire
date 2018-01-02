package fr.nouas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reponse {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(length=150, nullable=false)
private String reponse;

//@ManyToOne
//private int idUser;

<<<<<<< HEAD

private boolean correct; 

@ManyToOne
private Question question;

public Reponse() {};
public Reponse(int id, String reponse, boolean correct, Question question) {
	super();
	this.id = id;
	this.reponse = reponse;
	this.correct = correct;
	this.question = question;
}

public Reponse(String reponse, boolean correct, Question question) {
	super();

	this.reponse = reponse;
	this.correct = correct;
	this.question = question;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getReponse() {
	return reponse;
}
public void setReponse(String reponse) {
	this.reponse = reponse;
}
public boolean isCorrect() {
	return correct;
}
public void setCorrect(boolean correct) {
	this.correct = correct;
}
public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}

=======
private boolean correct; 

@ManyToOne
private Question question;

public boolean isCorrect() {
	return correct;
}

public void setCorrect(boolean correct) {
	this.correct = correct;
}
>>>>>>> 0ba90beff02ed30e4fe03c010e4adf2215cb1f6e


}
