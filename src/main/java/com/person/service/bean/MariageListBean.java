package com.person.service.bean;

import java.time.LocalDate;

public class MariageListBean {

	private long idMariage;
	private String nomHomme;
	private String prenomHomme;
	private long identityHommne;
	private String nomFemme;
	private String prenomFemme;
	private long identityFemme;
	private String lieuMariage;
	private LocalDate dateMariage;

	public long getIdMariage() {
		return idMariage;
	}

	public void setIdMariage(long idMariage) {
		this.idMariage = idMariage;
	}

	public String getNomHomme() {
		return nomHomme;
	}

	public void setNomHomme(String nomHomme) {
		this.nomHomme = nomHomme;
	}

	public String getPrenomHomme() {
		return prenomHomme;
	}

	public void setPrenomHomme(String prenomHomme) {
		this.prenomHomme = prenomHomme;
	}

	public long getIdentityHommne() {
		return identityHommne;
	}

	public void setIdentityHommne(long identityHommne) {
		this.identityHommne = identityHommne;
	}

	public String getNomFemme() {
		return nomFemme;
	}

	public void setNomFemme(String nomFemme) {
		this.nomFemme = nomFemme;
	}

	public String getPrenomFemme() {
		return prenomFemme;
	}

	public void setPrenomFemme(String prenomFemme) {
		this.prenomFemme = prenomFemme;
	}

	public long getIdentityFemme() {
		return identityFemme;
	}

	public void setIdentityFemme(long identityFemme) {
		this.identityFemme = identityFemme;
	}

	public String getLieuMariage() {
		return lieuMariage;
	}

	public void setLieuMariage(String lieuMariage) {
		this.lieuMariage = lieuMariage;
	}

	public LocalDate getDateMariage() {
		return dateMariage;
	}

	public void setDateMariage(LocalDate dateMariage) {
		this.dateMariage = dateMariage;
	}

}
