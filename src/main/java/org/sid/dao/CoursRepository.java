 package org.sid.dao;

import java.util.List;

import org.sid.entities.Cours;
import org.sid.entities.Module;
import org.sid.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CoursRepository extends JpaRepository <Cours , Long> {
	 @RestResource(path = "/allCours")
	    public List<Cours> findAll();
	 
	 @Query(" SELECT i.module, i.jour,i.duree FROM Cours i where i.jour.idJour=(:id) and i.filiere.idFiliere=(:idF)")
	  public List<Object> getModules(@Param("id")Long id,@Param("idF")Long idF);
	 
	 @Query(" SELECT i.idCours FROM Cours i where i.jour.nomJour=(:nameJ) and i.filiere.name=(:nameF) and i.duree.id=(:idD)   ")
	  public Object getCoursByParam(@Param("nameJ")String nameJ,@Param("nameF")String nameF,@Param("idD")Long idD);
	
	
}
