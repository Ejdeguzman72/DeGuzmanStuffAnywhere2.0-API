package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.ExerciseService;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/app/gym-tracker")
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/all")
	public List<Exercise> getAllExercise() {
		return exerciseService.findAllExercise();
	}
	
	@GetMapping("/all-exercise")
	public ResponseEntity<Map<String,Object>> getAllExercisePagination(@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return exerciseService.getAllExercisePagination(name, page, size);
	}
	
	@GetMapping("/exercise/{exerciseid}")
	public ResponseEntity<Exercise> getExerciseById(@PathVariable int exerciseid) throws ResourceNotFoundException {
		return exerciseService.findExerciseById(exerciseid);
	}
	
	@PostMapping("/add-exercise")
	public Exercise addExerciseInformation(@Valid @RequestBody Exercise exercise) throws ResourceNotFoundException {
		return exerciseService.addExerciseInformation(exercise);
	}
	
	@PutMapping("/exercise/{exerciseid}")
	public ResponseEntity<Exercise> updateExerciseInformation(@PathVariable int exerciseid, 
			@Valid @RequestBody Exercise exerciseDetails) {
		return exerciseService.updateExerciseInformation(exerciseid, exerciseDetails);
	}
	
	@DeleteMapping("/exercise/{exerciseid}")
	public Map<String,Boolean> deleteExerciseInfoById(@PathVariable int exerciseid) {
		return exerciseService.deleteExerciseInfoById(exerciseid);
	}
}
