package com.person.service.bean;



import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.person.utils.DateUtils;

public class Person {

	private long id;
	
	private String name;
	
	private String familyName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private Date dateOfBirth;
	
	private String dateOfBirthWord;
	
	private String placeOfBirth;
	
	private Long identityNumber;
	
	private String identityNumberSt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private Date dateDelivry;
	
	private String placeDelivry;
	
	private String fatherName;
	
	private String motherName;
	
	private String profession;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+3")
	private Date dateDuplicate;
	
	private String placeOfDuplicate;
	
	private boolean sexe;
	
	private Commune commune;
	
	private boolean situationMatrimoniale;
	
	private String sexeStr;
	
	private String situationMatrimonialeStr;

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
	
	public String getIdentityNumberSt() {
		return identityNumberSt;
	}

	public void setIdentityNumberSt(String identityNumberSt) {
		this.identityNumberSt = identityNumberSt;
	}

	public String getPlaceDelivry() {
		return placeDelivry;
	}

	public void setPlaceDelivry(String placeDelivry) {
		this.placeDelivry = placeDelivry;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirthWord() {
		return dateOfBirthWord;
	}

	public void setDateOfBirthWord(String dateOfBirthWord) {
		this.dateOfBirthWord = dateOfBirthWord;
	}

	public Date getDateDelivry() {
		return dateDelivry;
	}

	public void setDateDelivry(Date dateDelivry) {
		this.dateDelivry = dateDelivry;
	}

	public Date getDateDuplicate() {
		return dateDuplicate;
	}

	public void setDateDuplicate(Date dateDuplicate) {
		this.dateDuplicate = dateDuplicate;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
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

	public String getSexeStr() {
		return sexeStr;
	}

	public void setSexeStr(String sexeStr) {
		this.sexeStr = sexeStr;
	}

	public String getSituationMatrimonialeStr() {
		return situationMatrimonialeStr;
	}

	public void setSituationMatrimonialeStr(String situationMatrimonialeStr) {
		this.situationMatrimonialeStr = situationMatrimonialeStr;
	}
	
}
