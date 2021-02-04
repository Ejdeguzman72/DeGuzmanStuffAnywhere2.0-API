package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "roles")
@CrossOrigin
public class Role {
	
	public int role_id;
	public String role_descr;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_descr == null) ? 0 : role_descr.hashCode());
		//result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
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
//		if (role_id == null) {
//			if (other.role_id != null)
//				return false;
//		} else if (!role_id.equals(other.role_id))
//			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_descr=" + role_descr + "]";
	}
	public Role(int role_id, String descr) {
		super();
		this.role_id = role_id;
		this.role_descr = descr;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
