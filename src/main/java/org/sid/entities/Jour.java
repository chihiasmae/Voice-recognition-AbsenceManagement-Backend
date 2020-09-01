package org.sid.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Jour {
	
	public Jour(Long idJour, String nomJour, List<Cours> cours) {
		super();
		this.idJour = idJour;
		this.nomJour = nomJour;
		this.cours = cours;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idJour;
private String nomJour;
/*@ManyToMany
@JoinTable(name="cours",
joinColumns = @JoinColumn (name="idJour"),
inverseJoinColumns = @JoinColumn(name="idFiliere"))
@JsonIgnore
private List<Filiere> filieres= new ArrayList();*/

@OneToMany(mappedBy = "jour")
@JsonIgnore
private List<Cours> cours= new ArrayList();

public List<Cours> getCours() {
	return cours;
}

public void setCours(List<Cours> cours) {
	this.cours = cours;
}



public Jour() {
	super();
}

public Long getIdJour() {
	return idJour;
}
public void setIdJour(Long idJour) {
	this.idJour = idJour;
}

public String getNomJour() {
	return nomJour;
}

public void setNomJour(String nomJour) {
	this.nomJour = nomJour;
}

}
