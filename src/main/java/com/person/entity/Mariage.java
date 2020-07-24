package com.person.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mariage")
public class Mariage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="dateMariage")
	private LocalDateTime dateMariage;
	
	@ManyToOne
	@JoinColumn(name="lieuMariage")
	private Commune lieuMariage;
	
	@ManyToOne
	@JoinColumn(name = "personMaleId")
	private Naissance personMale;
	
	@ManyToOne
	@JoinColumn(name ="personFemelleId")
	private Naissance personFemelle;
	
	@Column(name="valide")
	private boolean valide;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateMariage() {
		return dateMariage;
	}

	public void setDateMariage(LocalDateTime dateMariage) {
		this.dateMariage = dateMariage;
	}

	public Naissance getPersonMale() {
		return personMale;
	}

	public void setPersonMale(Naissance naissance) {
		this.personMale = naissance;
	}

	public Naissance getPersonFemelle() {
		return personFemelle;
	}

	public void setPersonFemelle(Naissance personFemelle) {
		this.personFemelle = personFemelle;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Commune getLieuMariage() {
		return lieuMariage;
	}

	public void setLieuMariagee(Commune lieuMariage) {
		this.lieuMariage = lieuMariage;
	}
	
}
