package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "users")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class Users implements UserDetailsService{

	private long userid;
	private String username;
	private String password;
	private String name;
	private int user_status;
	private int roleid;
	
//	@OneToOne(fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL,
//			mappedBy = "user")
//	private UserPerson userPerson;
//	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
//	public UserPerson getUserPerson() {
//		return userPerson;
//	}
//	public void setUserPerson(UserPerson userPerson) {
//		this.userPerson = userPerson;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleid;
		result = prime * result + user_status;
		result = prime * result + (int) (userid ^ (userid >>> 32));
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
		if (roleid != other.roleid)
			return false;
		if (user_status != other.user_status)
			return false;
		if (userid != other.userid)
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
		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", user_status=" + user_status + ", roleid=" + roleid + "]";
	}
	
	
	public Users(long userid, String username, String password, String name, int user_status, int roleid) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.user_status = user_status;
		this.roleid = roleid;
	}
	
	public Users() {
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
