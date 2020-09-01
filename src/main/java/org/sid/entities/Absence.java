

package org.sid.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class Absence {
	
	

	public Absence( Long idAbsence, Date date, Student student, Cours cours,String etat) {
		super();
		
		this.idAbsence = idAbsence;
		this.date = date;
		this.student = student;
		this.cours = cours;
		this.etat=etat;
		
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAbsence;
	private Date date;
	private  String etat;
	@ManyToOne
	private Student student;
	@ManyToOne 
	private Cours cours;
	
	
public Absence() {
		super();
	}

public Absence(Long idAbsence) {
		super();
		this.idAbsence = idAbsence;
	}



public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public Cours getCours() {
	return cours;
}

public void setCours(Cours cours) {
	this.cours = cours;
}

public Long getIdAbsence() {
	return idAbsence;
}

public void setIdAbsence(Long idAbsence) {
	this.idAbsence = idAbsence;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getEtat() {
	return etat;
}

public void setEtat(String etat) {
	this.etat = etat;
}	

}
