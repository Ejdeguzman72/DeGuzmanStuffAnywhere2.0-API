package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {

	@Query(value = "SELECT * FROM EXERCISE WHERE USERID = ?1", nativeQuery=true)
	Exercise findExerciseByUser(int userid);
	
	@Query(value = "SELECT * FROM EXERCISE WHERE exerciseTypeId = ?!", nativeQuery=true)
	Exercise findExerciseByType(int exerciseTypeId);
	
	Page<Exercise> findAll(Pageable pageable);
	
//	Page<Exercise> findByNameContaining(String name, Pageable pageable);
}
