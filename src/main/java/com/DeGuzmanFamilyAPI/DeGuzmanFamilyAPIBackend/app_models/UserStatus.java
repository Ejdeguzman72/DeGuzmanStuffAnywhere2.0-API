package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "USER_STATUS")
@CrossOrigin
public class UserStatus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -133071239717271640L;
	public int user_status_id;
	public String user_status_descr;
	
	
	public List<Users> usersList;
	
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
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "userStatus")
	@JsonIgnore
	public List<Users> getUsers() {
		return usersList;
	}
	public void setUsers(List<Users> users) {
		this.usersList = users;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_status_descr == null) ? 0 : user_status_descr.hashCode());
		result = prime * result + user_status_id;
		result = prime * result + ((usersList == null) ? 0 : usersList.hashCode());
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
		UserStatus other = (UserStatus) obj;
		if (user_status_descr == null) {
			if (other.user_status_descr != null)
				return false;
		} else if (!user_status_descr.equals(other.user_status_descr))
			return false;
		if (user_status_id != other.user_status_id)
			return false;
		if (usersList == null) {
			if (other.usersList != null)
				return false;
		} else if (!usersList.equals(other.usersList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserStatus [user_status_id=" + user_status_id + ", user_status_descr=" + user_status_descr
				+ ", usersList=" + usersList + "]";
	}
	public UserStatus(int user_status_id, String user_status_descr, List<Users> usersList) {
		super();
		this.user_status_id = user_status_id;
		this.user_status_descr = user_status_descr;
		this.usersList = usersList;
	}
	public UserStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
