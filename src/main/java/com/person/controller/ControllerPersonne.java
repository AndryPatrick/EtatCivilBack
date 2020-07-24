package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.repository.PersonRepository;
import com.person.service.ServiceNaissance;
import com.person.service.ServicePerson;
import com.person.service.bean.ExtractionCinBean;
import com.person.service.bean.LastIdentityPersonDataBean;
import com.person.service.bean.Naissance;
import com.person.service.bean.Person;
import com.person.service.bean.PersonSaveBean;

@RestController
@RequestMapping(path="/person")
@CrossOrigin(origins="*")
public class ControllerPersonne {
	
	@Autowired
	ServicePerson servicePerson;
	
	@Autowired
	PersonRepository personRepository;
		
	@GetMapping(path="/getAllPerson")
	public List<Person>  getAllPerson() {
		List<Person> persList = this.servicePerson.getAllPerson();
		return persList;
	}
	
	@PostMapping(path="/addPerson")
	public String savePerson (@Validated @RequestBody PersonSaveBean person) {
		this.servicePerson.addPersonn(person);
		return "valeur ajouté";
	}
	
	@GetMapping(path="/getPersonByCIN/{identityNumber}")
	public List<Person> getPersonById(@PathVariable(name="identityNumber") Long identityNumber) {
		List<Person> persList = this.servicePerson.getPersonById(identityNumber);
		return persList;
		
	}
	
	@DeleteMapping(path ="/deletePerson/{idPerson}")
	public Iterable<Person> detelePerson (@PathVariable(name="idPerson") Long idPerson) {
		Iterable<Person> personDelete = this.servicePerson.deletePerson(idPerson);
		return personDelete;	
	} 
	
	@GetMapping(path="/getLastIdentityNumber")
	public LastIdentityPersonDataBean getLastidentityNumber() {
		LastIdentityPersonDataBean lastIdentity = this.servicePerson.getLastIdentityPerson();
		
		return lastIdentity;
		
	}
	
	//Identifier lieu de naissance et sexe personne
	@GetMapping(path="/ExtractionCIN/{identityNumber}") 
	public List<ExtractionCinBean> extractCIN (@PathVariable(name="identityNumber") Long identityNumber) {
		List<ExtractionCinBean> extraction = this.servicePerson.extractCIN(identityNumber);
		return extraction;
	}
}
