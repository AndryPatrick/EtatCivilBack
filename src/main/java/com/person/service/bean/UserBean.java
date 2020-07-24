package com.person.service.bean;

public class UserBean {

	private String username;
	private String password;
	private long districtId;
	private long communeId;
	private boolean maire;
	private boolean depute;

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

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getCommuneId() {
		return communeId;
	}

	public void setCommuneId(long communeId) {
		this.communeId = communeId;
	}

}
