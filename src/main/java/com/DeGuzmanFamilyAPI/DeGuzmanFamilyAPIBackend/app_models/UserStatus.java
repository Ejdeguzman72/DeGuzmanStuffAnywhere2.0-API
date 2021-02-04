package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
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
	public String user_status_descr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_status_id")
	public int getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(int user_status_id) {
		this.user_status_id = user_status_id;
	}
	@Column(name = "user_status_descr")
	public String getDescr() {
		return user_status_descr;
	}
	public void setDescr(String user_status_descr) {
		this.user_status_descr = user_status_descr;
	}
	
	
}
