package org.sid.entities;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponses{
	private String nom;
	private Long idCours;
public OrderResponses() {
		super();
	}
public OrderResponses(String nom, Long idCours) {
		super();
		this.nom = nom;
		this.idCours = idCours;
	}




}
