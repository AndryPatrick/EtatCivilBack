package com.person.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Data.DAO.DivorceDAO;
import com.person.entity.Mariage;
import com.person.entity.Naissance;
import com.person.service.ServiceDivorce;
import com.person.service.bean.Divorce;

@Service
public class ServiceDivorceImpl implements ServiceDivorce{
	
	@Autowired
	DivorceDAO divorceDAO;
		
	@Override
	public void addDivorce(Divorce divorce) {
			
			com.person.entity.Divorce divorceEntity = new com.person.entity.Divorce();
				Optional<Mariage> mariageOpt = this.divorceDAO.getDivorceById(divorce.getIdMariage());
				if (mariageOpt.isPresent()) {
					//this.updatePersonne(mariageOpt.get().getPersonMale(), mariageOpt.get().getPersonFemelle());
					this.divorceDAO.updateMariage(divorce.getIdMariage());
					divorceEntity.setMariage(mariageOpt.get());
					divorceEntity.setDataDivorce(LocalDateTime.now());
					
					this.divorceDAO.save(divorceEntity);					
					
					this.divorceDAO.updatSituation(mariageOpt.get().getPersonFemelle().getId());
					this.divorceDAO.updatSituation(mariageOpt.get().getPersonMale().getId());
					
					this.divorceDAO.updatSituationForDivorce(mariageOpt.get().getPersonFemelle().getId());
					this.divorceDAO.updatSituationForDivorce(mariageOpt.get().getPersonMale().getId());
					
					divorce.setResultat("Votre vous êtes divorcé correctement");
				}
				else {
					
					divorce.setResultat("Votre divorce n'est pas exécuté correctement");
					
				}
	}
	
	public void updatePersonne(Naissance idPersonneMale, Naissance idPersonneFemelle) {
		this.divorceDAO.updatePersonne(idPersonneMale, idPersonneFemelle);
	}

}
