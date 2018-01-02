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


private boolean correct; 

@ManyToOne
private Question question;

public boolean isCorrect() {
	return correct;
}

public void setCorrect(boolean correct) {
	this.correct = correct;
}


}
