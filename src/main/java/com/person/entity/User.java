package com.person.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="User")
public class User implements Serializable, UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@JoinColumn(name="districtZone")
	private District districtZone;
	
	@OneToOne
	@JoinColumn(name="communeZone") 
	private Commune communeZone;
	
	@Column(name="maire")
	private boolean maire;
	
	@Column(name = "depute")
	private boolean depute;

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public District getDistrictZone() {
		return districtZone;
	}

	public void setDistrictZone(District districtZone) {
		this.districtZone = districtZone;
	}

	public Commune getCommuneZone() {
		return communeZone;
	}

	public void setCommuneZone(Commune communeZone) {
		this.communeZone = communeZone;
	}

	public boolean isMaire() {
		return maire;
	}

	public void setMaire(boolean maire) {
		this.maire = maire;
	}

	public boolean isDepute() {
		return depute;
	}

	public void setDepute(boolean depute) {
		this.depute = depute;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
