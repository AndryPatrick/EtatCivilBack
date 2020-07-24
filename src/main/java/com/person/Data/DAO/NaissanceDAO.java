package com.person.Data.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Mairie;
import com.person.entity.Naissance;

public interface NaissanceDAO extends JpaRepository<Naissance, Long>{
	
	@Query(nativeQuery = true, value = "SELECT MAX(RIGHT(identity,5)) FROM naissance  WHERE place_of_birth = ?1")
	Long getLastIdentity(Long idCommune);

	@Query("from Naissance where identity =?1")
	Naissance getNaissanceById(long identity);

	@Query(nativeQuery = true, value="( SELECT YEAR(date_of_birth) AS annee FROM naissance WHERE identity = ?1 )")
	int getYear(long identity);
	
	@Query(nativeQuery = true, value="( SELECT MONTH(date_of_birth) AS annee FROM naissance WHERE identity = ?1 )")
	int getMois(long identity);
	
	@Query(nativeQuery = true, value="( SELECT DAY(date_of_birth) AS annee FROM naissance WHERE identity = ?1 )")
	int getDays(long identity);

	@Query(nativeQuery = true, value ="SELECT DAY(date_copie) as jourCopie FROM naissance WHERE identity =?1 " )
	int getDaysDeclaration(long identity);

	@Query("FROM Mairie where commune_id=?1")
	Mairie getMaire(Long idCommune);

}
