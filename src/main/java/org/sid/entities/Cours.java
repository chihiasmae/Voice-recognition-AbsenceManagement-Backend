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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Cours {
		public Cours(Long idCours, DateDebutFin duree, Jour jour, Filiere filiere, Module module, List<Absence> absences) {
		super();
		this.idCours = idCours;
		this.duree = duree;
		this.jour = jour;
		this.filiere = filiere;
		this.module = module;
		this.absences = absences;
	}





		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idCours;
	 @ManyToOne
	 private DateDebutFin duree;
	 @ManyToOne
 	 private Jour jour;
	 @ManyToOne 
	 private Filiere filiere;
	 @ManyToOne 
	 private Module module;
	 
	// @ManyToMany
	// @JoinTable(name="absence",
	 
	// joinColumns = @JoinColumn (name="idCours"),
	// inverseJoinColumns = @JoinColumn(name="idStudent"))
	 @OneToMany(mappedBy = "cours")
	 @JsonIgnore
	 private List<Absence> absences;
	
	
	 public Cours() {
		super();
	}


	


	public DateDebutFin getDuree() {
		return duree;
	}





	public void setDuree(DateDebutFin duree) {
		this.duree = duree;
	}





	public Module getModule() {
		return module;
	}





	public void setModule(Module module) {
		this.module = module;
	}





	public List<Absence> getAbsences() {
		return absences;
	}





	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public Long getIdCours() {
		return idCours;
	}
   public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}
   public Jour getJour() {
		return jour;
	}
  public void setJour(Jour jour) {
		this.jour = jour;
	}
public Filiere getFiliere() {
		return filiere;
	}
public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	


}
