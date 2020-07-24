package com.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.person.entity.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long>{

}
