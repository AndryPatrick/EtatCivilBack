package com.person.repository;

import org.springframework.data.repository.CrudRepository;

import com.person.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
