package com.person.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Data.DAO.UserDAO;
import com.person.entity.Commune;
import com.person.entity.District;
import com.person.entity.User;
import com.person.service.ServiceUser;
import com.person.service.bean.UserBean;

@Service
public class ServiceUserImpl implements ServiceUser{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public void addUser(UserBean userBean) {
		User userEntity = new User();		
		userEntity.setUsername(userBean.getUsername());
		userEntity.setPassword(userBean.getPassword());
			Optional<Commune> communeOpt = this.userDAO.findCommuneById(userBean.getCommuneId());
		userEntity.setCommuneZone(communeOpt.get());
			Optional<District> districtOpt = this.userDAO.findDistrictById(communeOpt.get().getDistrict().getId());
		userEntity.setDistrictZone(districtOpt.get());
		userEntity.setDepute(userBean.isDepute());
		userEntity.setMaire(userBean.isMaire());
		userDAO.save(userEntity);
		
	}

}
