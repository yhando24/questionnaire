package fr.nouas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Reponse {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(length=150, nullable=false)
private String reponse;

@ManyToOne
private User user;

@Column(columnDefinition = "TINYINT", nullable=true)
@Type(type = "org.hibernate.type.NumericBooleanType")
private boolean correct;


public Reponse(int id, String reponse, User user, Question question, int version) {
	super();
	this.id = id;
	this.reponse = reponse;
	this.user = user;
	this.question = question;
	this.version = version;
}

public Reponse(String reponse, boolean correct, Question question) {
	super();
	this.reponse = reponse;
	this.correct = correct;

	this.question = question;

}

@ManyToOne
private Question question;

@Column(length=20, nullable=false)
private int version = 0;

public Reponse() {};

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



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
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
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}


}

