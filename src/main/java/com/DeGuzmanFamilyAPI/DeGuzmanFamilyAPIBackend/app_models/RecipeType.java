package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
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
	
	public int recipe_type_idd;
	public String restaurant_type_descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_type_id")
	public int getRecipe_type_idd() {
		return recipe_type_idd;
	}
	public void setRecipe_type_idd(int recipe_type_idd) {
		this.recipe_type_idd = recipe_type_idd;
	}
	@Column(name = "descr")
	public String getDescr() {
		return restaurant_type_descr;
	}
	public void setDescr(String descr) {
		this.restaurant_type_descr = descr;
	}
	
	
}
