package org.sid.services;

import java.util.Date;
import java.util.List;
import org.sid.entities.Absence;
import org.sid.entities.ApUser;
import org.sid.entities.Student;
import org.sid.metier.IMetier;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AbsenceRestService {
	@Autowired	
	private IMetier metier;
	private AccountService accountService;
	//@RequestMapping(value="/absences",method=RequestMethod.GET)
    //public List<Absence> listAbsences(){
		//return metier.getListAbsences();
	//}
	@RequestMapping(value="/absences",method=RequestMethod.GET)
	public List<Absence> listStudentAbs(){
		return metier.getAllAbsences();
	}
	@RequestMapping(value="/betwenn/{startTime}/{endDate}",method=RequestMethod.GET)
	public List<Absence> findByDateBetween(@PathVariable Date startTime, @PathVariable Date endDate){
		System.out.println( "time"+startTime+endDate);
		List<Absence> list=metier.findByDateBetween(startTime,endDate);
		System.out.println("list"+list);
		return metier.findByDateBetween(startTime,endDate);
	}
	@RequestMapping(value="/absences",method=RequestMethod.POST)
	public Absence saveStudent(@RequestBody Absence s) {
		System.out.println( "a"+s.getDate());
		return metier.saveAbsence(s);
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<ApUser> listUsers(){
		return accountService.getAllUsers();
	}
	@RequestMapping(value="/absenceByStudent/{name}",method=RequestMethod.GET)
	public List<Object> getAbsenceByStudent(@PathVariable String name){
		return metier.getAbsencesByStudent(name);
	}
	
	
	@RequestMapping(value="/deleteAbs/{id}",method=RequestMethod.DELETE)
	public void deleteAbsence(@PathVariable Long id){
		System.out.println("delet"+id);
		 metier.deleteAbsence(id);
	}
	
	@RequestMapping(value="/updateEtat/{id}",method=RequestMethod.PUT)
	public void updateEtat(@PathVariable Long id,@RequestBody String etat){
		System.out.println(etat);
		metier.updateEtat(id, etat);
		
	}
}
