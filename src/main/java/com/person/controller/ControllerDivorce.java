package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.service.ServiceDivorce;
import com.person.service.bean.Divorce;

@RestController
@RequestMapping(path = "/divorce")
@CrossOrigin(origins = "*")
public class ControllerDivorce {
	
	@Autowired
	ServiceDivorce serviceDivorce;
	
	@PostMapping(path = "/ajoutDivorce")
	String addDivorce(@Validated @RequestBody Divorce divorce) {
			this.serviceDivorce.addDivorce(divorce);
		return divorce.getResultat();
	}
}
