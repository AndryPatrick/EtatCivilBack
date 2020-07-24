package com.person.service.bean;

import com.person.entity.Commune;

public class MairieBean {
	
	private String nomMaire;
	
	private String prenomMaire;
	
	private Long idCommune;

	public String getNomMaire() {
		return nomMaire;
	}

	public void setNomMaire(String nomMaire) {
		this.nomMaire = nomMaire;
	}

	public String getPrenomMaire() {
		return prenomMaire;
	}

	public void setPrenomMaire(String prenomMaire) {
		this.prenomMaire = prenomMaire;
	}

	public Long getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(Long idCommune) {
		this.idCommune = idCommune;
	}
	
}
