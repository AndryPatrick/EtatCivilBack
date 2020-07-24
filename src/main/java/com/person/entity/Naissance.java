package com.person.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="naissance")
public class Naissance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="familyName")
	private String familyName;
	
	@Column(name="dateOfBirth")
	private LocalDateTime dateOfBirth;
	
	@ManyToOne
	@JoinColumn(name="placeOfBirth")
	private Commune placeOfBirth;
	
	@Column(name="identity")
	private Long identity;
		
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="motherName")
	private String motherName;
	
	@Column(name ="sexe")
	private boolean sexe;
	
	@Column(name = "mariee")
	private boolean mariee;
	
	@Column(name = "divorce")
	private boolean divorce;
	
	@Column(name = "ansMere")
	private int ansMere;
	
	@ManyToOne
	@JoinColumn(name = "placeOfBirthMother") 
	private Commune placeOfBirthMother;
	
	@Column(name= "professionMere")
	private String professionMere;
	
	@Column(name ="lieuResidenceMere")
	private String lieuResidenceMere;
	
	@Column(name="dateCopie")
	private LocalDateTime dateCopie;
	
	@Column(name="nomInfirmiere")
	private String nomInfirmiere;
	
	@Column(name="yearNaissInfirmiere")
	private int yearNaissInfirmiere;
	
	@Column(name="professionInfirmiere")
	private String professionInfirmiere;
	
	@Column(name="lieuResidenceInfirmiere")
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

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime localDateTime) {
		this.dateOfBirth = localDateTime;
	}

	public Commune getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(Commune placeOfBirth) {
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

	public boolean isDivorce() {
		return divorce;
	}

	public void setDivorce(boolean divorce) {
		this.divorce = divorce;
	}

	public boolean isMariee() {
		return mariee;
	}

	public void setMariee(boolean mariee) {
		this.mariee = mariee;
	}

	public int getAnsMere() {
		return ansMere;
	}

	public void setAnsMere(int ansMere) {
		this.ansMere = ansMere;
	}

	public Commune getPlaceOfBirthMother() {
		return placeOfBirthMother;
	}

	public void setPlaceOfBirthMother(Commune placeOfBirthMother) {
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
