package com.person.service;

import java.util.List;
import java.util.Optional;

import com.person.service.bean.Commune;
import com.person.service.bean.CommuneName;
import com.person.service.bean.District;
import com.person.service.bean.Province;
import com.person.service.bean.Region;

public interface ServiceLocalisation {

	List<Region> addRegion(Region region);

	List<Region> getListRegion();

	String deleteRegion(Long idRegion);

	void addDistrict(District district);

	List<District> getListDistrict();

	String deleteDistrict(Long idDistrict);

	void addCommune(Commune commune);

	List<Commune> getListCommune();

	String deleteCOmmune(Long idCommune);

	void addProvince(Province province);

	List<Province> getListProvince();

	void deleteProvince(Long idProvince);

	List<Region> getListRegionByProvince(Long idProvince);

	List<CommuneName> getNameCommune();

	Province updateProvince(Long idProvince, Province province);

	List<Province> getProvinceById(Long idProvince);

	List<Region> getRegionById(Long idRegion);

	Region updateRegion(Long idRegion, Region region);

}
