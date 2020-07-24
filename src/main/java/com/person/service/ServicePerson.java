package com.person.service;

import java.util.List;

import com.person.service.bean.ExtractionCinBean;
import com.person.service.bean.LastIdentityPersonDataBean;
import com.person.service.bean.Person;
import com.person.service.bean.PersonSaveBean;

public interface ServicePerson {

	List<Person> getAllPerson();
	
	List<Person> getPersonById(Long identityNumber);

	List<Person> deletePerson(Long idPerson);

	List<Person> addPersonn(PersonSaveBean person);

	LastIdentityPersonDataBean getLastIdentityPerson();

	List<ExtractionCinBean> extractCIN(Long identityNumber);

}
