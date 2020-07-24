package com.person.service.bean;

public class Region extends Province{

	private Long idRegion;
	
	private String nameRegion;
	
	private int codeRegion;
	
	public Long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Long id) {
		this.idRegion = id;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}

	public int getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(int codeRegion) {
		this.codeRegion = codeRegion;
	}
	
}
