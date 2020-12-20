package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "home")
@CrossOrigin
public class Home {

	public int home_id;
	public String address;
	public String city;
	public String state;
	public String zip;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "home_id")
	public int getHome_id() {
		return home_id;
	}
	public void setHome_id(int home_id) {
		this.home_id = home_id;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + home_id;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Home other = (Home) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (home_id != other.home_id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Home [home_id=" + home_id + ", address=" + address + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
	public Home(int home_id, String address, String city, String state, String zip) {
		super();
		this.home_id = home_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
