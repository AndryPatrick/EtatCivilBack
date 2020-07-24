package com.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mairie")
public class Mairie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nomMaire")
	private String nomMaire;
	
	@Column(name="prenomMaire")
	private String prenomMaire;
	
	@OneToOne
	@JoinColumn(name="communeId")
	private Commune commune;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	
}
