package com.person.Data.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.person.entity.Divorce;
import com.person.entity.Mariage;
import com.person.entity.Naissance;

public interface DivorceDAO extends CrudRepository<Divorce, Long>{

	@Query("FROM Mariage where id = ?1")
	Optional<Mariage> getDivorceById(long idMariage);
	
	@Query(nativeQuery = true, value = "UPDATE Mariage set valide = false where id = ?1")
	void updateMariage(long idMariage);

	@Query(nativeQuery = true, value = "UPDATE Naissance set mariee = false where id = ?1 or id =?2 ")
	void updatePersonne(Naissance personMale, Naissance personFemelle);

	@Query(nativeQuery = true, value = "UPDATE Naissance set mariee = false where id =?1")
	Naissance updatSituation(long idPersonne);

	@Query(nativeQuery = true, value = "UPDATE Naissance set divorce = true where id =?1")
	void updatSituationForDivorce(long id);

}
