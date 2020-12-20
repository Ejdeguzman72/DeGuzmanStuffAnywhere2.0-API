package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "run_tracker")
@CrossOrigin
public class RunTracker {

	public long run_id;
	public String firstname;
	public String lastname;
	public Date runDate;
	public double runDistance;
	public String runTime;
	public long person_id;
	
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
	public Date getRunDate() {
		return runDate;
	}
	public void setRunDate(Date runDate) {
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
	@Column(name = "person_id")
	public long getPerson_id() {
		return person_id;
	}
	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + (int) (person_id ^ (person_id >>> 32));
		result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(runDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((runTime == null) ? 0 : runTime.hashCode());
		result = prime * result + (int) (run_id ^ (run_id >>> 32));
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
		if (person_id != other.person_id)
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
		return true;
	}
	@Override
	public String toString() {
		return "RunTracker [run_id=" + run_id + ", firstname=" + firstname + ", lastname=" + lastname + ", runDate="
				+ runDate + ", runDistance=" + runDistance + ", runTime=" + runTime + ", person_id=" + person_id + "]";
	}
	public RunTracker(long run_id, String firstname, String lastname, Date runDate, double runDistance, String runTime,
			long person_id) {
		super();
		this.run_id = run_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.runDate = runDate;
		this.runDistance = runDistance;
		this.runTime = runTime;
		this.person_id = person_id;
	}
	public RunTracker() {
		super();
		// TODO Auto-generated constructor stub
	}
}
