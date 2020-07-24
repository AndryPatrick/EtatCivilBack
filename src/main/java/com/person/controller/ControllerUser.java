package com.person.controller;

import javax.validation.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.service.ServiceUser;
import com.person.service.bean.UserBean;

@SpringBootApplication
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class ControllerUser {

	@Autowired
	ServiceUser serviceUser;
	
	@PostMapping(path="/addUser")
	public String addUser (@Validated @RequestBody UserBean user) {
			this.serviceUser.addUser(user);
		return "utilisateur ajouté avec succès";
	}
	
}
