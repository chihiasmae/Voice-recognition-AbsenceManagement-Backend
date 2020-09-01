package org.sid.dao;

import org.sid.entities.ApUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<ApUser,Long> {
    public ApUser findByUsername(String username);
  
    
}
