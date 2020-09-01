package org.sid.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javassist.expr.NewArray;


@Entity

public class Module {
	 public Module() {
		super();
	}
	public Module(Long idModule, String libelle) {
		super();
		this.idModule = idModule;
		this.libelle = libelle;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idModule;
	 public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	private String libelle;
	 
	
	
}
