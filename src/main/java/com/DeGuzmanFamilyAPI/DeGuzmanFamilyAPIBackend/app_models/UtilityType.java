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
	public String utility_type_descr;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "utility_type_id")
	public int getUtiityTypeId() {
		return utility_type_id;
	}
	public void setUtiityTypeId(int utiityTypeId) {
		this.utility_type_id = utiityTypeId;
	}
	@Column(name = "utility_type_descr")
	public String getDescr() {
		return utility_type_descr;
	}
	public void setDescr(String utility_type_descr) {
		this.utility_type_descr = utility_type_descr;
	}
}
