package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "RUN_TRACKER")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class RunTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4812037100686878546L;
	public long run_id;
	public String firstname;
	public String lastname;
	public String runDate;
	public double runDistance;
	public String runTime;
	
	public Users user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "run_id")
	public long getRun_id() {
		return run_id;
	}

	public void setRun_id(long run_id) {
		this.run_id = run_id;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "run_date")
	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}

	@Column(name = "run_distance")
	public double getRunDistance() {
		return runDistance;
	}

	public void setRunDistance(double runDistance) {
		this.runDistance = runDistance;
	}

	@Column(name = "run_time")
	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}

	public void setUser(Users userRunTracker) {
		this.user = userRunTracker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(runDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		RunTracker other = (RunTracker) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (runDate == null) {
			if (other.runDate != null)
				return false;
		} else if (!runDate.equals(other.runDate))
			return false;
		if (Double.doubleToLongBits(runDistance) != Double.doubleToLongBits(other.runDistance))
			return false;
		if (runTime == null) {
			if (other.runTime != null)
				return false;
		} else if (!runTime.equals(other.runTime))
			return false;
		if (run_id != other.run_id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RunTracker [run_id=" + run_id + ", firstname=" + firstname + ", lastname=" + lastname + ", runDate="
				+ runDate + ", runDistance=" + runDistance + ", runTime=" + runTime + ", user=" + user + "]";
	}

	public RunTracker(long run_id, String firstname, String lastname, String runDate, double runDistance,
			String runTime, Users user) {
		super();
		this.run_id = run_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.runDate = runDate;
		this.runDistance = runDistance;
		this.runTime = runTime;
		this.user = user;
	}
	
	public RunTracker(String runDate, double runDistance,
			String runTime, Users user) {
		super();
		this.runDate = runDate;
		this.runDistance = runDistance;
		this.runTime = runTime;
		this.user = user;
	}

	public RunTracker() {
		super();
		// TODO Auto-generated constructor stub
	}

}
