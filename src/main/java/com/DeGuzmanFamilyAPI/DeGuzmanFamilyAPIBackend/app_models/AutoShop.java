package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
	@Column(name = "auto_shop_id")
	public int getAutoshopId() {
		return autoshopId;
	}
	public void setAutoshopId(int autoshopId) {
		this.autoshopId = autoshopId;
	}
	
	@Column(name = "auto_shop_name")
	public String getAutoShopName() {
		return autoShopName;
	}
	public void setAutoShopName(String autoShopName) {
		this.autoShopName = autoShopName;
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
	
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
