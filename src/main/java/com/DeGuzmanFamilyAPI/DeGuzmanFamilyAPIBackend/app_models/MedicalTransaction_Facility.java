package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_transaction_facility")
@CrossOrigin
public class MedicalTransaction_Facility {

	public Long medicalTransactionId;
	public Long facilityid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMedicalTransactionId() {
		return medicalTransactionId;
	}
	public void setMedicalTransactionId(Long medicalTransactionId) {
		this.medicalTransactionId = medicalTransactionId;
	}
	public Long getFacilityid() {
		return facilityid;
	}
	public void setFacilityid(Long facilityid) {
		this.facilityid = facilityid;
	}
}
