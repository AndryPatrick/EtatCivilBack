package com.person.service.bean;

import org.springframework.lang.NonNull;

public class DistrictSaveBean {
	
	@NonNull
	private Long districtId;
	
	private District district;

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
}
