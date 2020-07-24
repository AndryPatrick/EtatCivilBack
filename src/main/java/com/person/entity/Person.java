package com.person.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="familyName")
	private String familyName;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name="placeOfBirth")
	private Commune placeOfBirth;
	
	@Column(name="identityNumber")
	private Long identityNumber;

	@Column(name="dateDelivry")
	private LocalDate dateDelivry;
	
	@Column(name="placeOfDelivry")
	private String placeOfDelivry;
		
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="motherName")
	private String motherName;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="dateDuplicate")
	private LocalDate dateDuplicate;
	
	@Column(name="placeOfDuplicate")
	private String placeOfDuplicate;
	
	@Column(name ="sexe")
	private boolean sexe;
	
	@Column(name="situationMatrimoniale")
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

	public Long getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
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

	public String getPlaceOfDuplicate() {
		return placeOfDuplicate;
	}

	public void setPlaceOfDuplicate(String placeOfDuplicate) {
		this.placeOfDuplicate = placeOfDuplicate;
	}

	public String getPlaceOfDelivry() {
		return placeOfDelivry;
	}

	public void setPlaceOfDelivry(String placeDelivry) {
		this.placeOfDelivry = placeDelivry;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateDelivry() {
		return dateDelivry;
	}

	public void setDateDelivry(LocalDate dateDelivry) {
		this.dateDelivry = dateDelivry;
	}

	public LocalDate getDateDuplicate() {
		return dateDuplicate;
	}

	public void setDateDuplicate(LocalDate dateDuplicate) {
		this.dateDuplicate = dateDuplicate;
	}

	public Commune getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(Commune placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public boolean isSituationMatrimoniale() {
		return situationMatrimoniale;
	}

	public void setSituationMatrimoniale(boolean situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}


}
