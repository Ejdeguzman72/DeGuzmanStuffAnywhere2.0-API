package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.ExerciseType;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Users;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.ExerciseRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.ExerciseTypeRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.UserRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.RunTrackerServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;

@Service
public class ExerciseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunTrackerServiceInterface.class);
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	ExerciseTypeRepository exerciseTypeRepository;
	
	@Autowired
	private UserRepository usersRepository;
	
//	@Cacheable(value = "exercisePaginationList")
	public ResponseEntity<Map<String,Object>> getAllExercisePagination(@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {
			List<Exercise> exerciseList = exerciseRepository.findAll();
			
			Pageable paging = PageRequest.of(page, size);
			
			Page<Exercise> exercisePage = null;
			
			if (name == null) {
				exercisePage = exerciseRepository.findAll(paging);
			} else {
//				exercisePage = exerciseRepository.findByNameContaining(name, paging);
			}
			
			exerciseList = exercisePage.getContent();
			
			Map<String,Object> response = new HashMap<>();
			response.put("exercise", exerciseList);
			response.put("currentPage", exercisePage.getNumber());
			response.put("totalItems", exercisePage.getTotalElements());
			response.put("TotalPages", exercisePage.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			LOGGER.warn("Error in retrieving exerciseList " + e);
			
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
	}
	
	@Cacheable(value = "exerciseList")
	public List<Exercise> findAllExercise() {
		return exerciseRepository.findAll();
	}
	
	@Cacheable(value = "exerciseById", key = "#exerciseId")
	public ResponseEntity<Exercise> findExerciseById(@PathVariable int exerciseid) throws ResourceNotFoundException {
		Exercise exercise = exerciseRepository.findById(exerciseid)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find Exercise with ID: " + exerciseid));
		
		return ResponseEntity.ok().body(exercise);
	}
	
	@CachePut(value = "exerciseList")
	public Exercise addExerciseInformation(@Valid @RequestBody Exercise exercise) throws ResourceNotFoundException {
		String exerciseName = exercise.getExerciseName();
		int reps = exercise.getReps();
		int sets = exercise.getSets();
		double weight = exercise.getWeight();
		Date date = exercise.getDate();
		ExerciseType exerciseType = exerciseTypeRepository.findById(exercise.getExerciseType().getExerciseTypeId())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find exercise type with ID: " + exercise.getExerciseType().getExerciseTypeId()));
		Users user = usersRepository.findById(exercise.getUser().getUserid())
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find user with ID: " + exercise.getUser().getUserid()));
		
		Exercise newExercise = new Exercise(exerciseName,reps,sets,weight,date,exerciseType,user);
		return exerciseRepository.save(newExercise);
	}
	
	public ResponseEntity<Exercise> updateExerciseInformation(@PathVariable int exerciseid, 
			@Valid @RequestBody Exercise exerciseDetails) {
		Exercise exercise = null;
		try {
			exercise = exerciseRepository.findById(exerciseid)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find exercise with ID: " + exerciseid));
			exercise.setExerciseName(exerciseDetails.getExerciseName());
			exercise.setExerciseType(exerciseTypeRepository.findById(exerciseDetails.getExerciseType().getExerciseTypeId())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find exercise type resource of ID: " + exerciseDetails.getExerciseType().getExerciseTypeId())));
			exercise.setReps(exerciseDetails.getReps());
			exercise.setSets(exerciseDetails.getSets());
			exercise.setWeight(exerciseDetails.getWeight());
			exercise.setDate(exerciseDetails.getDate());
			exercise.setUser(usersRepository.findById(exerciseDetails.getUser().getUserid())
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find user with ID: " + exerciseDetails.getUser().getUserid())));
			
		}
		
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		final Exercise updatedExerciseDetails = exerciseRepository.save(exerciseDetails);
		return ResponseEntity.ok().body(updatedExerciseDetails);
	}
	
	@CachePut(value = "exerciseList")
	public Map<String,Boolean> deleteExerciseInfoById(@PathVariable int exerciseid) {
		exerciseRepository.deleteById(exerciseid);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Exercise Info has been deleted", Boolean.TRUE);
		return response;
	}
}
