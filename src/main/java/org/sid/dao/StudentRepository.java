package org.sid.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sid.entities.Filiere;
import org.sid.entities.OrderResponses;
import org.sid.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
@Transactional
public interface StudentRepository  extends JpaRepository <Student , Long>{
	
	 
	 @Query(" SELECT i FROM Student i where i.filiere.name=(:nameF)")
	  public List<Object>  getStudentByFiliere(@Param("nameF") String nameF );
	 
	
	 
	 @Query(" SELECT i FROM Student i")
	  public List<Student>  getAllStudents();
	 
	// @Query(" SELECT i FROM Student i where i.idCours=1 and i.name=  ")
	// public List<Student> getStudentByName();
	 
	 @RestResource(path = "/studentByName")
	   public Student findByNom(@Param("mc") String mc);
	 
       @Query("select i from Student i where i.nom NOT IN (:noms)")
         public  List<Student> findByNomsNot(@Param("noms")List<String> noms);
      
	 
	
	 
	// String hql = "select a.nom from Students a, Cours b, Absence ab where ab.idStudent=a.idStudent and ab.idCours=b.idCours ";
	// @Query(" SELECT i,b FROM Student i,Cours b join b.students e where i.filiere.idFiliere = 1 and b.idCours = 1 ")
    // @Query(" SELECT i FROM Student i  where i.filiere.idFiliere = 1 ")
	 
	// @Query(" SELECT i,b FROM Student i,Cours b join i.cours e  ")
	
	 
	 
	 
	 
	 
	// @Query(" SELECT i,b FROM Filiere i,Jour b join b.filieres where b.idJour=1")
	
	 
}
