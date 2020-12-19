package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "USER_STATUS")
@CrossOrigin
public class UserStatus {
	
	public int user_status_id;
	public String statusDescr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(int user_status_id) {
		this.user_status_id = user_status_id;
	}
	public String getDescr() {
		return statusDescr;
	}
	public void setDescr(String descr) {
		this.statusDescr = descr;
	}
	
	
}
