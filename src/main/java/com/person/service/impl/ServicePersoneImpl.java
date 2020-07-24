package com.person.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.person.Data.DAO.LocalisationDAO;
import com.person.Data.DAO.PersonDAO;
import com.person.entity.Commune;
import com.person.repository.PersonRepository;
import com.person.service.ServicePerson;
import com.person.service.bean.ExtractionCinBean;
import com.person.service.bean.LastIdentityPersonDataBean;
import com.person.service.bean.Person;
import com.person.service.bean.PersonSaveBean;
import com.person.utils.DateUtils;
import com.person.utils.DatyAntsoratra;
import com.person.utils.FormatCIN;
import com.person.utils.LieuHelpers;

@Service
public class ServicePersoneImpl implements ServicePerson{

	@Autowired
	PersonDAO personDAO;
	
	@Autowired
	PersonRepository  personRepository;
	
	@Autowired
	LocalisationDAO localisationDAO;
	
	@Autowired
	ServicePerson servicePerson;
	
	@Override
	public List<Person> getAllPerson() {
		DateUtils utils = new DateUtils();
		FormatCIN format = new FormatCIN();
		DatyAntsoratra daty = new DatyAntsoratra();
		LieuHelpers lieuHelpers = new LieuHelpers();
		List<Person> ListPersBean = new ArrayList<>();
		List<com.person.entity.Person> ListPersEntities = this.personDAO.getListPerson();
			for (com.person.entity.Person persEntities : ListPersEntities) {
				Person persBean = new Person();
				//Commune communeEntity = this.personDAO.getCommuneById(persEntities.getPlaceOfBirth());
				persBean.setId(persEntities.getId());
				persBean.setName((persEntities.getName()).toUpperCase());
				persBean.setFamilyName(lieuHelpers.conversionLieu(persEntities.getFamilyName()));
				persBean.setDateOfBirth(utils.convertToDatabaseColumn(persEntities.getDateOfBirth()));
				int ans = this.personDAO.getAnneeById(persEntities.getId());
				int mois = this.personDAO.getMonthByID(persEntities.getId());
				int jour = this.personDAO.getDaysByID(persEntities.getId());
				persBean.setDateOfBirthWord(daty.conversion(ans, mois, jour));
				persBean.setPlaceOfBirth(lieuHelpers.conversionLieu(persEntities.getPlaceOfBirth().getNameCommune()));
				persBean.setIdentityNumberSt(format.ajoutEspace(String.valueOf(persEntities.getIdentityNumber())));
				persBean.setDateDelivry(utils.convertToDatabaseColumn( persEntities.getDateDelivry()));
				persBean.setPlaceDelivry(persEntities.getPlaceOfDelivry());
				persBean.setFatherName(persEntities.getFatherName());
				persBean.setMotherName(persEntities.getMotherName());
				persBean.setDateDuplicate(utils.convertToDatabaseColumn( persEntities.getDateDuplicate()));
				persBean.setPlaceOfDuplicate(persEntities.getPlaceOfDuplicate());
				persBean.setProfession(persEntities.getProfession());
				persBean.setSexeStr(format.detailSexe(persEntities.isSexe()));
				persBean.setSituationMatrimonialeStr(format.detailSituation(persEntities.isSituationMatrimoniale()));
				ListPersBean.add(persBean);
			}
		return ListPersBean;
	}

	//last code
	
	@Override
	public List<Person> addPersonn(PersonSaveBean personBean) {
		FormatCIN format = new FormatCIN(); 
		  com.person.entity.Person personEntity = new com.person.entity.Person();
		  personEntity.setName(personBean.getName());
		  personEntity.setFamilyName(personBean.getFamilyName());
		  personEntity.setDateOfBirth(personBean.getDateOfBirth());
		  personEntity.setPlaceOfDelivry(personBean.getPlaceOfDelivry());
		  		  
		  //get commune de délivrance de CIN
		  	//final Long commune = this.localisationDAO.getIdCommune(personBean.getIdCommune()); 
		  	final Optional<Commune> communeOpt = this.localisationDAO.findCommuneById(personBean.getIdCommune()); 
		  		Commune commune = new Commune();
			  personEntity.setPlaceOfBirth(communeOpt.get());
			 // personEntity.setSexe(personBean.getSexe()); 
		  
	    //get dernier cin générer
		  final Long lastIdenity = this.personDAO.getLastIdentityNumber(personBean.getIdCommune());
			  	if (lastIdenity == null) {
			  		personEntity.setIdentityNumber(format.genererCIN(communeOpt.get().getCode(),communeOpt.get().
			  				getNameCommune(),personBean.isSexe(),000000000000000L));
			  	}else {
			  		personEntity.setIdentityNumber(format.genererCIN(communeOpt.get().getCode(),communeOpt.get().
			  				getNameCommune(),personBean.isSexe(),lastIdenity));
			  	}	 
		  
		  //personEntity.setDateDelivry(utils.convertToEntityAttribute(personBean.getDateDelivry())); 
		  personEntity.setDateDelivry(personBean.getDateDelivry());
		  personEntity.setFatherName(personBean.getFatherName());
		  personEntity.setMotherName(personBean.getMotherName());
		  personEntity.setDateDuplicate(personBean.getDateDuplicate());
		  personEntity.setPlaceOfDuplicate(personBean.getPlaceOfDuplicate());
		  personEntity.setProfession(personBean.getProfession());
		  personEntity.setSexe(personBean.isSexe());
		  personEntity.setSituationMatrimoniale(personBean.isSituationMatrimoniale());
		  this.personRepository.save(personEntity);
		 
		  return servicePerson.getAllPerson();
	}

