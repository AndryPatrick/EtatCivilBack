package com.person.service.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Naissance {
	
	private long id;
	
	private String name;
	
	private String familyName;
	
	private LocalDate dateOfBirth;
	
	private long placeOfBirth;
	
	private Long identity;
		
	private String fatherName;
	
	private String motherName;
	
	private boolean sexe;
	///////
	private int ansMere;
	 
	private Long placeOfBirthMother;
	
	private String professionMere;
	
	private String lieuResidenceMere;
	
	private LocalDateTime dateCopie;
	
	private String nomInfirmiere;
	
	private int yearNaissInfirmiere;
	
	private String professionInfirmiere;
	
	private String lieuResidenceInfirmiere;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(long placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Long getIdentity() {
		return identity;
	}

	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public int getAnsMere() {
		return ansMere;
	}

	public void setAnsMere(int ansMere) {
		this.ansMere = ansMere;
	}

	public Long getPlaceOfBirthMother() {
		return placeOfBirthMother;
	}

	public void setPlaceOfBirthMother(Long placeOfBirthMother) {
		this.placeOfBirthMother = placeOfBirthMother;
	}

	public String getProfessionMere() {
		return professionMere;
	}

	public void setProfessionMere(String professionMere) {
		this.professionMere = professionMere;
	}

	public String getLieuResidenceMere() {
		return lieuResidenceMere;
	}

	public void setLieuResidenceMere(String lieuResidenceMere) {
		this.lieuResidenceMere = lieuResidenceMere;
	}

	public LocalDateTime getDateCopie() {
		return dateCopie;
	}

	public void setDateCopie(LocalDateTime dateCopie) {
		this.dateCopie = dateCopie;
	}

	public String getNomInfirmiere() {
		return nomInfirmiere;
	}

	public void setNomInfirmiere(String nomInfirmiere) {
		this.nomInfirmiere = nomInfirmiere;
	}

	public int getYearNaissInfirmiere() {
		return yearNaissInfirmiere;
	}

	public void setYearNaissInfirmiere(int yearNaissInfirmiere) {
		this.yearNaissInfirmiere = yearNaissInfirmiere;
	}

	public String getProfessionInfirmiere() {
		return professionInfirmiere;
	}

	public void setProfessionInfirmiere(String professionInfirmiere) {
		this.professionInfirmiere = professionInfirmiere;
	}

	public String getLieuResidenceInfirmiere() {
		return lieuResidenceInfirmiere;
	}

	public void setLieuResidenceInfirmiere(String lieuResidenceInfirmiere) {
		this.lieuResidenceInfirmiere = lieuResidenceInfirmiere;
	}
	
}
