package org.sid.services;

import java.util.List;

import org.sid.entities.Filiere;
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
public class FiliereRestService {
	@Autowired	
	private IMetier metier;
	@RequestMapping(value="/filieres",method=RequestMethod.GET)
	public List<String> listStudents(){
		return metier.getFilieres();
	}
	@RequestMapping(value="/filieres",method=RequestMethod.POST)
	public Filiere saveStudent(@RequestBody Filiere f) {
		return metier.saveFilire(f);}
	
	@RequestMapping(value="/filiereId/{name}",method=RequestMethod.GET)
	public Long getFiliereId(@PathVariable String name){
		return metier.getFiliereByName(name);
	}
}
