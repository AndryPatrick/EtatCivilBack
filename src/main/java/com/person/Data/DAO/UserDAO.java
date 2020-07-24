package com.person.Data.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.person.entity.Commune;
import com.person.entity.District;
import com.person.entity.User;

public interface UserDAO extends JpaRepository<User, Long>{

	@Query("FROM Commune where id =?1")
	Optional<Commune> findCommuneById(long communeId);

	@Query("FROM District where id =?1")
	Optional<District> findDistrictById(long districtId);
	
	@Query("FROM User where username =?1")
    Optional<User> findUserWithName(String username);

}
