package com.person.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Data.DAO.LocalisationDAO;
import com.person.entity.Region;
import com.person.repository.CommuneRepository;
import com.person.repository.DistrictRepository;
import com.person.repository.ProvinceRepository;
import com.person.repository.RegionRepository;
import com.person.service.ServiceLocalisation;
import com.person.service.ServicePerson;
import com.person.service.bean.Commune;
import com.person.service.bean.CommuneName;
import com.person.service.bean.District;
import com.person.service.bean.Province;

@Service
public class ServiceLocalisationImpl implements ServiceLocalisation{
	@Autowired
	ProvinceRepository provinceRepository;
	
	@Autowired
	RegionRepository regionRepository;
	
	@Autowired
	LocalisationDAO localisationDAO;
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	CommuneRepository communeRepository;
	
	@Autowired
	ServiceLocalisation serviceLocalisation;

	@Override
	public List<com.person.service.bean.Region> addRegion(com.person.service.bean.Region region) {
		int codeRegion;
		Region regionEntity = new Region();
			regionEntity.setNameRegion((region.getNameRegion()).toUpperCase());
			
			final Optional<com.person.entity.Province> provinceOpt = this.localisationDAO.findProvinceById(region.getIdProvince());
			
			regionEntity.setProvince(provinceOpt.get());

			Long currentCode = this.localisationDAO.getlastCodeByProvince(provinceOpt.get());
			String code = String.valueOf(currentCode);
			if (currentCode == null) {
				code = provinceOpt.get().getCode()+"1";
				codeRegion = Integer.valueOf(code).intValue();
			}
			else {
				int entierCode = Integer.valueOf(code);
				codeRegion = entierCode + 1;
			}
			regionEntity.setCode(codeRegion);
			
			this.regionRepository.save(regionEntity);
			
		return this.serviceLocalisation.getListRegion();
	}
	
	@Override
	public void addDistrict(District districtBean) {
		int code = 0;
		com.person.entity.District districtEntity = new com.person.entity.District();
			districtEntity.setNameDistrict(districtBean.getNameDistrict().toUpperCase());	
			long a = districtBean.getIdRegion();
			final Optional<Region> regionEntityOpt = this.localisationDAO.findById(districtBean.getIdRegion());
			districtEntity.setRegion(regionEntityOpt.get());
			Long codeDistrict = this.localisationDAO.getlastCodeByRegion(regionEntityOpt.get().getId());
			if (codeDistrict == null) {
				String val = String.valueOf(codeDistrict);
				val = regionEntityOpt.get().getCode()+"01";
				codeDistrict = Long.valueOf(val);
				 code = Integer.valueOf(val);
			}
			else {
				codeDistrict = codeDistrict + 1;
				String val = String.valueOf(codeDistrict);
				code = Integer.valueOf(val);
			}
			
			districtEntity.setCode(code);
			this.districtRepository.save(districtEntity);
	}

	@Override
	public void addProvince(Province provinceBean) {
		com.person.entity.Province provinceEntity = new com.person.entity.Province();
			provinceEntity.setCode(provinceBean.getCode());
			int currentCodeProvince = this.localisationDAO.getLastCodeProvince();
			if (!provinceBean.getNomProvince().isEmpty()) {
				currentCodeProvince = currentCodeProvince + 1;
				provinceEntity.setCode(currentCodeProvince);
				provinceEntity.setNom(provinceBean.getNomProvince().toUpperCase());
				this.provinceRepository.save(provinceEntity);	
			}
	}
	
	@Override
	public void addCommune(Commune communeBean) {
			String code;
			int codeCommune;
			com.person.entity.Commune communeEntity = new com.person.entity.Commune();
			communeEntity.setNameCommune(communeBean.getNameCommune().toUpperCase());
			
			final Optional<com.person.entity.District> districtEntityOpt = this.localisationDAO.findDistrictById(communeBean.getIdDistrict());
			
			communeEntity.setDistrict(districtEntityOpt.get());
			Long lastCode = this.localisationDAO.getLastCodeByDistrict(districtEntityOpt.get().getId());
				if (lastCode == null) {
					code = districtEntityOpt.get().getCode()+"01";
					codeCommune = Integer.valueOf(code);
				}
				else {
					lastCode = lastCode + 1;
					code = String.valueOf(lastCode);
					codeCommune = Integer.valueOf(code);
				}
			communeEntity.setCode(codeCommune);
			
		this.communeRepository.save(communeEntity);
	}

