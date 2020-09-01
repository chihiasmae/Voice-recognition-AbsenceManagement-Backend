package org.sid.dao;

import java.util.List;

import org.sid.entities.Cours;
import org.sid.entities.Filiere;
import org.sid.entities.OrderResponses;
import org.sid.metier.AbsenceMetier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin("*")
@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
	
	 @RestResource(path = "/allFilieres")
	    public List<Filiere> findAll();
   @Query("select i.name from Filiere i")
    public List<String> getFilieres();
   
	 @Query(" SELECT i.idFiliere FROM Filiere i where i.name=(:nameF)")
	  public Long  getFiliereByName(@Param("nameF") String nameF );
	
	//public  List<Filiere> filieresParMc(@Param("x")Long mc);*/
	 
	/* @Query("SELECT new org.sid.entities.OrderResponse(c.name , p.nom) FROM Filiere c JOIN c.students p")
	    public List<OrderResponses> getJoinInformation();*/
	
	 
}
