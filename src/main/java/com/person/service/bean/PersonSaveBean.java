package com.person.service.bean;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonSaveBean extends Commune{

private long id;
	
	private String name;
	
	private String familyName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private LocalDate dateOfBirth;
	
	private String placeOfBirth;
	
	private Long identityNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private LocalDate dateDelivry;
	
	private String placeOfDelivry;
	
	private String fatherName;
	
	private String motherName;
	
	private String profession;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private LocalDate dateDuplicate;
	
	private String placeOfDuplicate;
	
	private boolean sexe;
	
	private Commune commune;
	
	private boolean situationMatrimoniale;

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

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Long getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
	}

	public LocalDate getDateDelivry() {
		return dateDelivry;
	}

	public void setDateDelivry(LocalDate dateDelivry) {
		this.dateDelivry = dateDelivry;
	}

	public String getPlaceOfDelivry() {
		return placeOfDelivry;
	}

	public void setPlaceOfDelivry(String placeOfDelivry) {
		this.placeOfDelivry = placeOfDelivry;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public LocalDate getDateDuplicate() {
		return dateDuplicate;
	}

	public void setDateDuplicate(LocalDate dateDuplicate) {
		this.dateDuplicate = dateDuplicate;
	}

	public String getPlaceOfDuplicate() {
		return placeOfDuplicate;
	}

	public void setPlaceOfDuplicate(String placeOfDuplicate) {
		this.placeOfDuplicate = placeOfDuplicate;
	}


	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public boolean isSituationMatrimoniale() {
		return situationMatrimoniale;
	}

	public void setSituationMatrimoniale(boolean situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	
}
