package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Exercise;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.ExerciseType;

@Service
public class ExerciseAccountInfoService extends ExerciseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseAccountInfoService.class);
	
	public List<ExerciseAccountInfoService> createExerciseInfoList(List<Exercise> listExercise) {
		
		List<ExerciseAccountInfoService> exerciseInfoList = new ArrayList<>();
		
		for (int i = 0; i < listExercise.size(); i++) {
			int exerciseid = listExercise.get(i).getExerciseid();
			String exerciseName = listExercise.get(i).getExerciseName();
			int sets = listExercise.get(i).getSets();
			int reps = listExercise.get(i).getReps();
			double weight = listExercise.get(i).getWeight();
			Date date = listExercise.get(i).getDate();
			
			List<ExerciseType> exerciseTypeList = exerciseTypeRepository.findAll();
			
			for (int j = 0; j < exerciseTypeList.size(); j++) {
				
				Map<Integer,String> exerciseTypeMap = new HashMap<>();
				exerciseTypeMap.put(exerciseTypeList.get(i).getExerciseTypeId(), exerciseTypeList.get(i).getExerciseTypeName());
				String exerciseTypeName = exerciseTypeMap.get(i);
			}
			
		}
	
		return exerciseInfoList;
	}
			
			
}
