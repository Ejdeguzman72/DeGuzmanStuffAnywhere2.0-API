package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.ExerciseRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Exercise> findAllExercise() {
		return exerciseRepository.findAll();
	}
	
	public ResponseEntity<Exercise> findExerciseById(@PathVariable int exerciseid) throws ResourceNotFoundException {
		Exercise exercise = exerciseRepository.findById(exerciseid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find Exercise with ID: " + exerciseid));
		
		return ResponseEntity.ok().body(exercise);
	}
	
	public Exercise addExerciseInformation(@Valid @RequestBody Exercise exercise) {
		return exerciseRepository.save(exercise);
	}
	
	public ResponseEntity<Exercise> updateExerciseInformation(@PathVariable int exerciseid, 
			@Valid @RequestBody Exercise exerciseDetails) {
		Exercise exercise = null;
		try {
			exercise = exerciseRepository.findById(exerciseid)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find exercise with ID: " + exerciseid));
			exercise.setExerciseName(exerciseDetails.getExerciseName());
			exercise.setExerciseType(exerciseDetails.getExerciseType());
			exercise.setReps(exerciseDetails.getReps());
			exercise.setSets(exerciseDetails.getSets());
			exercise.setWeight(exerciseDetails.getWeight());
		}
		
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		final Exercise updatedExerciseDetails = exerciseRepository.save(exerciseDetails);
		return ResponseEntity.ok().body(updatedExerciseDetails);
	}
	
	public Map<String,Boolean> deleteExerciseInfoById(@PathVariable int exerciseid) {
		exerciseRepository.deleteById(exerciseid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Exercise Info has been deleted", Boolean.TRUE);
		return response;
	}
}
