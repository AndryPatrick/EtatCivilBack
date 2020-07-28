package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.service.ServiceLocalisation;
import com.person.service.bean.Commune;
import com.person.service.bean.CommuneName;
import com.person.service.bean.District;
import com.person.service.bean.Province;
import com.person.service.bean.Region;

@RestController
@RequestMapping(path = "/localisation")
@CrossOrigin(origins = "*")
public class ControllerLocalisation {
	
	@Autowired
	ServiceLocalisation serviceLocalisation;	
	
	
	@PostMapping("/addProvince")
		public String saveProvince (@Validated @RequestBody Province province) {
			this.serviceLocalisation.addProvince (province);
		return "province ajouté avec succès";
	}
	
	@GetMapping("/getAllProvince") 
	public List<Province> getListProvince() {
			List<Province> listProvince = this.serviceLocalisation.getListProvince();
		return listProvince;
	}
	
	@DeleteMapping("/deleteProvince/{idProvince}")
	public String deleteProvince (@PathVariable(name="idProvince") Long idProvince) {
		this.serviceLocalisation.deleteProvince(idProvince);
		return ("province "+idProvince+ " supprimé correctement" );
	}

	@GetMapping(path="/getProvince/{idProvince}")
	public List<Province> getProvinceById(@PathVariable(name="idProvince") Long idProvince) {
		List<Province> province =	this.serviceLocalisation.getProvinceById(idProvince);
		return province;
	} 
	
	@PutMapping(path="/updateProvince/{idProvince}")
	public Province updateProvince (@PathVariable(name="idProvince") String idProvince,@Validated @RequestBody Province province) {
		Province provinceBean = this.serviceLocalisation.updateProvince(Long.valueOf(idProvince), province);
		return provinceBean;
	}
	
	@PostMapping("/addRegion")
		public String saveRegion (@Validated @RequestBody Region region ) {
			this.serviceLocalisation.addRegion(region);		
		return "valeur ajouter";
	}

	@GetMapping(path="/getRegion/{idRegion}")
	public List<Region> getRegion(@PathVariable(name="idRegion") Long idRegion) {
		List<Region > listRegion = this.serviceLocalisation.getRegionById(idRegion);
		return listRegion;
	}
	
	@PutMapping(path="/updateRegion/{idRegion}")
	public String updateRegion(@PathVariable(name="idRegion") Long idRegion,@Validated @RequestBody Region region) {
			Region RegionBean = this.serviceLocalisation.updateRegion(idRegion,region);
		return "valeur modifié avec succès";
	}
	
	@GetMapping("/deleteRegion/{idRegion}")
	public String deleteRegion(@PathVariable(name="idRegion") Long idRegion) {
			this.serviceLocalisation.deleteRegion(idRegion);
		return "valeur supprimé avec succès";
	}

	@GetMapping("/getAllRegion")
	public List<Region> getListRegion(){
		List<Region> listRegion = this.serviceLocalisation.getListRegion();
		return listRegion;
	}
	
	@GetMapping("/getRegionByProvince/{idProvince}")
	public List<Region> GetRegionByProvince(@PathVariable(name="idProvince") Long idProvince) {
		List<Region> listRegionByProvince = this.serviceLocalisation.getListRegionByProvince(idProvince);
		return listRegionByProvince;
	}

	
	@PostMapping("/addDistrict")
		public String saveDistrict (@Validated @RequestBody District district) {
				this.serviceLocalisation.addDistrict(district);	
			return "District ajouté avec succès";	
	}
	
	@GetMapping("/getAllDistrict")
	public List<District> getListDistrict() {
			List<District> listDistrict = this.serviceLocalisation.getListDistrict();
		return listDistrict;
	}

	@GetMapping("/deleDistrict/{idDistrict}") 
	public String deleteDistrict (@PathVariable(name = "idDistrict") Long idDistrict) {
			this.serviceLocalisation.deleteDistrict(idDistrict);
		return "dictrict"+idDistrict+ "supprimé avec succès";
	}
	
	@PostMapping("/addCommune")
		public String saveCommune (@Validated @RequestBody Commune commune) {
			this.serviceLocalisation.addCommune (commune);
		return "commune ajouté avec succès";
	}

	@GetMapping("/getAllCommune")
	public List<Commune> getListCOmmune() {
			List<Commune> listCommune = this.serviceLocalisation.getListCommune();
		return listCommune;
	}

	@GetMapping("/deleteCommune/{idCommune}")
	public String deleteCOmmune (@PathVariable(name="idCommune") Long idCommune) {
			this.serviceLocalisation.deleteCOmmune(idCommune);
		return "commune" +idCommune+ "supprimé avec succès";
	}

	@GetMapping("/getCommune") 
	public List<CommuneName> getNomCommune() {
		List<CommuneName> nameCommuneList = this.serviceLocalisation.getNameCommune();
		return nameCommuneList;
	}

}

