package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.service.ServiceMariage;
import com.person.service.bean.Mariage;
import com.person.service.bean.MariageListBean;

@RestController
@RequestMapping(path = "/mariage")
@CrossOrigin(origins = "*")
public class ControllerMariage {
	
	@Autowired
	ServiceMariage serviceMariage;
	
	@PostMapping(path = "/ajoutMariage")
	private String addMariage(@Validated @RequestBody Mariage mariage) {
			this.serviceMariage.addMariage(mariage);
		return mariage.getResultat();
	}
	
	@GetMapping(path = "/listMariage")
	private List<MariageListBean> getListeMariage() {
		List<MariageListBean> listeMariage = this.serviceMariage.getListeMariage();
		return listeMariage;
	}
}
