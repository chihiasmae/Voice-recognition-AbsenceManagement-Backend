
package org.sid.dao;

import java.util.Date;
import java.util.List;

import org.sid.entities.Absence;
import org.sid.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
@CrossOrigin("*")

@RepositoryRestResource
public interface AbsenceRepository extends JpaRepository <Absence , Long> {
	 @RestResource(path = "/absences")
	 public List<Absence> findAll();
	 
	 @Query(" SELECT i FROM Absence i where i.date >:startDate AND i.date <:endDate ")
	 public List<Absence> findByDateBetween(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
	 
	 @Query(" SELECT i FROM Absence i where i.cours.filiere.name=(:nameF)  ")
	 public List<Object> getListAbsentByFiliere(@Param("nameF") String nameF);
	 
	 @Query(" DELETE Absence i where i.idAbsence=(:id)  ")
	 public Absence delete(@Param("id") Long id);
	 
	 @Query(" SELECT i FROM Absence i where i.student.nom=(:nameS)  ")
	 public List<Object> getListAbsentByStudent(@Param("nameS") String names);

	 @Modifying
	 @Transactional
	 @Query(" UPDATE  Absence i SET i.etat =(:etat)  where i.idAbsence=(:id)  ")
	 public void update(@Param("id") Long id,@Param("etat") String etat);

			 
			
	
}
