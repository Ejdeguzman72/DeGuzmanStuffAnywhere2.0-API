package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "RECIPE_TYPE")
@CrossOrigin
public class RecipeType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 431117213266848807L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipe_type_idd;
		result = prime * result + ((restaurant_type_descr == null) ? 0 : restaurant_type_descr.hashCode());
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
		RecipeType other = (RecipeType) obj;
		if (recipe_type_idd != other.recipe_type_idd)
			return false;
		if (restaurant_type_descr == null) {
			if (other.restaurant_type_descr != null)
				return false;
		} else if (!restaurant_type_descr.equals(other.restaurant_type_descr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RecipeType [recipe_type_idd=" + recipe_type_idd + ", restaurant_type_descr=" + restaurant_type_descr
				+ "]";
	}
	public RecipeType(int recipe_type_idd, String restaurant_type_descr) {
		super();
		this.recipe_type_idd = recipe_type_idd;
		this.restaurant_type_descr = restaurant_type_descr;
	}
	public RecipeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
