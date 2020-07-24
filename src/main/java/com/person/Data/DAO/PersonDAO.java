package com.person.Data.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Commune;
import com.person.entity.Person;

public interface PersonDAO extends JpaRepository<Person, Long>{

	@Query(nativeQuery = true, value = "(SELECT p.*,c.* FROM Person p INNER JOIN commune c where p.place_of_birth = c.id)")
	List<Person> getListPerson();

	@Query("FROM Person WHERE identityNumber = ?1")
	List<Person> getListPerson(Long identityNumber);

/*	@Query(nativeQuery = true, value = "SELECT * FROM Person  WHERE identity_number = "
			+ "( SELECT  max(identity_number) from Person where place_of_delivry = 'Antananarivo')")
	Person getLastIdentityNumber(); */
	
	@Query(nativeQuery = true, value = "(SELECT MAX(RIGHT(identity_number,5)) as maxIdentity from Person WHERE place_of_birth =?)")
	Long getLastIdentityNumber(long placeOfBirth); 
	
	/*@Query(nativeQuery = true, value = " SELECT *, max(identity_number) from Person where place_of_delivry = ?1")
	Person getLastIdentityNumber(String place); */

	@Query("FROM Person WHERE identityNumber = ?1")
	Person getbyCIN(Long identityNumber);

	@Query("FROM Commune WHERE code = ?1")
	Commune getCommuneByCode(int codeCommune);

	@Query("FROM Person WHERE id = ?1")
	void deletePerson(Long idPerson);
	
	@Query("FROM Commune where id = ?1")
	Commune getCommuneById(Commune commune);
	
	@Query("FROM Commune where id=?1")
	Commune getNomCommuneByPlaceOfBirth(Commune placeOfBirth);
	
	@Query(nativeQuery = true, value = "(SELECT YEAR(date_of_birth) AS ans FROM Person where id = ?1)")
	int getAnneeById(long idPerson);

	@Query(nativeQuery = true, value = "(SELECT MONTH(date_of_birth) AS mois FROM Person where id = ?1)")
	int getMonthByID(long id);
	
	@Query(nativeQuery = true, value = "(SELECT DAY(date_of_birth) AS jour FROM Person where id = ?1)")
	int getDaysByID(long id);

	
}
