package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}