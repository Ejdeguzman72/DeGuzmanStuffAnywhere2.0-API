package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EXERCISE_TYPE")
@CrossOrigin
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class ExerciseType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7118064847455021642L;
	public int exerciseTypeId;
	public String exerciseTypeName;
	
	public List<Exercise> exercise;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(int exerciseTypeId) {
		this.exerciseTypeId = exerciseTypeId;
	}

	public String getExerciseTypeName() {
		return exerciseTypeName;
	}

	public void setExerciseTypeName(String exerciseTypeName) {
		this.exerciseTypeName = exerciseTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "exerciseType")
	@JsonIgnore
	public List<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + exerciseTypeId;
		result = prime * result + ((exerciseTypeName == null) ? 0 : exerciseTypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExerciseType other = (ExerciseType) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (exerciseTypeId != other.exerciseTypeId)
			return false;
		if (exerciseTypeName == null) {
			if (other.exerciseTypeName != null)
				return false;
		} else if (!exerciseTypeName.equals(other.exerciseTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExerciseType [exerciseTypeId=" + exerciseTypeId + ", exerciseTypeName=" + exerciseTypeName
				+ ", exercise=" + exercise + "]";
	}

	public ExerciseType(int exerciseTypeId, String exerciseTypeName, List<Exercise> exercise) {
		super();
		this.exerciseTypeId = exerciseTypeId;
		this.exerciseTypeName = exerciseTypeName;
		this.exercise = exercise;
	}

	public ExerciseType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
