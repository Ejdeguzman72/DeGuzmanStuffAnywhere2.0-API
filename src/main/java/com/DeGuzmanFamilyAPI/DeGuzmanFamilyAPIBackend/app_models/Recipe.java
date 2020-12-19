package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "recipe")
@CrossOrigin
public class Recipe {

	public int recipeId;
	public String name;
	public int recipe_type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecipe_type() {
		return recipe_type;
	}
	public void setRecipe_type(int recipe_type) {
		this.recipe_type = recipe_type;
	}
}
