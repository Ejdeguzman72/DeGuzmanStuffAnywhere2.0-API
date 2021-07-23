package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AUTO_SHOP")
@CrossOrigin
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class AutoShop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7246009274943519322L;
	public int autoshopId;
	public String autoShopName;
	public String address;
	public String city;
	public String zip;
	public String state;
	
	List<AutoTransaction> autoTransaction;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAutoshopId() {
		return autoshopId;
	}
	public void setAutoshopId(int autoshopId) {
		this.autoshopId = autoshopId;
	}
	public String getAutoShopName() {
		return autoShopName;
	}
	public void setAutoShopName(String autoShopName) {
		this.autoShopName = autoShopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
