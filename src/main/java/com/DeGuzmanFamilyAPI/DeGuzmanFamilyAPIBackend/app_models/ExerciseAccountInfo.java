package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.Date;

public class ExerciseAccountInfo {

	public int exerciseid;
	public String exerciseName;
	public int sets;
	public int reps;
	public double weight;
	public Date date;
	public String exerciseTypeDecr; 
	public String username;
	public int getExerciseid() {
		return exerciseid;
	}
	public void setExerciseid(int exerciseid) {
		this.exerciseid = exerciseid;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExerciseTypeDecr() {
		return exerciseTypeDecr;
	}
	public void setExerciseTypeDecr(String exerciseTypeDecr) {
		this.exerciseTypeDecr = exerciseTypeDecr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((exerciseName == null) ? 0 : exerciseName.hashCode());
		result = prime * result + ((exerciseTypeDecr == null) ? 0 : exerciseTypeDecr.hashCode());
		result = prime * result + exerciseid;
		result = prime * result + reps;
		result = prime * result + sets;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ExerciseAccountInfo other = (ExerciseAccountInfo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (exerciseName == null) {
			if (other.exerciseName != null)
				return false;
		} else if (!exerciseName.equals(other.exerciseName))
			return false;
		if (exerciseTypeDecr == null) {
			if (other.exerciseTypeDecr != null)
				return false;
		} else if (!exerciseTypeDecr.equals(other.exerciseTypeDecr))
			return false;
		if (exerciseid != other.exerciseid)
			return false;
		if (reps != other.reps)
			return false;
		if (sets != other.sets)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExerciseAccountInfo [exerciseid=" + exerciseid + ", exerciseName=" + exerciseName + ", sets=" + sets
				+ ", reps=" + reps + ", weight=" + weight + ", date=" + date + ", exerciseTypeDecr=" + exerciseTypeDecr
				+ ", username=" + username + "]";
	}
	public ExerciseAccountInfo(int exerciseid, String exerciseName, int sets, int reps, double weight, Date date,
			String exerciseTypeDecr, String username) {
		super();
		this.exerciseid = exerciseid;
		this.exerciseName = exerciseName;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
		this.date = date;
		this.exerciseTypeDecr = exerciseTypeDecr;
		this.username = username;
	}
	public ExerciseAccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
