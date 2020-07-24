package com.person.service;

import java.util.List;

import com.person.service.bean.Mariage;
import com.person.service.bean.MariageListBean;

public interface ServiceMariage {

	String addMariage(Mariage mariage);

	List<MariageListBean> getListeMariage();


}
