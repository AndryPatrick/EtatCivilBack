package com.person.Data.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Mariage;
import com.person.entity.Naissance;
import com.person.entity.Person;

public interface MariageDAO extends JpaRepository<Mariage, Long>{
	
	//@Query(nativeQuery = true, value = "SELECT p.* from person p WHERE p.identity_number = ?1 AND p.sexe = TRUE")
	@Query("from Naissance WHERE identity = ?1 AND sexe = TRUE")
	Optional<Naissance> getPersonMaleByIdentity(long identityPersonneMale);

	//@Query(nativeQuery = true, value = "SELECT p.* from person p WHERE p.identity_number = ?1 AND p.sexe = FALSE")
	@Query("from Naissance  WHERE identity = ?1 AND sexe = FALSE")
	Optional<Naissance> getPersonFemelleByIdentity(long identityPersonneFemelle);
	
	@Query("FROM Naissance where id =?1")
	Optional<Naissance> getPersonMaleById(long idNaissance);

	@Query("FROM Naissance where id = ?1")
	Optional<Naissance> getPersonFemelleById(long personFemelle);

	@Query("FROM Mariage")
	List<Mariage> getListMariage();
	
	@Query(nativeQuery = true, value = "UPDATE naissance SET mariee = TRUE WHERE id = ?1 ")
	Naissance updatSituationFemelle(long idPersonFemelle);
	
	@Query(nativeQuery = true, value = "UPDATE naissance SET mariee = TRUE WHERE id = ?1 ")
	Naissance updatSituationMale(long idPersonMale);

	@Query(nativeQuery = true, value = "SELECT DATE(date_mariage) AS DATE FROM mariage")
	LocalDate getDateMariage();
	
}
