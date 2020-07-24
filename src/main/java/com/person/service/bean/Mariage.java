package com.person.service.bean;

public class Mariage {

	private long idMariage;
	private long identityMale;
	private long male;
	private long identityFemelle;
	private long femme;
	private long idCommuneMariage;
	private boolean valide;
	private String resultat;

	public long getIdMariage() {
		return idMariage;
	}

	public void setIdMariage(long idMariage) {
		this.idMariage = idMariage;
	}

	public long getMale() {
		return male;
	}

	public void setMale(long male) {
		this.male = male;
	}

	public long getFemme() {
		return femme;
	}

	public void setFemme(long femme) {
		this.femme = femme;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public long getIdCommuneMariage() {
		return idCommuneMariage;
	}

	public void setIdCommuneMariage(long idCommuneMariage) {
		this.idCommuneMariage = idCommuneMariage;
	}

	public long getIdentityMale() {
		return identityMale;
	}

	public void setIdentityMale(long identityMale) {
		this.identityMale = identityMale;
	}

	public long getIdentityFemelle() {
		return identityFemelle;
	}

	public void setIdentityFemelle(long identityFemelle) {
		this.identityFemelle = identityFemelle;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
