package org.sid;

import java.util.List;
import java.util.stream.Stream;

import org.sid.dao.AbsenceRepository;
import org.sid.dao.CoursRepository;
import org.sid.dao.FiliereRepository;
import org.sid.dao.JourRepository;
import org.sid.dao.StudentRepository;
import org.sid.entities.Absence;

import org.sid.entities.Cours;
import org.sid.entities.Filiere;
import org.sid.entities.Role;
import org.sid.entities.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.aspectj.lang.annotation.Before;

import org.sid.entities.Student;
import org.sid.metier.IMetier;
import org.sid.service.AccountService;
import org.sid.services.JoursRestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class AbsenceApplication {
	
	
	
	
	public static void main(String[] args) {
		 
		ApplicationContext ctx=SpringApplication.run(AbsenceApplication.class,args);
		IMetier studentMetier=((BeanFactory) ctx).getBean(IMetier.class);
		//studentMetier.saveStudent(new Student());
		//List<Absence>list=studentMetier.getListAbsences();
	
		
	//for (Absence student : list) {
		// System.out.println(student.getIdAbsence());
	//}
		
	}
	/*@Bean
	    CommandLineRunner start(AccountService accountService){
	        return args->{
	            accountService.save(new Role(null,"ETUDIANT"));
	            accountService.save(new Role(null,"ADMIN"));
	            accountService.save(new Role(null,"RECORD"));
	            accountService.save(new Role(null,"ENSEIGNANT"));
	            
	            Stream.of("Mhemdi","Oumehdi").forEach(un->{
	                accountService.saveUser(un,"12@34","12@34");
	            });
	            accountService.addRoleToUser("Mhemdi","ADMIN");
	           
	            accountService.addRoleToUser("Oumehdi","ENSEIGNANT");
	           
	            
	        };
	    }*/
	  @Bean
	    BCryptPasswordEncoder getBCPE(){
	        return new BCryptPasswordEncoder();
	    }
}
