package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;

public interface ExerciseServiceInterface {

	public List<Exercise> findAllExerciseInformation();
	
	public ResponseEntity<Exercise> findExerciseById(@PathVariable int exerciseid);
	
	public Exercise addExerciseInformation(@Valid @RequestBody Exercise exercise);
	
	public ResponseEntity<Exercise> updateExerciseInformation(@PathVariable int exerciseid,
			@Valid @RequestBody Exercise exerciseDetails);
	
	public Map<String,Boolean> deleteExerciseInformationById(@PathVariable int exerciseid);
}
