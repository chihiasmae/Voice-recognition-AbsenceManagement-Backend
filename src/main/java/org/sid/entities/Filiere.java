package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Filiere {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idFiliere;
private String name;

@OneToMany(mappedBy = "filiere")
private Collection<Student> students;



/*@ManyToMany
@JoinTable(name="cours",
joinColumns = @JoinColumn (name="idFiliere"),
inverseJoinColumns = @JoinColumn(name="idJour"))
private List<Jour> jours= new ArrayList();*/

@OneToMany(mappedBy = "filiere")
@JsonIgnore
private List<Cours> cours= new ArrayList();

public Long getIdFiliere() {
	return idFiliere;
}
public void setIdFiliere(Long idFiliere) {
	this.idFiliere = idFiliere;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@JsonIgnore
public Collection<Student> getStudents() {
	return students;
}
public Filiere() {
	super();
}
public void setStudents(Collection<Student> students) {
	this.students = students;
}


}
