package com.person.service.bean;


public class District extends com.person.service.bean.Region{
	
	public Long idDistrict;
	
	public int codeDistrict;
	
	public String nameDistrict;	

	//private List<com.person.service.bean.Region> Region;;

	public Long getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Long idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getNameDistrict() {
		return nameDistrict;
	}

	public void setNameDistrict(String nameDistrict) {
		this.nameDistrict = nameDistrict;
	}

	public int getCodeDistrict() {
		return codeDistrict;
	}

	public void setCodeDistrict(int codeDistrict) {
		this.codeDistrict = codeDistrict;
	}

}
