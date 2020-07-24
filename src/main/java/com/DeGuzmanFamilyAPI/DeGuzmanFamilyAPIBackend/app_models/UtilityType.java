package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "utility_type")
@CrossOrigin
public class UtilityType {

	public int utiityTypeId;
	public String descr;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	public int getUtiityTypeId() {
		return utiityTypeId;
	}
	public void setUtiityTypeId(int utiityTypeId) {
		this.utiityTypeId = utiityTypeId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
