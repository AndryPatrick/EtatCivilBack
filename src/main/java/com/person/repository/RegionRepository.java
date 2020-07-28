package com.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.person.entity.Region;

public interface RegionRepository extends CrudRepository<Region, Long>{

	@Query("FROM Region where id = ?1")
	List<Region> findRegionById(Long idRegion);

	@Query("FROM Region where id = ?1")
	Region findOneRegionById(Long idRegion);
}
