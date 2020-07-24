package com.person.controller;
import java.io.IOException;
import java.util.List;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.person.service.ServiceNaissance;
import com.person.service.bean.Naissance;

import fr.opensagres.xdocreport.core.XDocReportException;

@RestController
@RequestMapping(path="/naissance")
@CrossOrigin(origins = "*")
public class ControllerNaissance {
	
	@Autowired
	ServiceNaissance serviceNaissance;
	
  	@PostMapping(path = "/ajoutNaissance")
	public String ajoutNaissance(@Validated @RequestBody Naissance naissance) {
  			this.serviceNaissance.addNaissance(naissance);
  		return "naissance ajouté avec succès";
	} 
  	
  	@GetMapping(path="/genererPdf/{identity}") 
  	public Naissance genererCopie (@PathVariable (name="identity") long identity) throws XDocReportException, IOException, Docx4JException{
  			Naissance naissanceById = this.serviceNaissance.genererCopie(identity);
  		return naissanceById;
  	}
  	
}