	@Override
	public List<Province> getListProvince() {
		List<Province> listProvinceBean = new ArrayList<Province>();
		List<com.person.entity.Province> listProvinceEntity = this.localisationDAO.getListProvince();
			for (com.person.entity.Province provinceEntity : listProvinceEntity) {
				Province provinceBean = new Province();
				provinceBean.setIdProvince(provinceEntity.getId());
				provinceBean.setCode(provinceEntity.getCode());
				provinceBean.setNomProvince(provinceEntity.getNom());
				listProvinceBean.add(provinceBean);
			}
		return listProvinceBean;
	}
	
	@Override
	public List<com.person.service.bean.Region> getListRegion() {
		List<Region> listRegionEntity = this.localisationDAO.getListRegion();
		List<com.person.service.bean.Region> listRegionBean = new ArrayList<com.person.service.bean.Region>();
				for (Region regionEntity : listRegionEntity) {
				com.person.service.bean.Region regionBean = new com.person.service.bean.Region();
				regionBean.setIdRegion(regionEntity.getId());
				regionBean.setCodeRegion(regionEntity.getCode());
				regionBean.setNameRegion(regionEntity.getNameRegion());
				regionBean.setIdProvince(regionEntity.getProvince().getId());
				regionBean.setNomProvince(regionEntity.getProvince().getNom());
				listRegionBean.add(regionBean);
			}
		
		return listRegionBean;
	}

	@Override
	public List<com.person.service.bean.Region> getListRegionByProvince(Long idProvince) {
			List<com.person.service.bean.Region> listRegionBean = new ArrayList<>();
			List<Region> listRegionEntity = this.localisationDAO.getListRegionByProvince(idProvince);
				for (Region regionEntity : listRegionEntity) {
					com.person.service.bean.Region regionBean = new com.person.service.bean.Region();
					regionBean.setIdRegion(regionEntity.getId());
					regionBean.setNameRegion(regionEntity.getNameRegion());
					regionBean.setIdProvince(regionEntity.getProvince().getId());
					regionBean.setNomProvince(regionEntity.getProvince().getNom());
					listRegionBean.add(regionBean);
				}
		return listRegionBean;
	}
	
	@Override
	public List<District> getListDistrict() {
		
		List<com.person.entity.District> listDistrictEntity = this.localisationDAO.getListDistrict();
		List<District> listDistrictBean = new ArrayList<District>();
			for (com.person.entity.District districtEntity : listDistrictEntity) {
				District districtBean = new District();
				districtBean.setIdDistrict(districtEntity.getId());
				districtBean.setNameDistrict(districtEntity.getNameDistrict());
				districtBean.setCodeDistrict(districtEntity.getCode());
				districtBean.setIdRegion(districtEntity.getRegion().getId());
				districtBean.setNameRegion(districtEntity.getRegion().getNameRegion());
				districtBean.setIdProvince(districtEntity.getRegion().getProvince().getId());
				districtBean.setNomProvince(districtEntity.getRegion().getProvince().getNom());
				listDistrictBean.add(districtBean);	
			} 
		
		return listDistrictBean;
		
	}
	

	@Override
	public List<Commune> getListCommune() {
		List<Commune> listCommuneBean = new ArrayList<Commune>();
		List<com.person.entity.Commune> listCommuneEntity = this.localisationDAO.getListCommune();
			for (com.person.entity.Commune communeEntity : listCommuneEntity) {
				Commune communeBean = new Commune();
				communeBean.setIdCommune(communeEntity.getId());
				communeBean.setNameCommune(communeEntity.getNameCommune());
				communeBean.setCodeCommune(communeEntity.getCode());
				communeBean.setIdDistrict(communeEntity.getDistrict().getId());
				communeBean.setNameDistrict(communeEntity.getDistrict().getNameDistrict());
				communeBean.setIdRegion(communeEntity.getDistrict().getRegion().getId());
				communeBean.setNameRegion(communeEntity.getDistrict().getRegion().getNameRegion());
				communeBean.setIdProvince(communeEntity.getDistrict().getRegion().getProvince().getId());
				communeBean.setNomProvince(communeEntity.getDistrict().getRegion().getProvince().getNom());
				listCommuneBean.add(communeBean);
			}
		return listCommuneBean;
	}

