package com.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.person.entity.Province;

public interface ProvinceRepository  extends CrudRepository<Province, Long>{

	@Query("FROM Province where id=?1")
	List<Province> findProvinceById(Long idProvince);

}
