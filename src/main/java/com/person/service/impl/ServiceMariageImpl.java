package com.person.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Data.DAO.LocalisationDAO;
import com.person.Data.DAO.MariageDAO;
import com.person.entity.Commune;
import com.person.entity.Naissance;
import com.person.entity.Person;
import com.person.service.ServiceMariage;
import com.person.service.bean.Mariage;
import com.person.service.bean.MariageListBean;

@Service
public class ServiceMariageImpl implements ServiceMariage{
	
	@Autowired
	MariageDAO mariageDAO;
	
	@Autowired
	LocalisationDAO localisationDAO;
		
	@Override
	public String addMariage(Mariage mariage) {
			String resultat = null;
			com.person.entity.Mariage mariageEntity = new com.person.entity.Mariage();
			
				Optional<Naissance> personMaleOpt = this.mariageDAO.getPersonMaleByIdentity(mariage.getIdentityMale());
			if (!personMaleOpt.isPresent()) {
				mariageEntity.setPersonMale(null);
			}else {
				mariageEntity.setPersonMale(personMaleOpt.get());
			}
			
				Optional<Naissance> personFemelleOpt = this.mariageDAO.getPersonFemelleByIdentity(mariage.getIdentityFemelle());
			if (!personFemelleOpt.isPresent()) {
				mariageEntity.setPersonFemelle(null);
			}
			else if(personFemelleOpt.get() != null) {
				mariageEntity.setPersonFemelle(personFemelleOpt.get());
			}
			
			mariageEntity.setDateMariage(LocalDateTime.now());
				Optional<Commune> communeMariage = this.localisationDAO.findCommuneById(mariage.getIdCommuneMariage());
			mariageEntity.setLieuMariagee(communeMariage.get());
			mariageEntity.setValide(true);
			
			if ((!personMaleOpt.isPresent()) || (!personFemelleOpt.isPresent())) {
				mariage.setResultat("les personnes de même sexe ne peuvent pas être marié");
			}
			else if (personFemelleOpt.get().isMariee() || personMaleOpt.get().isMariee()) {
				
				if (personFemelleOpt.get().isMariee() && personMaleOpt.get().isMariee()) {
					mariage.setResultat("Impossible d'établir le mariage \n ces deux personnes sont déjà mariées dans la commune de "+
				personFemelleOpt.get().getPlaceOfBirth().getNameCommune());
				}
				else if (personFemelleOpt.get().isMariee()) {
					mariage.setResultat("Impossible d'établir le mariage \n"+personFemelleOpt.get().getName()+" "+
										personFemelleOpt.get().getFamilyName()+" est déja marié dans la commune "+ 
							personFemelleOpt.get().getPlaceOfBirth().getNameCommune());
				}
				else {
					mariage.setResultat("Impossible d'établir le mariage \n"+personMaleOpt.get().getName()+" "+
										personMaleOpt.get().getFamilyName()+" est déja marié dans la commune "+
										personMaleOpt.get().getPlaceOfBirth().getNameCommune());
				}
			}
			else {
				
				Naissance naisM = this.mariageDAO.updatSituationMale(personMaleOpt.get().getId());
				Naissance naisF = this.mariageDAO.updatSituationFemelle(personFemelleOpt.get().getId());			    
				
				
				this.mariageDAO.save(mariageEntity);
				mariage.setResultat("vous êtes marié avec succès");
			}
			
		return resultat;
	}

	@Override
	public List<MariageListBean> getListeMariage() {
			List<MariageListBean> mariageListBean = new ArrayList<MariageListBean>();
			List<com.person.entity.Mariage> listeMariageEntity  = this.mariageDAO.getListMariage();
				for (com.person.entity.Mariage mariageEntity : listeMariageEntity) {
					MariageListBean mariageBean = new MariageListBean();
					mariageBean.setIdMariage(mariageEntity.getId());
						final Optional<Naissance> personMaleOpt = this.mariageDAO.getPersonMaleById(mariageEntity.getPersonMale().getId());
					mariageBean.setNomHomme(personMaleOpt.get().getName());
					mariageBean.setPrenomHomme(personMaleOpt.get().getFamilyName());
					mariageBean.setIdentityHommne(personMaleOpt.get().getIdentity());
						final Optional<Naissance> personFemmeOpt = this.mariageDAO.getPersonFemelleById(mariageEntity.getPersonFemelle().getId());
					mariageBean.setNomFemme(personFemmeOpt.get().getName());
					mariageBean.setPrenomFemme(personFemmeOpt.get().getFamilyName());
					mariageBean.setIdentityFemme(personFemmeOpt.get().getIdentity());
						final Optional<Commune> communOpt = this.localisationDAO.findCommuneById(mariageEntity.getLieuMariage().getId());
					mariageBean.setLieuMariage(communOpt.get().getNameCommune());
					LocalDate date = this.mariageDAO.getDateMariage();
					mariageBean.setDateMariage(date);
					mariageListBean.add(mariageBean);
				}
		return mariageListBean;
	}

}
