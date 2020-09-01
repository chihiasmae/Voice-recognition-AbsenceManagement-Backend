package org.sid.metier;

import java.util.List;

import org.sid.dao.AbsenceRepository;
import org.sid.entities.Filiere;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class AbsenceImp implements AbsenceMetier {
private AbsenceRepository dao;
	
	public void setDao(AbsenceRepository dao) {
		this.dao = dao;
	}
	

}
