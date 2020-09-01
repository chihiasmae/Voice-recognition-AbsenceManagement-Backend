package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Student  {
	public Student() {
		super();
	}
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
	private String nom;
	private String prenom;
	private String tele;
	private String CNE;
	
	
	@ManyToOne
	private Filiere filiere ;
	
	
	@OneToMany(mappedBy = "student")
	 @JsonIgnore
	private List<Absence> absences= new ArrayList();
	
	
	//@JoinTable(name="absence",
//	joinColumns = @JoinColumn (name="idStudent"),
	//inverseJoinColumns = @JoinColumn(name="idCours"))

	

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	@JsonIgnore
	public List<Absence> getAbsencs() {
		return absences;
	}
	public void setAbsence(List<Absence> absences) {
		this.absences = absences;
	}
public Student( Long idStudent,String nom, String prenom, String tele, Filiere filiere, List<Absence> cours,String CNE) {
		super();
		this.idStudent=idStudent;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.filiere = filiere;
		this.absences = cours;
		this.CNE=CNE;
	}
public String getCNE() {
	return CNE;
}
public void setCNE(String cNE) {
	CNE = cNE;
}
public Long getIdStudent() {
	return idStudent;
}
public void setIdStudent(Long idStudent) {
	this.idStudent = idStudent;
}
public List<Absence> getAbsences() {
	return absences;
}
public void setAbsences(List<Absence> absences) {
	this.absences = absences;
}


}