	@Override
	public String deleteRegion(Long idRegion) {
		this.regionRepository.deleteById(idRegion);
		return "valeur supprimé";
	}

	@Override
	public String deleteDistrict(Long idDistrict) {
			this.districtRepository.deleteById(idDistrict);
		return "district supprimé avec succès";
	}

	@Override
	public String deleteCOmmune(Long idCommune) {
		this.communeRepository.deleteById(idCommune);
		return "commune supprimé avec succès";
	}

	@Override
	public void deleteProvince(Long idProvince) {
		this.provinceRepository.deleteById(idProvince);
		
	}

	@Override
	public List<CommuneName> getNameCommune() {
		List<CommuneName> ListCommuneBean = new ArrayList<>();
		List<com.person.entity.Commune> ListCommuneEntity = this.localisationDAO.getNameCommune();
		for(com.person.entity.Commune communeEntity : ListCommuneEntity) {
			CommuneName communeBean = new CommuneName();
			communeBean.setIdCommune(communeEntity.getId());
			communeBean.setNameCommune(communeEntity.getNameCommune());
			ListCommuneBean.add(communeBean);
		}
		return ListCommuneBean;
	}

	@Override
	public Province updateProvince(Long idProvince, Province province) {
		com.person.entity.Province provinceEntity = this.localisationDAO.findOneProvinceById(idProvince);
			provinceEntity.setCode(province.getCode());
			provinceEntity.setNom(province.getNomProvince().toUpperCase());
			this.provinceRepository.save(provinceEntity);
		return province;
	}

	@Override
	public List<Province> getProvinceById(Long idProvince) {
		List<Province> provinceListBean = new ArrayList<Province>();
		List<com.person.entity.Province> ListprovinceEntity = this.provinceRepository.findProvinceById(idProvince);
		
			for(com.person.entity.Province provinceEntity : ListprovinceEntity) {
				Province provinceBean = new Province();
				provinceBean.setIdProvince(provinceEntity.getId());
				provinceBean.setCode(provinceEntity.getCode());
				provinceBean.setNomProvince(provinceEntity.getNom());
				provinceListBean.add(provinceBean);
			}
		
		return provinceListBean;
	}

	@Override
	public List<com.person.service.bean.Region> getRegionById(Long idRegion) {
		List<com.person.service.bean.Region> regionListBean = new ArrayList<com.person.service.bean.Region>();
		List<Region> regionListEntity = this.regionRepository.findRegionById(idRegion);
		
			for (Region regionEntity : regionListEntity) {
				com.person.service.bean.Region regionBean = new com.person.service.bean.Region();
				regionBean.setCode(regionEntity.getProvince().getCode());
				regionBean.setCodeRegion(regionEntity.getCode());
				regionBean.setNameRegion(regionEntity.getNameRegion());
				regionBean.setNomProvince(regionEntity.getProvince().getNom());
				regionBean.setIdRegion(regionEntity.getId());
				regionBean.setIdProvince(regionEntity.getProvince().getId());
				regionListBean.add(regionBean);
			}
		
		return regionListBean;
	}

	@Override
	public com.person.service.bean.Region updateRegion(Long idRegion, com.person.service.bean.Region region) {
			Region regionEntity = this.regionRepository.findOneRegionById(idRegion);
			regionEntity.setNameRegion(region.getNameRegion().toUpperCase());
			if (region.getIdProvince() != null) {
				Optional<com.person.entity.Province> provinceOpt = this.localisationDAO.findProvinceById(region.getIdProvince());
				if (provinceOpt.isPresent()) {
					regionEntity.setProvince(provinceOpt.get());
				}
			}
			this.regionRepository.save(regionEntity);
		return null;
	}
	
}
