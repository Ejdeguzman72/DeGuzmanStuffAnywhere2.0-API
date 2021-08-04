package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "RECIPE")
@CrossOrigin
public class Recipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4689726226052943307L;
	public int recipe_id;
	public String name;
	public int recipe_type_id;
	
	public List<RecipeType> recipeType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "recipe_type_id")
	public int getRecipe_type_id() {
		return recipe_type_id;
	}
	public void setRecipe_type_id(int recipe_type_id) {
		this.recipe_type_id = recipe_type_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipeType == null) ? 0 : recipeType.hashCode());
		result = prime * result + recipe_id;
		result = prime * result + recipe_type_id;
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
		Recipe other = (Recipe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeType == null) {
			if (other.recipeType != null)
				return false;
		} else if (!recipeType.equals(other.recipeType))
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		if (recipe_type_id != other.recipe_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", name=" + name + ", recipe_type_id=" + recipe_type_id
				+ ", recipeType=" + recipeType + "]";
	}
	public Recipe(int recipe_id, String name, int recipe_type_id, List<RecipeType> recipeType) {
		super();
		this.recipe_id = recipe_id;
		this.name = name;
		this.recipe_type_id = recipe_type_id;
		this.recipeType = recipeType;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
