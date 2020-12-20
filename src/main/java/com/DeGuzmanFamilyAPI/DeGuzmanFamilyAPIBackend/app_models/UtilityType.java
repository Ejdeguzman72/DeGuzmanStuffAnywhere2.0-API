package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
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

	public int utility_type_id;
	public String descr;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "utility_type_id")
	public int getUtiityTypeId() {
		return utility_type_id;
	}
	public void setUtiityTypeId(int utiityTypeId) {
		this.utility_type_id = utiityTypeId;
	}
	@Column(name = "descr")
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
