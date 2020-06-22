package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_transactions")
@CrossOrigin
public class MedicalTransaction {

	public Long medicalTransactionId;
	public Long personId;
	public Long medicalEntityId;
	public Date medicalTransactionDate;
	public double amount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMedicalTransactionId() {
		return medicalTransactionId;
	}
	public void setMedicalTransactionId(Long medicalTransactionId) {
		this.medicalTransactionId = medicalTransactionId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Long getMedicalEntityId() {
		return medicalEntityId;
	}
	public void setMedicalEntityId(Long medicalEntityId) {
		this.medicalEntityId = medicalEntityId;
	}
	public Date getMedicalTransactionDate() {
		return medicalTransactionDate;
	}
	public void setMedicalTransactionDate(Date medicalTransactionDate) {
		this.medicalTransactionDate = medicalTransactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((medicalEntityId == null) ? 0 : medicalEntityId.hashCode());
		result = prime * result + ((medicalTransactionDate == null) ? 0 : medicalTransactionDate.hashCode());
		result = prime * result + ((medicalTransactionId == null) ? 0 : medicalTransactionId.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
		MedicalTransaction other = (MedicalTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (medicalEntityId == null) {
			if (other.medicalEntityId != null)
				return false;
		} else if (!medicalEntityId.equals(other.medicalEntityId))
			return false;
		if (medicalTransactionDate == null) {
			if (other.medicalTransactionDate != null)
				return false;
		} else if (!medicalTransactionDate.equals(other.medicalTransactionDate))
			return false;
		if (medicalTransactionId == null) {
			if (other.medicalTransactionId != null)
				return false;
		} else if (!medicalTransactionId.equals(other.medicalTransactionId))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}
}
