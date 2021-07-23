package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "users")
@CrossOrigin
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class Users implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9190614374131494245L;
	public long user_id;
	public String username;
	public String password;
	public String name;
	public String email;
	
	public List<RunTracker> runTracker;
	
	public List<AutoTransaction> autoTransaction;
	
	public List<GeneralTransaction> generalTransaction;
	
	public List<MedicalTransaction> medicalTransaction;
	
	public List<Exercise> exercise;
	
	public UserStatus userStatus;
	
	public Role role;
		
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

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	@JsonIgnore
	public List<RunTracker> getRunTracker() {
		return runTracker;
	}
	public void setRunTracker(List<RunTracker> runTracker) {
		this.runTracker = runTracker;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_status_id")
	@JsonIgnore
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	@JsonIgnore
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy="user")
	@JsonIgnore
	public List<AutoTransaction> getAutoTransaction() {
		return autoTransaction;
	}
	public void setAutoTransaction(List<AutoTransaction> autoTransaction) {
		this.autoTransaction = autoTransaction;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="user")
	@JsonIgnore
	public List<GeneralTransaction> getGeneralTransaction() {
		return generalTransaction;
	}
	public void setGeneralTransaction(List<GeneralTransaction> generalTransaction) {
		this.generalTransaction = generalTransaction;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="user")
	@JsonIgnore
	public List<MedicalTransaction> getMedicalTransaction() {
		return medicalTransaction;
	}
	public void setMedicalTransaction(List<MedicalTransaction> medicalTransaction) {
		this.medicalTransaction = medicalTransaction;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Exercise> getExercise() {
		return exercise;
	}
	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoTransaction == null) ? 0 : autoTransaction.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + ((generalTransaction == null) ? 0 : generalTransaction.hashCode());
		result = prime * result + ((medicalTransaction == null) ? 0 : medicalTransaction.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((runTracker == null) ? 0 : runTracker.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		if (autoTransaction == null) {
			if (other.autoTransaction != null)
				return false;
		} else if (!autoTransaction.equals(other.autoTransaction))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (generalTransaction == null) {
			if (other.generalTransaction != null)
				return false;
		} else if (!generalTransaction.equals(other.generalTransaction))
			return false;
		if (medicalTransaction == null) {
			if (other.medicalTransaction != null)
				return false;
		} else if (!medicalTransaction.equals(other.medicalTransaction))
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (runTracker == null) {
			if (other.runTracker != null)
				return false;
		} else if (!runTracker.equals(other.runTracker))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
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
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", runTracker=" + runTracker + ", autoTransaction=" + autoTransaction
				+ ", generalTransaction=" + generalTransaction + ", medicalTransaction=" + medicalTransaction
				+ ", exercise=" + exercise + ", userStatus=" + userStatus + ", role=" + role + "]";
	}
	public Users(long user_id, String username, String password, String name, String email, List<RunTracker> runTracker,
			List<AutoTransaction> autoTransaction, List<GeneralTransaction> generalTransaction,
			List<MedicalTransaction> medicalTransaction, List<Exercise> exercise, UserStatus userStatus, Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.runTracker = runTracker;
		this.autoTransaction = autoTransaction;
		this.generalTransaction = generalTransaction;
		this.medicalTransaction = medicalTransaction;
		this.exercise = exercise;
		this.userStatus = userStatus;
		this.role = role;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
