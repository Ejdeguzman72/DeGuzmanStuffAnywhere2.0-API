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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "car")
@Entity
@CrossOrigin
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6819954124384869848L;
	public long car_id;
	public String year;
	public String make;
	public String model;
	public int capactity;
	public String transmission;
	
	public List<AutoTransaction> autoTransaction;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	public long getCarid() {
		return car_id;
	}
	public void setCarid(long car_id) {
		this.car_id = car_id;
	}
	@Column(name = "year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Column(name = "make")
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	@Column(name = "model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "capacity")
	public int getCapactity() {
		return capactity;
	}
	public void setCapactity(int capactity) {
		this.capactity = capactity;
	}
	@Column(name = "transmission")
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy="car")
	@JsonIgnore
	public List<AutoTransaction> getAutoTransaction() {
		return autoTransaction;
	}
	public void setAutoTransaction(List<AutoTransaction> autoTransaction) {
		this.autoTransaction = autoTransaction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoTransaction == null) ? 0 : autoTransaction.hashCode());
		result = prime * result + capactity;
		result = prime * result + (int) (car_id ^ (car_id >>> 32));
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Car other = (Car) obj;
		if (autoTransaction == null) {
			if (other.autoTransaction != null)
				return false;
		} else if (!autoTransaction.equals(other.autoTransaction))
			return false;
		if (capactity != other.capactity)
			return false;
		if (car_id != other.car_id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (transmission == null) {
			if (other.transmission != null)
				return false;
		} else if (!transmission.equals(other.transmission))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", year=" + year + ", make=" + make + ", model=" + model + ", capactity="
				+ capactity + ", transmission=" + transmission + ", autoTransaction=" + autoTransaction + "]";
	}
	public Car(long car_id, String year, String make, String model, int capactity, String transmission,
			List<AutoTransaction> autoTransaction) {
		super();
		this.car_id = car_id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.capactity = capactity;
		this.transmission = transmission;
		this.autoTransaction = autoTransaction;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
