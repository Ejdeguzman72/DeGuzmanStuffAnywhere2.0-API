package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_transactions")
@CrossOrigin
public class MedicalTransaction {

	public Long medicalTransactionId;
	public String facillity;
	public String medicalTransactionDate;
	public double amount;
	public int transaction_type_id;
	public int person_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMedicalTransactionId() {
		return medicalTransactionId;
	}
	public void setMedicalTransactionId(Long medicalTransactionId) {
		this.medicalTransactionId = medicalTransactionId;
	}
	public String getFacillity() {
		return facillity;
	}
	public void setFacillity(String facillity) {
		this.facillity = facillity;
	}
	public String getMedicalTransactionDate() {
		return medicalTransactionDate;
	}
	public void setMedicalTransactionDate(String medicalTransactionDate) {
		this.medicalTransactionDate = medicalTransactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((facillity == null) ? 0 : facillity.hashCode());
		result = prime * result + ((medicalTransactionDate == null) ? 0 : medicalTransactionDate.hashCode());
		result = prime * result + ((medicalTransactionId == null) ? 0 : medicalTransactionId.hashCode());
		result = prime * result + person_id;
		result = prime * result + transaction_type_id;
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
		if (facillity == null) {
			if (other.facillity != null)
				return false;
		} else if (!facillity.equals(other.facillity))
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
		if (person_id != other.person_id)
			return false;
		if (transaction_type_id != other.transaction_type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MedicalTransaction [medicalTransactionId=" + medicalTransactionId + ", facillity=" + facillity
				+ ", medicalTransactionDate=" + medicalTransactionDate + ", amount=" + amount + ", transaction_type_id="
				+ transaction_type_id + ", person_id=" + person_id + "]";
	}
	public MedicalTransaction(Long medicalTransactionId, String facillity, String medicalTransactionDate, double amount,
			int transaction_type_id, int person_id) {
		super();
		this.medicalTransactionId = medicalTransactionId;
		this.facillity = facillity;
		this.medicalTransactionDate = medicalTransactionDate;
		this.amount = amount;
		this.transaction_type_id = transaction_type_id;
		this.person_id = person_id;
	}
	public MedicalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
