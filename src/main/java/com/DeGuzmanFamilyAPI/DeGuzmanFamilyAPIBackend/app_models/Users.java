package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "users")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class Users {
	

	public long user_id;
	public String username;
	public String password;
	public String name;
	public String email;
	public int user_status_id;
	public int role_id;
	
	@OneToMany(targetEntity = UserStatus.class, cascade = CascadeType.ALL)
	@JoinColumn(name="user_user_status_fk", referencedColumnName = "user_status_is")
	private List<UserStatus> userStatus;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public long getUserid() {
		return user_id;
	}
	public void setUserid(long userid) {
		this.user_id = userid;
	}
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "role_id")
	public int getRoleid() {
		return role_id;
	}
	public void setRoleid(int role_id) {
		this.role_id = role_id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "user_status_id")
	public int getUser_status() {
		return user_status_id;
	}
	public void setUser_status(int user_status_id) {
		this.user_status_id = user_status_id;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role_id;
		result = prime * result + user_status_id;
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role_id != other.role_id)
			return false;
		if (user_status_id != other.user_status_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Users [userid=" + user_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", user_status=" + user_status_id + ", role_id=" + role_id + "]";
	}
	
	public Users(long userid, String username, String password, String name, String email, int user_status_id,
			int role_id) {
		super();
		this.user_id = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.user_status_id = user_status_id;
		this.role_id = role_id;
	}
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
}
