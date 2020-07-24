package com.person.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="divorce")
public class Divorce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="dateDivorce")
	private LocalDateTime dataDivorce;
	
	@OneToOne
	@JoinColumn(name = "mariageId")
	private Mariage mariage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mariage getMariage() {
		return mariage;
	}

	public void setMariage(Mariage mariage) {
		this.mariage = mariage;
	}

	public LocalDateTime getDataDivorce() {
		return dataDivorce;
	}

	public void setDataDivorce(LocalDateTime dataDivorce) {
		this.dataDivorce = dataDivorce;
	}
	
}
