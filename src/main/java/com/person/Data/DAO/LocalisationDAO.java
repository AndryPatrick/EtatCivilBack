package com.person.Data.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Commune;
import com.person.entity.District;
import com.person.entity.Province;
import com.person.entity.Region;
import com.person.service.bean.Com;

public interface LocalisationDAO extends JpaRepository<Region, Long>{

	@Query("from Region r INNER JOIN Province p ON r.province = p.id")
	List<Region> getListRegion();

	@Query("DELETE from Region where id=?1")
	void deleteRegion(Long idPerson);

	@Query("from District d  INNER JOIN  Region r ON d.region = r.id")
	List<District> getListDistrict();
	
	@Query("from Commune c INNER JOIN District d ON c.district = d.id")
	List<Commune> getListCommune();
 
	@Query("from District where name_district=?1")
	com.person.service.bean.District getDistrict(String namaDistrict);

	@Query("from District where id =?1")
	Optional<District> findDistrictById(Long idDistrict);

	@Query("from Province")
	List<Province> getListProvince();

	@Query("from Province where id =?1")
	Optional<Province> findProvinceById(Long idProvince);
	
	@Query("from Province")
	Optional<Province> findProvince();

	@Query("from Region where province_id = ?1")
	List<Region> getListRegionByProvince(Long idProvince);

	@Query("from Commune where id = ?1")
	Optional<Commune> findCommuneById(Long idCommune);
	
	@Query("from Commune")
	List<Commune> getNameCommune();

	@Query(nativeQuery=true, value = "(SELECT max(code) as currentCodeRegion from Region where province_id = ?)")
	Long getlastCodeByProvince(Province province);

	@Query(nativeQuery = true, value = "(SELECT id from Commune where id = ?1)")
	Commune getIdCommune(Long idCommune);
	
	@Query("SELECT id from Commune where id = ?1")
	Optional<Commune> getIdCommuneById(Long idCommune);

	@Query(nativeQuery = true, value = "SELECT max(code) as currentCodeDistrict from District where region_id = ?1")
	Long getlastCodeByRegion(Long idRegion);

	@Query(nativeQuery = true, value = "SELECT max(code) as currentCodeProvince from Province")
	int getLastCodeProvince();
	
	@Query(nativeQuery = true, value = "SELECT max(code) as currentCodeCommune from Commune where district_id = ?1")
	Long getLastCodeByDistrict(Long idDistrict);

	@Query("from Commune where id = ?1")
	Optional<Commune> findCommuneById(Commune idCommune);

	@Query("from Province where id = ?1")
	Province findOneProvinceById(Long idProvince);
}