	@Override
	public List<Person> getPersonById(Long identityNumber) {
		DateUtils utils = new DateUtils();
		List<Person> ListPersBean = new ArrayList<>();
		List<com.person.entity.Person> ListPersEntities = this.personDAO.getListPerson(identityNumber);
			for (com.person.entity.Person persEntities : ListPersEntities) {
				Person persBean = new Person();
				//Commune commune = this.personDAO.getNomCommuneByPlaceOfBirth(persEntities.getPlaceOfBirth());
				persBean.setId(persEntities.getId());
				persBean.setName(persEntities.getName());
				persBean.setFamilyName(persEntities.getFamilyName());
				persBean.setDateOfBirth(utils.convertToDatabaseColumn(persEntities.getDateOfBirth()));
				persBean.setPlaceOfBirth(persEntities.getPlaceOfBirth().getNameCommune());
				persBean.setIdentityNumber(persEntities.getIdentityNumber());
				persBean.setDateDelivry(utils.convertToDatabaseColumn(persEntities.getDateDelivry()));
				persBean.setPlaceDelivry(persEntities.getPlaceOfDelivry());
				persBean.setFatherName(persEntities.getFatherName());
				persBean.setMotherName(persEntities.getMotherName());
				persBean.setDateDuplicate(utils.convertToDatabaseColumn(persEntities.getDateDuplicate()));
				persBean.setPlaceOfDuplicate(persEntities.getPlaceOfDuplicate());
				persBean.setProfession(persEntities.getProfession());
				ListPersBean.add(persBean);
			}
		return ListPersBean;
	}

	@Override
	public List<Person> deletePerson(Long idPerson) {
		this.personDAO.deletePerson(idPerson);
			this.personRepository.deleteById(idPerson);
		return servicePerson.getAllPerson();
	}

	//Extraire lieu de naissance et sexe personne
	@Override
	public List<ExtractionCinBean> extractCIN(Long identityNumber) {
		String sexe;
		List<ExtractionCinBean> listExtraction = new ArrayList<>();
		ExtractionCinBean extraction = new ExtractionCinBean();
		String cinSt = String.valueOf(identityNumber);
		String codeComSt = cinSt.substring(0, 6);
		String codeSexeSt = cinSt.substring(8);
		int codeCommune = Integer.valueOf(codeComSt).intValue();
		int codeSexe = Integer.valueOf(codeSexeSt).intValue();
		
		if (codeSexe == 1)
			sexe = "lehilahy";
		else {
			sexe = "vehivavy";
		}
		
			com.person.entity.Commune communeEntity = this.personDAO.getCommuneByCode(codeCommune);
			extraction.setPlaceDelivry(communeEntity.getNameCommune());
			extraction.setIdentity(identityNumber);
			extraction.setSexe(sexe);
			extraction.setValeur("ny mitondra ny karapanondro "+identityNumber+" dia "+sexe+ " nanao karatra tao "+communeEntity.getNameCommune()+
			" distrika "+communeEntity.getDistrict().getNameDistrict()+" region "+communeEntity.getDistrict().getRegion().getNameRegion());
			listExtraction.add(extraction);
		
		return listExtraction;
		
	}

	@Override
	public LastIdentityPersonDataBean getLastIdentityPerson() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Commune getIdCommuneById(Long idCommune) {
		Commune communeEntity = this.localisationDAO.getIdCommune(idCommune);
		com.person.service.bean.Commune communeBean = new com.person.service.bean.Commune();
		communeBean.setIdCommune(communeEntity.getId());
		return  communeEntity;
	}
}
