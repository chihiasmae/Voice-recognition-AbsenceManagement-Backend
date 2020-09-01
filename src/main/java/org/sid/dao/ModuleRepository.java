package org.sid.dao;


import java.util.List;

import org.sid.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface ModuleRepository extends JpaRepository <Module , Long>{

	 @Query(" SELECT i.libelle FROM Module i")
	  public List<String> getAllModules();
	 
	 
	 @Query(" SELECT i.idModule FROM Module i where i.libelle=(:nameM)")
	  public Long  getModuleByName(@Param("nameM") String nameM );
}
