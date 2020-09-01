package org.sid.services;

import java.util.List;


import org.sid.entities.Cours;
import org.sid.entities.Module;
import org.sid.entities.Student;
import org.sid.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class CoursRestService {
	@Autowired	
	private IMetier metier;
	
	@RequestMapping(value="/cours",method=RequestMethod.GET)
	public List<Cours> listStudents(){
		return metier.getListCours();
	}
	@RequestMapping(value="/modules",method=RequestMethod.GET)
	public List<String> listModules(){
		return metier.getAllModules();
	}
	@RequestMapping(value="/Coursmodules/{id}/{idF}",method=RequestMethod.GET)
	public List<Object> listModules(@PathVariable Long id,@PathVariable Long idF){
		return metier.getCoursModules(id,idF);	
	}
	@RequestMapping(value="/coursparparm/{nameJ}/{nameF}/{idD}",method=RequestMethod.GET)
	public Object getCoursByParam(@PathVariable String nameJ,@PathVariable String nameF,@PathVariable Long idD){
		System.out.println("id found"+nameJ+nameF+idD);
		return metier.getCoursByParam(nameJ, nameF, idD);	
	}
	@RequestMapping(value="/saveCours",method=RequestMethod.POST)
	public Cours saveStudent(@RequestBody Cours c) {
		System.out.println("s="+c);
		return metier.saveCours(c);
	}
	@RequestMapping(value="/ModuleId/{name}",method=RequestMethod.GET)
	public Long getModuleId(@PathVariable String name){
		return metier.getModuleByName(name);
	}
	  
}
