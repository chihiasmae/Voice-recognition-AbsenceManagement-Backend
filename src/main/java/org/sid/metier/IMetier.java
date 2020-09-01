package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.entities.Absence;
import org.sid.entities.Cours;
import org.sid.entities.Filiere;
import org.sid.entities.Module;
import org.sid.entities.OrderResponses;
import org.sid.entities.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface IMetier {
public List<Student> getListStudents();
public List<Object> getListStudentsByFiliere(String nameF);
public Student saveStudent(Student c);
public List<Cours> getListCours();
public List<String> getFilieres();
public List<Object> getListAbsencesByFiliere(String nameF);
public List<Absence> getAllAbsences();
public Student getStudentByNom(String nom);
public Absence saveAbsence(Absence a);
public Filiere saveFilire(Filiere f);
public List<Student> findNot(List<String> list);
public List<Object> getCoursModules(Long id,Long idF);
public Object getCoursByParam(String nameJ,String nameF,Long idD);
public List<Absence> findByDateBetween(Date startTime,Date endTime);
public void deleteAbsence(Long idAbsence);
public void deleteStudent(Long idStudent);
public List<Object> getAbsencesByStudent(String name);
public void updateEtat(Long id,String name);
public List<String> getAllModules();
public Cours saveCours(Cours cours);
public Long getFiliereByName(String name);
public Long getModuleByName(String name);


}
