package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public static final String FIND_CONTACTS = "SELECT p.personid, p.firstname,p.lastname,p.phone,p.email from person p";
	
	@Query(value = FIND_CONTACTS)
	public List<Person> findContacts();
}
