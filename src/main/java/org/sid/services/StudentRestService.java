package org.sid.services;

import java.util.List;

import org.sid.entities.Student;
import org.sid.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class StudentRestService {
@Autowired	
private IMetier metier;
@RequestMapping(value="/students",method=RequestMethod.POST)
public Student saveStudent(@RequestBody Student s) {
	System.out.println("s="+s);
	return metier.saveStudent(s);
}
@RequestMapping(value="/studentF/{nom}",method=RequestMethod.GET)
public List<Object> listStudents(@PathVariable String nom){
	return metier.getListStudentsByFiliere(nom);
}

@RequestMapping(value="/studentAbsents/{nom}",method=RequestMethod.GET)
public List<Object> listStudentAbsByFiliere(@PathVariable String nom){
	return metier.getListAbsencesByFiliere(nom);
}
@RequestMapping(value="/allStudents",method=RequestMethod.GET)
public List<Student> getListStudents(){
	return metier.getListStudents();
}

@RequestMapping(value="/studentBynom/{nom}",method=RequestMethod.GET)
public Student getStudentBynom(@PathVariable String nom){
	return metier.getStudentByNom(nom);
}

@RequestMapping(value="/absents/{list}",method=RequestMethod.GET)
public List<Student> getListStudentsAbsents(@PathVariable List<String> list){
	return metier.findNot(list);
}

@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.DELETE)
public void deleteStudent(@PathVariable Long id){
	System.out.println("delet"+id);
	 metier.deleteStudent(id);
}
}
