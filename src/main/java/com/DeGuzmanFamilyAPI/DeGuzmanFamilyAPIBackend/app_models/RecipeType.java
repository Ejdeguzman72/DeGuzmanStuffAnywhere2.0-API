package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "recipe_type")
@CrossOrigin
public class RecipeType {
	
	public int recipeTypeId;
	public String descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRecipeTypeId() {
		return recipeTypeId;
	}
	public void setRecipeTypeId(int recipeTypeId) {
		this.recipeTypeId = recipeTypeId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
