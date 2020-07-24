package com.person.service.bean;

public class Commune extends District{

	public Long idCommune;
	
	public String nameCommune;
	
	private Integer codeCommune;
	
	private Commune commune;
	
	private Commune communeNaissance;
		
	
	public Long getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(Long idCommune) {
		this.idCommune = idCommune;
	}

	public String getNameCommune() {
		return nameCommune;
	}

	public void setNameCommune(String nameCommune) {
		this.nameCommune = nameCommune;
	}

	public int getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(Integer codeCommune) {
		this.codeCommune = codeCommune;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}
}
