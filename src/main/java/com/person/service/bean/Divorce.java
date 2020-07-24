package com.person.service.bean;

import java.time.LocalDate;

public class Divorce {
	private long id;
	private long idMariage;
	private String resultat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdMariage() {
		return idMariage;
	}

	public void setIdMariage(long idMariage) {
		this.idMariage = idMariage;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
