package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "roles")
@CrossOrigin
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3666996380336338435L;
	public int role_id;
	public String role_descr;
	
	public List<Users> users;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Column(name = "role_descr")
	public String getDescr() {
		return role_descr;
	}
	public void setDescr(String descr) {
		this.role_descr = descr;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "role")
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_descr == null) ? 0 : role_descr.hashCode());
		result = prime * result + role_id;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Role other = (Role) obj;
		if (role_descr == null) {
			if (other.role_descr != null)
				return false;
		} else if (!role_descr.equals(other.role_descr))
			return false;
		if (role_id != other.role_id)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_descr=" + role_descr + ", users=" + users + "]";
	}
	public Role(int role_id, String role_descr, List<Users> users) {
		super();
		this.role_id = role_id;
		this.role_descr = role_descr;
		this.users = users;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
