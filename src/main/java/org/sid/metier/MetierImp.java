package org.sid.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.dao.AbsenceRepository;
import org.sid.dao.CoursRepository;
import org.sid.dao.FiliereRepository;
import org.sid.dao.JourRepository;
import org.sid.dao.ModuleRepository;
import org.sid.dao.StudentRepository;
import org.sid.entities.Absence;
import org.sid.entities.Cours;
import org.sid.entities.Filiere;
import org.sid.entities.Module;
import org.sid.entities.OrderResponses;
import org.sid.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@Service
public class MetierImp implements IMetier{
	@Autowired
	private StudentRepository dao;
	@Autowired
	private CoursRepository daoC;
	@Autowired
	private FiliereRepository daoF;
	@Autowired
	private ModuleRepository daoM;

	@Autowired
	private JourRepository daoJ;

	@Autowired
	private AbsenceRepository daoA;
	@Autowired
	private CoursRepository daoCo;

	
	@Override
	public List<Student> getListStudents() {
		return dao.findAll();
		
	}


	@Override
	public Student saveStudent( Student c) {
		
		return dao.save(c);
	}


	@Override
	public List<Cours> getListCours() {
		
		return daoC.findAll();
	}


	@Override
	public List<String> getFilieres() {
		
		return daoF.getFilieres();
	}


	@Override
	public List<Object> getListAbsencesByFiliere(String nameF) {
		
		return daoA.getListAbsentByFiliere(nameF);
	}


	@Override
	public List<Object> getListStudentsByFiliere( String nameF) {
		return	dao.getStudentByFiliere(nameF);
		 
	}


	@Override
	public List<Absence> getAllAbsences() {
		
		return daoA.findAll();
	}


	@Override
	public Student getStudentByNom(String nom) {
		return dao.findByNom(nom);
	}


	@Override
	public Absence saveAbsence(Absence a) {
	System.out.println(a.getEtat());
	System.out.println("to string"+ a.toString());
	
		return daoA.save(a);
	}


	@Override
	public Filiere saveFilire(Filiere f) {
		return daoF.save(f);
	}


	@Override
	public List<Student> findNot(List<String> list) {
		return dao.findByNomsNot(list);
	}


	@Override
	public List<Object> getCoursModules(Long id,Long idF) {
		return daoCo.getModules(id,idF);
		
	}


	@Override
	public Object getCoursByParam(String nameJ, String nameF, Long idD) {
		
		return daoC.getCoursByParam(nameJ, nameF, idD);
	}


	@Override
	public List<Absence> findByDateBetween(Date startTime, Date endDate) {
		// TODO Auto-generated method stub
		System.out.println("start"+startTime.toLocaleString()+endDate.getDate());
		return daoA.findByDateBetween(startTime,endDate);
	}


	@Override
	public void deleteAbsence(Long idAbsence) {
		
		System.out.println(idAbsence);
		 daoA.deleteById(idAbsence);
	}


	@Override
	public List<Object> getAbsencesByStudent(String name) {
		return daoA.getListAbsentByStudent(name);
	}


	@Override
	public void updateEtat(Long id,String etat) {
		/*System.out.println(etat);
     Absence abs= daoA.getOne(id);
     System.out.println("1"+abs.getEtat());
     abs.setEtat(etat);
     System.out.println("2"+abs.getEtat());
     */
		
		daoA.update(id, etat);
	}


	@Override
	public void deleteStudent(Long idStudent) {
		 dao.deleteById(idStudent);
		
	}


	@Override
	public List<String> getAllModules() {
		return daoM.getAllModules();
	}


	@Override
	public Cours saveCours(Cours cours) {
		return daoC.save(cours);
	}


	@Override
	public Long getFiliereByName(String name) {
		return daoF.getFiliereByName(name);
	}


	@Override
	public Long getModuleByName(String name) {
		
		return daoM.getModuleByName(name);
	}


	
	

}
