package org.sid.dao;

import org.sid.entities.Jour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface JourRepository extends JpaRepository<Jour, Long>{

}
